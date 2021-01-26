package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dto.AppUserDTO;

@Service
public class AppUserService implements UserServiceInterface {
	@Autowired private AppUserDAO dao;
	
	@Override
	public AppUserDTO appUserCheck(AppUserDTO dto) {
		return dao.appUserCheck(dto);
	}

	@Override
	public AppUserDTO appLogin(AppUserDTO dto) {
		return dao.appLogin(dto);
	}

	@Override
	public int userInfoModify(AppUserDTO dto) {
		return dao.userInfoModify(dto);
	}

	@Override
	public int appJoin(AppUserDTO dto) {
		return dao.appJoin(dto);
	}

	@Override
	public int appUserDelete(long user_id, String user_pw, String user_type) {
		return dao.appUserDelete(user_id, user_pw, user_type);
	}

	@Override
	public int appUserDelete(long user_id, String user_type) {
		return dao.appUserDelete(user_id, user_type);
	}

	@Override
	public List<AppUserDTO> getUserList() {
		return dao.getUserList();
	}

}
