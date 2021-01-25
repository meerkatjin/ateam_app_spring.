package frigecontents.service;

import java.util.List;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.InsertDTO;

public interface FrigeContentsInterface {
	int irdntInsert(InsertDTO dto);
	
	List<FrigeContentsDTO> sortType();
	List<FrigeContentsDTO> sortDate();
	List<FrigeContentsDTO> sortName();
	List<FrigeContentsDTO> irdntList(Long user_id);
}
