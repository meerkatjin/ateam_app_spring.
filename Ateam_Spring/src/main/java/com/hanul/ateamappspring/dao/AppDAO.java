package com.hanul.ateamappspring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hanul.ateamappspring.dto.UserDTO;

public class AppDAO {

	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	public AppDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/ateam");
		} catch (NamingException e) {
			e.getMessage();
		}
	}

	//회원가입
	public int appJoin(UserDTO dto) {		
		int state = -100;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into MST_USER_INFO_TB(user_email, user_pw, user_nm, user_addr, user_phone_no) "
					+ "values(?,?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setString(1, dto.getUser_email());
			ps.setString(2, dto.getUser_pw());
			ps.setString(3, dto.getUser_nm());
			ps.setString(4, dto.getUser_addr());
			ps.setString(5, dto.getUser_phone_no());
			state = ps.executeUpdate();
			
			if (state > 0) {
				System.out.println(state + "삽입성공");				
			} else {
				System.out.println(state + "삽입실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("appJoinException!!");
		}finally {
			try {				
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}	

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
		return state;
	}//appJoin()

	//로그인
	public UserDTO appLogin(String email, String pw) {
		UserDTO dto = null;
		try {
			connection = dataSource.getConnection();
			String query = "select * from MST_USER_INFO_TB "
					+ "where user_email = ? and user_pw = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new UserDTO();
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_nm(rs.getString("user_nm"));
				dto.setUser_addr(rs.getString("user_addr"));
				dto.setUser_phone_no(rs.getString("user_phone_no"));
			}
			System.out.println("UserDTO email : " + dto.getUser_email());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("appLogin() Exception!!");
		}finally {
			try {			
				
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}	

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
		return dto;
	}//appLogin()
}
