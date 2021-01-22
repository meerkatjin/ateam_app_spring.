package user.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import user.dto.AppUserDTO;

@Repository
public class AppUserDAO implements UserServiceInterface {
	@Autowired @Qualifier("user") private SqlSession sql;
	
	//회원가입 중복체크
	@Override
	public AppUserDTO appUserCheck(AppUserDTO dto) {		
		return sql.selectOne("user.mapper.appUserCheck", dto);
	}//appJoin()

	//로그인
	@Override
	public AppUserDTO appLogin(AppUserDTO dto) {
		return sql.selectOne("user.mapper.appLogin", dto);
	}//appLogin()

	//회원정보수정
	@Override
	public int userInfoModify(AppUserDTO dto) {
		return sql.update("user.mapper.userInfoModify", dto);
	}

	//회원가입
	@Override
	public int appJoin(AppUserDTO dto) {
		if(dto.getUser_id() == 0) {
			long number = sql.selectOne("user.mapper.numbering",dto);
			dto.setUser_id(number+1);
		}
		
		return sql.insert("user.mapper.appJoin",dto);
	}

	@Override
	public int appUserDelete(long user_id, String user_pw, String user_type) {
		AppUserDTO dto = new AppUserDTO();
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		dto.setUser_type(user_type);
		return sql.delete("user.mapper.appUserDelete", dto);
	}

	@Override
	public int appUserDelete(long user_id, String user_type) {
		AppUserDTO dto = new AppUserDTO();
		dto.setUser_id(user_id);
		dto.setUser_type(user_type);
		return sql.delete("user.mapper.appUserDelete", dto);
	}
}
