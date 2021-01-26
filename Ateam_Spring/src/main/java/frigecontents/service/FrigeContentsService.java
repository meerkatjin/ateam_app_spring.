package frigecontents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.InsertDTO;

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
	public int irdntInsert(InsertDTO dto) {
		int state = -1;
		state = dao.irdntInsert(dto);
		return state;
	}

	@Override
	public List<FrigeContentsDTO> irdntList(Long user_id) {
		return dao.irdntList(user_id);
	}

}
