package board;

import java.util.List;

import common.BoardCommentVO;
import common.BoardVO;
import notice.NoticePage;

public interface BoardService {
	
	void board_insert(BoardVO vo);	// 게시판글 저장
	List<BoardVO> board_list();	//게시판글 조회
	NoticePage board_list(NoticePage page);//페이지단위로 게시판글목록조회
	BoardVO board_view(int board_no);	//게시판글 상세보기
	void board_read(int board_no);//게시판글 조회수
	void board_update(BoardVO vo);	//게시판글 변경저장
	void board_delete(int board_no);	//게시판글 삭제
	List<BoardVO> gethome();	//메인으로 가져오기
	
	int board_comment_insert(BoardCommentVO vo); //댓글저장처리
	List<BoardCommentVO> board_comment_list(int sub_parent_no); //댓글목록조회
	int board_comment_update(BoardCommentVO vo); //댓글변경저장처리
	int board_comment_delete(int board_no); //댓글삭제처리
}
