package qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.BoardCommentVO;
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
		return sql.selectOne("qna.mapper.view", board_no);
	}

	@Override
	public void qna_update(BoardVO vo) {
		sql.update("qna.mapper.update", vo);

	}

	@Override
	public void qna_delete(int board_no) {
		sql.delete("qna.mapper.delete", board_no);

	}

	@Override
	public void qna_read(int board_no) {
		sql.update("qna.mapper.read", board_no);
		
	}

	@Override
	public List<BoardVO> gethome() {
		return sql.selectList("qna.mapper.gethome");
	}

	@Override
	public void qna_reply_insert(BoardVO vo) {
		sql.insert("qna.mapper.reply_insert", vo);
		
	}


}
