package member;

import java.util.HashMap;

public interface MemberService {
	boolean	member_join(MemberVO vo);	//회원가입 시 회원정보 저장
	boolean member_email_check(String user_email);	//회원가입 시 이메일 중복 확인
	MemberVO member_select(long user_id);	//마이페이지에서 회원정보 조회
	MemberVO member_login(HashMap<String, Object> map);	//회원 로그인
	int member_update(MemberVO vo);	//회원정보 수정
	int member_delete(long user_id);	//회원탈퇴
	boolean member_social_id(MemberVO vo);	//소셜로그인 시 아이디 존재 여부 확인
	boolean	member_social_join(MemberVO vo);	//소셜아이디로 회원가입
	boolean member_social_update(MemberVO vo);	//소셜아이디 회원정보 수정
	MemberVO member_find(String user_email);	//비밀번호 찾기
}
