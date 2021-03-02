package qna;

import java.util.List;

import common.BoardCommentVO;
import common.BoardVO;
import notice.NoticePage;

public interface QnaService {
	
	void qna_insert(BoardVO vo);//질문글 저장
	List<BoardVO> qna_list();//질문글 조회
	NoticePage qna_list(NoticePage page);//질문글 페이지단위로 보기
	BoardVO qna_view(int board_no);//질문글 상세보기
	void qna_read(int board_no);//질문글 조회수
	void qna_update(BoardVO vo);//질문글 변경저장
	void qna_delete(int board_no);//질문글 삭제
	List<BoardVO> gethome();	//메인메뉴에서 조회
	
	void qna_reply_insert(BoardVO vo); //신규답글저장


}
