package vision;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.LocalizedObjectAnnotation;
import com.google.protobuf.ByteString;

@Component
public class VisionAPI {
	public ArrayList<String> vision(HttpServletRequest req, String path) {

		ArrayList<String> entityName = new ArrayList<String>();
		try {
			//환경변수에 저장된 json 키값 가져오기
			Storage storage = StorageOptions.getDefaultInstance().getService();

			System.out.println("Buckets:");
			Page<Bucket> buckets = storage.list();
			for (Bucket bucket : buckets.iterateAll()) {
				System.out.println(bucket.toString());
			}

			List<AnnotateImageRequest> requests = new ArrayList<>();
			
			//이미지 저장 경로 가져오기
			String imageFilePath =  req.getSession().getServletContext().getRealPath("resources/") + path;
			System.out.println(imageFilePath);

			ByteString imgBytes = ByteString.readFrom(new FileInputStream(imageFilePath));

			Image img = Image.newBuilder().setContent(imgBytes).build();
			AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
					.addFeatures(Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION)).setImage(img).build();
			requests.add(request);

			try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
				BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
				List<AnnotateImageResponse> responses = response.getResponsesList();

				for (AnnotateImageResponse res : responses) {
					for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
						System.out.format("Object name: %s%n", entity.getName());
						System.out.format("Confidence: %s%n", entity.getScore());
						System.out.format("Normalized Vertices:%n");
						entity.getBoundingPoly().getNormalizedVerticesList()
								.forEach(vertex -> System.out.format("- (%s, %s)%n", vertex.getX(), vertex.getY()));
						
						//번역-----------------------------------------------------------------------
						Translate translate = TranslateOptions.getDefaultInstance().getService();
						
						Translation translation =
							    translate.translate(
							    	entity.getName(),
							        Translate.TranslateOption.sourceLanguage("en"),
							        Translate.TranslateOption.targetLanguage("ko"),
							        // Use "base" for standard edition, "nmt" for the premium model.
							        Translate.TranslateOption.model("base"));
						
						//번역한 내용 전달
						if(translation.getTranslatedText().equals("주황색")) {
							entityName.add("오렌지");
						}else {
							entityName.add(translation.getTranslatedText());							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entityName;
	}
}
