package qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.BoardVO;
import notice.NoticePage;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired private QnaDAO dao;

	@Override
	public void qna_insert(BoardVO vo) {
		dao.qna_insert(vo);

	}

	@Override
	public List<BoardVO> qna_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticePage qna_list(NoticePage page) {
		// TODO Auto-generated method stub
		return dao.qna_list(page);
	}

	@Override
	public BoardVO qna_view(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void qna_update(BoardVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void qna_delete(BoardVO vo) {
		// TODO Auto-generated method stub

	}

}
