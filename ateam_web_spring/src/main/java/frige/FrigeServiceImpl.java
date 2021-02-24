package frige;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrigeServiceImpl implements FrigeService {
	@Autowired private FrigeDAO dao;

	@Override
	public List<FrigeVO> frige_list(int user_id) {
		return dao.frige_list(user_id);
	}
	
}
