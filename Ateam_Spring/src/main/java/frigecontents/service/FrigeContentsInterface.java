package frigecontents.service;

import java.util.List;

import frigecontents.dto.FrigeContentsDTO;

public interface FrigeContentsInterface {
	int irdntInsert(String content_nm);
	
	List<FrigeContentsDTO> sortType();
	List<FrigeContentsDTO> sortDate();
	List<FrigeContentsDTO> sortName();
	List<FrigeContentsDTO> irdntList();
}
