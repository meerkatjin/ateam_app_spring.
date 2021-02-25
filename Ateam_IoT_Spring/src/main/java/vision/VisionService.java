package vision;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.LocalizedObjectAnnotation;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;

@Component
public class VisionService {
	public ArrayList<String> vision(String imageFilePath, HttpServletRequest req) {
		
		ArrayList<String> entityName = new ArrayList<String>();
		try {
//			FileInputStream refreshToken = 
//					new FileInputStream(req.getSession().getServletContext()
//							.getRealPath("/resources/google")
//							+ "/refrigerator-75a035c3c225.json");
//			
//			GoogleCredentials credentials = GoogleCredentials.fromStream(refreshToken)
//			        .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//			Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//
//			System.out.println("Buckets:");
//			Page<Bucket> buckets = storage.list();
//			for (Bucket bucket : buckets.iterateAll()) {
//				System.out.println(bucket.toString());
//			}

			 Storage storage = StorageOptions.getDefaultInstance().getService();

			  System.out.println("Buckets:");
			  Page<Bucket> buckets = storage.list();
			  for (Bucket bucket : buckets.iterateAll()) {
			    System.out.println(bucket.toString());
			  }
			
			List<AnnotateImageRequest> requests = new ArrayList<>();
		
			ByteString imgBytes = ByteString.readFrom(new FileInputStream(imageFilePath));
		
			Image img = Image.newBuilder().setContent(imgBytes).build();
			AnnotateImageRequest request =
				      AnnotateImageRequest.newBuilder()
				          .addFeatures(Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION))
				          .setImage(img)
				          .build();
			requests.add(request);
		
			try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
				BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			    List<AnnotateImageResponse> responses = response.getResponsesList();
		
			    for (AnnotateImageResponse res : responses) {
			    	for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
			    		entityName.add(entity.getName());
			            System.out.format("Object name: %s%n", entity.getName());
			            System.out.format("Confidence: %s%n", entity.getScore());
			            System.out.format("Normalized Vertices:%n");
			            entity
			                .getBoundingPoly()
			                .getNormalizedVerticesList()
			                .forEach(vertex -> System.out.format("- (%s, %s)%n", vertex.getX(), vertex.getY()));
			          }
			    }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return entityName;
	}
}
