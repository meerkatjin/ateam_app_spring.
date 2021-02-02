package frigecontents.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.FrigeDeleteDTO;
import frigecontents.dto.FrigeViewDTO;
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
	
	//내 식재료 정보 보여주기(종류별)
	@Override
	public List<FrigeContentsDTO> irdntListType(FrigeViewDTO dto) {
		System.out.println(dto.getContent_ty());
		System.out.println(dto.getUser_id());
		
		List<FrigeContentsDTO> list = sql.selectList("frige.mapper.irdntListType", dto);
		return list;
	}
	
	//내 식재료 정보 보여주기(유통기한순)
	@Override
	public List<FrigeContentsDTO> irdntListDate(Long user_id) {
		List<FrigeContentsDTO> list = sql.selectList("frige.mapper.irdntListDate", user_id);
		return list;
	}

	//내 식재료 정보 보여주기(이름순)
	@Override
	public List<FrigeContentsDTO> irdntListName(Long user_id) {
		List<FrigeContentsDTO> list = sql.selectList("frige.mapper.irdntListName", user_id);
		return list;
	}

	//내 식재료 삭제하기
	@Override
	public int irdntListDelete(FrigeDeleteDTO dto) {		
		int succ = sql.delete("frige.mapper.delete", dto);
		System.out.println("DAO " + succ);
		return succ;
	}

	@Override
	public int getLifeEndNum(long user_id) {
		return sql.selectOne("frige.mapper.getLifeEndNum", user_id);
	}
	
}
