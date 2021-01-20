package user.service;

import user.dto.AppUserDTO;

public interface UserServiceInterface {
	int appJoin(AppUserDTO dto);	//�쉶�썝媛��엯
	AppUserDTO appLogin(AppUserDTO dto);	//濡쒓렇�씤
	int userInfoModify(AppUserDTO dto);
}
