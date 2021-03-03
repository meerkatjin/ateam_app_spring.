package vision;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisionServiceImp implements VisionService {
@Autowired private VisionDAO dao;
	
	@Override
	public void inputData(ArrayList<VisionVO> vos) {
		dao.inputData(vos);
	}

}
