package frigecontents.service;

import java.util.List;

import frigecontents.dto.FrigeConfrimVO;
import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.FrigeDeleteDTO;
import frigecontents.dto.FrigeViewDTO;

public interface FrigeContentsInterface {
	int irdntInsert(FrigeContentsDTO dto);
	
	List<FrigeContentsDTO> irdntListType(FrigeViewDTO dto);
	List<FrigeContentsDTO> irdntListDate(Long user_id);
	List<FrigeContentsDTO> irdntListName(Long user_id);
	
	int irdntListDelete(FrigeDeleteDTO dto);
	
	int getLifeEndNum(long user_id);
	List<Long> getLifeEndList(long user_id);
	
	List<FrigeContentsDTO> getLifeEndUsers();
	
	int getNewContentNum(long user_id);	
	List<Long> getNewContentList(long user_id);
	
	int irdntConfirm(FrigeConfrimVO vo);
}
