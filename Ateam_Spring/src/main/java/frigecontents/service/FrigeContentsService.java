package frigecontents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frigecontents.dto.FrigeContentsDTO;

@Service
public class FrigeContentsService implements FrigeContentsInterface {
	@Autowired private FrigeContentsDAO dao;
	
	@Override
	public List<FrigeContentsDTO> sortType() {
		return dao.sortType();
	}
	
	@Override
	public List<FrigeContentsDTO> sortDate() {
		return dao.sortDate();
	}

	@Override
	public List<FrigeContentsDTO> sortName() {
		return dao.sortName();
	}

	@Override
	public int irdntInsert(String content_nm) {
		int state = -1;
		state = dao.irdntInsert(content_nm);
		return state;
	}

}
