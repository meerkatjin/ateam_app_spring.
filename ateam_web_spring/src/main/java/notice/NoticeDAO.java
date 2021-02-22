package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.CommuVO;

@Repository
public class NoticeDAO implements NoticeService{
	
	@Autowired private SqlSession sql;

	@Override
	public void notice_insert(CommuVO vo) {
		sql.insert("notice.mapper.insert", vo);
		
	}

	@Override
	public List<CommuVO> notice_list() {
		// TODO Auto-generated method stub
		return sql.selectList("notice.mapper.list");
	}

	@Override
	public List<CommuVO> notice_view(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notice_update(CommuVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notice_delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NoticePage notice_list(NoticePage page) {
		page.setTotalList(sql.selectOne("notice.mapper.totalList", page));
		page.setList( sql.selectList("notice.mapper.list", page));
		return page;
	}

}
