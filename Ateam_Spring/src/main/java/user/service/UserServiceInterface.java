package user.service;

import user.dto.AppUserDTO;

public interface UserServiceInterface {
	AppUserDTO appUserCheck(AppUserDTO dto);	//회원가입 전 중복 계정이 있는지 확인
	int appJoin(AppUserDTO dto);			//회원가입
	AppUserDTO appLogin(AppUserDTO dto);	//로그인
	int userInfoModify(AppUserDTO dto);		//회원 정보 수정
	int appUserDelete(long user_id, String user_pw, String user_type);
	int appUserDelete(long user_id, String user_type);
}
