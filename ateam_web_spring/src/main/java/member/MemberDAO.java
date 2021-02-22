package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService {
	@Autowired private SqlSession sql;

	@Override
	public boolean member_join(MemberVO vo) {
		return sql.insert("member.mapper.join", vo) > 0 ? true : false;
	}

	@Override
	public boolean member_email_check(String user_email) {
		return (Integer)sql.selectOne("member.mapper.email_check", user_email) == 0 ? false : true;
	}

	@Override
	public MemberVO member_select(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO member_login(HashMap<String, Object> map) {
		return sql.selectOne("member.mapper.login", map);
	}

	@Override
	public boolean member_update(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_delete(int user_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_social_id(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_social_join(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_social_update(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
