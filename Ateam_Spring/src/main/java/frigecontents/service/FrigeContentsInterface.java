package frigecontents.service;

import java.util.List;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.FrigeViewDTO;
import frigecontents.dto.InsertDTO;

public interface FrigeContentsInterface {
	int irdntInsert(InsertDTO dto);
	
	List<FrigeContentsDTO> irdntListType(FrigeViewDTO dto);
	List<FrigeContentsDTO> irdntListDate(Long user_id);
	List<FrigeContentsDTO> irdntListName(Long user_id);
}
