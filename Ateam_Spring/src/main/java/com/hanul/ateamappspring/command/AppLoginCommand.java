package com.hanul.ateamappspring.command;

import org.springframework.ui.Model;

import com.hanul.ateamappspring.dao.AppDAO;
import com.hanul.ateamappspring.dto.UserDTO;

public class AppLoginCommand implements AppCommand {

	@Override
	public void execute(Model model) {
		String email = (String)model.asMap().get("email");
		String pw = (String)model.asMap().get("pw");
		
		AppDAO dao = new AppDAO();
		UserDTO dto = dao.appLogin(email, pw);
		
		model.addAttribute("appLogin", dto);
	}

}
