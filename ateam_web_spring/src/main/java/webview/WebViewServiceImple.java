package webview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.BoardVO;

@Service
public class WebViewServiceImple implements WebViewService {
	@Autowired private WebViewDAO dao;
	
	@Override
	public void webview_insert(BoardVO vo) {
		dao.webview_insert(vo);
	}

	@Override
	public List<BoardVO> webview_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebViewPage webview_list(WebViewPage page) {
		return dao.webview_list(page);
	}

	@Override
	public BoardVO webview_view(int board_no) {
		return dao.webview_view(board_no);
	}

	@Override
	public void webview_read(int board_no) {
		dao.webview_read(board_no);
	}

	@Override
	public void webview_update(BoardVO vo) {
		dao.webview_update(vo);
	}

	@Override
	public void webview_delete(int board_no) {
		dao.webview_delete(board_no);
	}

}
