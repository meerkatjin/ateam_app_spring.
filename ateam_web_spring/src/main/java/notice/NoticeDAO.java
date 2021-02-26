package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.BoardVO;

@Repository
public class NoticeDAO implements NoticeService{
	
	@Autowired private SqlSession sql;

	@Override
	public void notice_insert(BoardVO vo) {
		sql.insert("notice.mapper.insert", vo);
	}


	@Override
	public List<BoardVO> notice_list() {
		// TODO Auto-generated method stub
		return sql.selectList("notice.mapper.list");
	}



	@Override
	public void notice_update(BoardVO vo) {
		sql.update("notice.mapper.update", vo);
		
	}


	@Override
	public void notice_delete(int board_no) {
		sql.delete("notice.mapper.delete", board_no);
		
	}

	@Override
	public NoticePage notice_list(NoticePage page) {
		page.setTotalList(sql.selectOne("notice.mapper.totalList", page));
		page.setList( sql.selectList("notice.mapper.list", page));
		return page;
	}


	@Override
	public BoardVO notice_view(int board_no) {
		// TODO Auto-generated method stub
		return sql.selectOne("notice.mapper.view", board_no);
	}


	@Override
	public void notice_read(int board_no) {
		sql.update("notice.mapper.read", board_no);
		
	}


	@Override
	public List<BoardVO> gethome() {
		return sql.selectList("notice.mapper.gethome");
	}


}
