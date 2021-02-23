package frige;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FrigeDAO implements FrigeService {
	@Autowired private SqlSession sql;
	
}
