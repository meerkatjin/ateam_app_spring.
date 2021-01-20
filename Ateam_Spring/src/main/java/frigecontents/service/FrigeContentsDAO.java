package frigecontents.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import frigecontents.dto.FrigeContentsDTO;

@Repository
public class FrigeContentsDAO implements FrigeContentsInterface {
	@Autowired @Qualifier("frige") private SqlSession sql;
	
	//내 냉장고 목록에 식재료 정보 저장하기
	@Override
	public int irdntInsert(String content_nm) {
		return sql.insert("frige.mapper.insert", content_nm);
	}
	
	//종류별로 가져오기
	@Override
	public List<FrigeContentsDTO> sortType() {
		return sql.selectList("frige.mapper.sortType");
	}

	//유통기한순으로 가져오기
	@Override
	public List<FrigeContentsDTO> sortDate() {
		return sql.selectList("frige.mapper.sortDate");
	}

	//이름순으로 가져오기
	@Override
	public List<FrigeContentsDTO> sortName() {
		return sql.selectList("frige.mapper.sortName");
	}

}
