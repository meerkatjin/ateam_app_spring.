package vision;

import java.util.ArrayList;

public interface VisionService {
	void inputData(ArrayList<VisionVO> vos);
	int checkCount(String product_id);
	String searchToken(String product_id);
}
