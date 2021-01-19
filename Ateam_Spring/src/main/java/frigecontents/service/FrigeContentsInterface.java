package frigecontents.service;

import java.util.List;

import frigecontents.dto.FrigeContentsDTO;

public interface FrigeContentsInterface {
	int irdntInsert(FrigeContentsDTO dto);
	
	List<FrigeContentsDTO> sortType();
	List<FrigeContentsDTO> sortDate();
	List<FrigeContentsDTO> sortName();
}
