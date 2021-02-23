package notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.BoardVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired private NoticeDAO dao;

	@Override
	public void notice_insert(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> notice_list() {
		// TODO Auto-generated method stub
		return dao.notice_list();
	}

	@Override
	public NoticePage notice_list(NoticePage page) {
		// TODO Auto-generated method stub
		return dao.notice_list(page);
	}

	@Override
	public List<BoardVO> notice_view(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notice_update(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notice_delete(int id) {
		// TODO Auto-generated method stub
		
	}

	

}
