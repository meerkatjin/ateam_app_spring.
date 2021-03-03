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
	public FrigeVO frige_detail(int content_list_id) {
		return dao.frige_detail(content_list_id);
	}

	
	
}
