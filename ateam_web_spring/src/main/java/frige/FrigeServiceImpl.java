package frige;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrigeServiceImpl implements FrigeService {
	@Autowired private FrigeDAO dao;

	@Override
	public List<FrigeVO> frige_list(long user_id) {
		return dao.frige_list(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_name(long user_id) {
		return dao.frige_list_name(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_meat(long user_id) {
		return dao.frige_list_meat(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_fish(long user_id) {
		return dao.frige_list_fish(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_vege(long user_id) {
		return dao.frige_list_vege(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_fruit(long user_id) {
		return dao.frige_list_fruit(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_dairy(long user_id) {
		return dao.frige_list_dairy(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_grain(long user_id) {
		return dao.frige_list_grain(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_season(long user_id) {
		return dao.frige_list_season(user_id);
	}

	@Override
	public List<FrigeVO> frige_list_etc(long user_id) {
		return dao.frige_list_etc(user_id);
	}
	
}
