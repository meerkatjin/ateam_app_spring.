package frige;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FrigeDAO implements FrigeService {
	@Autowired private SqlSession sql;

	@Override
	public List<FrigeVO> frige_list(long user_id) {
		return sql.selectList("frige.mapper.frige_list", user_id);
	}

	@Override
	public List<FrigeVO> frige_list_name(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrigeVO> frige_list_meat(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrigeVO> frige_list_fish(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrigeVO> frige_list_vege(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrigeVO> frige_list_fruit(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrigeVO> frige_list_dairy(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrigeVO> frige_list_grain(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrigeVO> frige_list_season(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrigeVO> frige_list_etc(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
