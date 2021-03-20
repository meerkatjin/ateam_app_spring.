package webview;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.BoardVO;

@Repository
public class WebViewDAO implements WebViewService {
	@Autowired private SqlSession sql;

	@Override
	public void webview_insert(BoardVO vo) {
		sql.insert("webview.mapper.insert", vo);
	}

	@Override
	public List<BoardVO> webview_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebViewPage webview_list(WebViewPage page) {
		page.setTotalList(sql.selectOne("webview.mapper.totalList", page));
		page.setList( sql.selectList("webview.mapper.list", page));
		return page;
	}

	@Override
	public BoardVO webview_view(int board_no) {
		return sql.selectOne("webview.mapper.view", board_no);
	}

	@Override
	public void webview_read(int board_no) {
		sql.update("webview.mapper.read", board_no);
	}

	@Override
	public void webview_update(BoardVO vo) {
		sql.update("webview.mapper.update", vo);
	}

	@Override
	public void webview_delete(int board_no) {
		sql.delete("webview.mapper.delete",board_no);
	}

}
