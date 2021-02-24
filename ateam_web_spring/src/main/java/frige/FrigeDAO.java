package frige;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FrigeDAO implements FrigeService {
	@Autowired private SqlSession sql;

	@Override
	public List<FrigeVO> frige_list(int user_id) {
		return sql.selectList("frige.mapper.frige_list", user_id);
	}
	
}
