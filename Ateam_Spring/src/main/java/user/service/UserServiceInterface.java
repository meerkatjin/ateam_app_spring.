package user.service;

import user.dto.AppUserDTO;

public interface UserServiceInterface {
	AppUserDTO appUserCheck(AppUserDTO dto);	//회원가입 전 중복 계정이 있는지 확인
	int appJoin(AppUserDTO dto);
	AppUserDTO appLogin(AppUserDTO dto);	//로그인
	int userInfoModify(AppUserDTO dto);		//유저 정보 수정
}
