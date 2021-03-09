package member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDAO dao;

	@Override
	public boolean member_join(MemberVO vo) {
		return dao.member_join(vo);
	}

	@Override
	public boolean member_email_check(String user_email) {
		return dao.member_email_check(user_email);
	}

	@Override
	public MemberVO member_select(long user_id) {
		return dao.member_select(user_id);
	}

	@Override
	public MemberVO member_login(HashMap<String, Object> map) {
		return dao.member_login(map);
	}

	@Override
	public boolean member_update(MemberVO vo) {
		return dao.member_update(vo);
	}

	@Override
	public boolean member_delete(int user_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_social_id(MemberVO vo) {
		return dao.member_social_id(vo);
	}

	@Override
	public boolean member_social_join(MemberVO vo) {
		return dao.member_social_join(vo);
	}

	@Override
	public boolean member_social_update(MemberVO vo) {
		return false;
	}

}
