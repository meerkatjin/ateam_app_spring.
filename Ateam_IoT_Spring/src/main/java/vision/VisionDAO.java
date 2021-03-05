package vision;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VisionDAO implements VisionService {
	@Autowired private SqlSession sql;

	@Override
	public void inputData(ArrayList<VisionVO> vos) {
		for (VisionVO vo : vos) {
			sql.insert("vision.mapper.inputData", vo);
		}
	}

	@Override
	public VisionVO checkCount(String product_id) {
		return sql.selectOne("vision.mapper.checkCount", product_id);
	}
}
