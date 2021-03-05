package vision;

import java.util.ArrayList;

public interface VisionService {
	void inputData(ArrayList<VisionVO> vos);
	VisionVO checkCount(String product_id);
}
