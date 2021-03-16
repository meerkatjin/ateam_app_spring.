package webview;

import java.util.List;

import common.BoardVO;

public interface WebViewService {
	void webview_insert(BoardVO vo);	//글 저장
	List<BoardVO> webview_list();	//글 조회
	WebViewPage webview_list(WebViewPage page);//페이지단위로 글목록조회
	BoardVO webview_view(int board_no);	//글 상세보기
	void webview_read(int board_no);//글 조회수
	void webview_update(BoardVO vo);	//글 변경저장
	void webview_delete(int board_no);	//글 삭제
}
