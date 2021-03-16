package webview;

import java.util.List;

import org.springframework.stereotype.Component;

import common.BoardVO;
import common.PageVO;

@Component
public class WebViewPage extends PageVO{
	
	private List<BoardVO> list;
	private String gp;

	public String getGp() {
		return gp;
	}

	public void setGp(String gp) {
		this.gp = gp;
	}

	public List<BoardVO> getList() {
		return list;
	}

	public void setList(List<BoardVO> list) {
		this.list = list;
	}
}
