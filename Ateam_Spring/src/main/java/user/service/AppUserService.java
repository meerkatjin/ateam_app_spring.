package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dto.AppUserDTO;

@Service
public class AppUserService implements UserServiceInterface {
	@Autowired private AppUserDAO dao;
	
	@Override
	public int appJoin(AppUserDTO dto) {
		int state = -100;
		state = dao.appJoin(dto);
		return state;
	}

	@Override
	public AppUserDTO appLogin(AppUserDTO dto) {
		return dao.appLogin(dto);
	}

}
