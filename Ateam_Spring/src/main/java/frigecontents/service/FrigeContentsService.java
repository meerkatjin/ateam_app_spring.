package frigecontents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frigecontents.dto.FrigeContentsDTO;

@Service
public class FrigeContentsService implements FrigeContentsInterface {
	@Autowired private FrigeContentsDAO dao;

	@Override
	public List<FrigeContentsDTO> sortDate() {
		return dao.sortDate();
	}

	@Override
	public int irdntInsert(FrigeContentsDTO dto) {
		int state = -1;
		state = dao.irdntInsert(dto);
		return state;
	}
	
	
	
}
