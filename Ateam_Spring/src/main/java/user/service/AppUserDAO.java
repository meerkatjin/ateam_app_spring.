package user.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import user.dto.AppUserDTO;

@Repository
public class AppUserDAO implements UserServiceInterface {
	@Autowired @Qualifier("ateam") private SqlSession sql;
	
	//회원가입
	@Override
	public int appJoin(AppUserDTO dto) {		
		return sql.insert("user.mapper.appJoin", dto);
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
	
	
	
}
