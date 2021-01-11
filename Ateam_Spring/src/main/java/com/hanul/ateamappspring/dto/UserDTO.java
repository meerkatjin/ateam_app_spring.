package com.hanul.ateamappspring.dto;

public class UserDTO {
	private String user_email,
				user_pw,
				user_nm,
				user_addr,
				user_pro_img,
				user_phone_no,
				user_grade;
	
	//깡통생성자
	public UserDTO() {}

	//회원가입 정보 저장
	public UserDTO(String user_email, String user_pw, String user_nm, String user_addr,
			String user_phone_no) {
		super();
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.user_nm = user_nm;
		this.user_addr = user_addr;
		this.user_phone_no = user_phone_no;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public String getUser_pro_img() {
		return user_pro_img;
	}

	public void setUser_pro_img(String user_pro_img) {
		this.user_pro_img = user_pro_img;
	}

	public String getUser_phone_no() {
		return user_phone_no;
	}

	public void setUser_phone_no(String user_phone_no) {
		this.user_phone_no = user_phone_no;
	}

	public String getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}

}
