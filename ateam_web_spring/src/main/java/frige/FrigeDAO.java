package frige;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FrigeDAO implements FrigeService {
	@Autowired private SqlSession sql;

	@Override
	public List<FrigeVO> frige_list(long user_id) {
		return sql.selectList("frige.mapper.frige_list", user_id);
	}

	@Override
	public FrigeVO frige_detail(int content_list_id) {
		return sql.selectOne("frige.mapper.frige_detail", content_list_id);
	}

	@Override
	public int frige_update(FrigeVO vo) {
		return sql.update("frige.mapper.frige_update", vo);
	}

	@Override
	public int frige_delete(int content_list_id) {
		return sql.delete("frige.mapper.frige_delete", content_list_id);
	}

	
	
}
