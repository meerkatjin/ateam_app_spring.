package com.hanul.ateamappspring.command;

import org.springframework.ui.Model;

import com.hanul.ateamappspring.dao.AppDAO;
import com.hanul.ateamappspring.dto.UserDTO;

public class AppJoinCommand implements AppCommand {

	@Override
	public void execute(Model model) {
		String email = (String)model.asMap().get("email");
		String pw = (String)model.asMap().get("pw");
		String name = (String)model.asMap().get("name");
		String addr = (String)model.asMap().get("addr");
		String phone_no = (String)model.asMap().get("phone_no");
		UserDTO dto = new UserDTO(email, pw, name, addr, phone_no);
		
		System.out.println(email);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(addr);
		System.out.println(phone_no);
		
		AppDAO dao = new AppDAO();
		int state = dao.appJoin(dto);
		
		model.addAttribute("appJoin", String.valueOf(state));
	}

}
