package qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.BoardVO;
import notice.NoticePage;

@Repository
public class QnaDAO implements QnaService {
	
	@Autowired private SqlSession sql;

	@Override
	public void qna_insert(BoardVO vo) {
		sql.insert("qna.mapper.insert", vo);

	}

	@Override
	public List<BoardVO> qna_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticePage qna_list(NoticePage page) {
		page.setTotalList( sql.selectOne("qna.mapper.totalList", page) );
		page.setList( sql.selectList("qna.mapper.list", page) );
		return page;
	}

	@Override
	public BoardVO qna_view(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void qna_update(BoardVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void qna_delete(BoardVO vo) {
		// TODO Auto-generated method stub

	}

}
