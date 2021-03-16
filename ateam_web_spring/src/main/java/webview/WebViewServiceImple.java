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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void webview_read(int board_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void webview_update(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void webview_delete(int board_no) {
		// TODO Auto-generated method stub
		
	}

}
