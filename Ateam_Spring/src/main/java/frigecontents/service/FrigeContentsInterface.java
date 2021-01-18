package frigecontents.service;

import java.util.List;

import frigecontents.dto.FrigeContentsDTO;

public interface FrigeContentsInterface {
	int irdntInsert(FrigeContentsDTO dto);
	List<FrigeContentsDTO> sortDate();
}
