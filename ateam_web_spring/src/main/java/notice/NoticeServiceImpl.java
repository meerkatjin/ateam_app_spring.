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
		dao.notice_insert(vo);
		
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
	public BoardVO notice_view(int board_no) {
		// TODO Auto-generated method stub
		return dao.notice_view(board_no);
	}

	@Override
	public void notice_update(BoardVO vo) {
		dao.notice_update(vo);
		
	}

	@Override
	public void notice_delete(int board_no) {
		dao.notice_delete(board_no);
		
	}

	

}
