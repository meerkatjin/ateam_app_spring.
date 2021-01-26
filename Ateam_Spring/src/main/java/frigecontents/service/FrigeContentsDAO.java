package frigecontents.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.InsertDTO;

@Repository
public class FrigeContentsDAO implements FrigeContentsInterface {
	@Autowired @Qualifier("mappers") private SqlSession sql;
	
	//내 냉장고 목록에 식재료 정보 저장하기
	@Override
	public int irdntInsert(InsertDTO dto) {
		//System.out.println(dto.getContent_nm());
		//System.out.println(dto.getUser_id());

		int succ = sql.insert("frige.mapper.insert", dto);
		System.out.println(succ);
		return succ;
	}
	
	//내 식재료 정보 보여주기
	@Override
	public List<FrigeContentsDTO> irdntList(Long user_id) {
		List<FrigeContentsDTO> list = sql.selectList("frige.mapper.irdntList", user_id);
		return list;
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
