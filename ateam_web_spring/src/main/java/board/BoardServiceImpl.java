package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.BoardCommentVO;
import common.BoardVO;
import notice.NoticePage;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired private BoardDAO dao;

	@Override
	public void board_insert(BoardVO vo) {
		dao.board_insert(vo);

	}

	@Override
	public List<BoardVO> board_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticePage board_list(NoticePage page) {
		// TODO Auto-generated method stub
		return dao.board_list(page);
	}

	@Override
	public BoardVO board_view(int board_no) {
		// TODO Auto-generated method stub
		return dao.board_view(board_no);
	}

	@Override
	public void board_read(int board_no) {
		dao.board_read(board_no);

	}

	@Override
	public void board_update(BoardVO vo) {
		dao.board_update(vo);

	}

	@Override
	public void board_delete(int board_no) {
		dao.board_delete(board_no);

	}

	@Override
	public List<BoardVO> gethome() {
		return dao.gethome();
	}

	@Override
	public int board_comment_insert(BoardCommentVO vo) {
		// TODO Auto-generated method stub
		return dao.board_comment_insert(vo);
	}

	@Override
	public List<BoardCommentVO> board_comment_list(int sub_parent_no) {
		return dao.board_comment_list(sub_parent_no);
	}

	@Override
	public int board_comment_update(BoardCommentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_comment_delete(int board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
