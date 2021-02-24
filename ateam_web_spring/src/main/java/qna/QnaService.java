package qna;

import java.util.List;

import common.BoardVO;
import notice.NoticePage;

public interface QnaService {
	
	void qna_insert(BoardVO vo);//질문글 저장
	List<BoardVO> qna_list();//질문글 조회
	NoticePage qna_list(NoticePage page);//질문글 페이지단위로 보기
	BoardVO qna_view(int board_no);//질문글 상세보기
	void qna_update(BoardVO vo);//질문글 변경저장
	void qna_delete(BoardVO vo);//질문글 삭제
	

}
