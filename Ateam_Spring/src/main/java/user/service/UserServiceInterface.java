package user.service;

import user.dto.AppUserDTO;

public interface UserServiceInterface {
	int appJoin(AppUserDTO dto);	//회원가입
	AppUserDTO appLogin(AppUserDTO dto);	//로그인
}
