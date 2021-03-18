package frigecontents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frigecontents.dto.FrigeConfrimVO;
import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.FrigeDeleteDTO;
import frigecontents.dto.FrigeViewDTO;

@Service
public class FrigeContentsService implements FrigeContentsInterface {
	@Autowired private FrigeContentsDAO dao;

	@Override
	public int irdntInsert(FrigeContentsDTO dto) {
		return dao.irdntInsert(dto);
	}
	
	@Override
	public List<FrigeContentsDTO> irdntListType(FrigeViewDTO dto) {
		return dao.irdntListType(dto);
	}

	@Override
	public List<FrigeContentsDTO> irdntListDate(Long user_id) {
		return dao.irdntListDate(user_id);
	}

	@Override
	public List<FrigeContentsDTO> irdntListName(Long user_id) {
		return dao.irdntListName(user_id);
	}

	@Override
	public int irdntListDelete(FrigeDeleteDTO dto) {
		int state = -1;
		state = dao.irdntListDelete(dto);
		System.out.println("Service " + state);
		return state;
	}

	@Override
	public int getLifeEndNum(long user_id) {
		return dao.getLifeEndNum(user_id);
	}

	@Override
	public List<Long> getLifeEndList(long user_id) {
		return dao.getLifeEndList(user_id);
	}

	@Override
	public List<FrigeContentsDTO> getLifeEndUsers() {
		return dao.getLifeEndUsers();
	}

	@Override
	public int getNewContentNum(long user_id) {
		return dao.getNewContentNum(user_id);
	}

	@Override
	public List<Long> getNewContentList(long user_id) {
		return dao.getNewContentList(user_id);
	}

	@Override
	public int irdntConfirm(FrigeConfrimVO vo) {
		return dao.irdntConfirm(vo);
	}

}
