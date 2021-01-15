package user.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import user.dto.AppUserDTO;

@Repository
public class AppUserDAO implements UserServiceInterface {
	
	@Autowired @Qualifier("user") private SqlSession sql;

	/*
	 * private DataSource dataSource; private Connection connection; private
	 * PreparedStatement ps; private ResultSet rs;
	 * 
	 * public AppUserDAO() { try { Context context = new InitialContext();
	 * dataSource = (DataSource) context.lookup("java:/comp/env/ateam"); } catch
	 * (NamingException e) { e.getMessage(); } }
	 */

	//회원가입
	@Override
	public int appJoin(AppUserDTO dto) {		
		return sql.insert("user.mapper.appJoin", dto);
	}//appJoin()

	//로그인
	@Override
	public AppUserDTO appLogin(AppUserDTO dto) {
		/*
		 * AppUserDTO dto = null; try { connection = dataSource.getConnection(); String
		 * query = "select * from MST_USER_INFO_TB " +
		 * "where user_email = ? and user_pw = ?"; ps =
		 * connection.prepareStatement(query); ps.setString(1, email); ps.setString(2,
		 * pw); rs = ps.executeQuery();
		 * 
		 * while(rs.next()) { dto = new AppUserDTO();
		 * dto.setUser_id(rs.getInt("user_id"));
		 * dto.setUser_email(rs.getString("user_email"));
		 * dto.setUser_nm(rs.getString("user_nm"));
		 * dto.setUser_addr(rs.getString("user_addr"));
		 * dto.setUser_pro_img(rs.getString("user_pro_img"));
		 * dto.setUser_phone_no(rs.getString("user_phone_no"));
		 * dto.setUser_grade(rs.getString("user_grade")); }
		 * System.out.println("UserDTO email : " + dto.getUser_email()); }catch
		 * (Exception e) { e.printStackTrace();
		 * System.out.println("appLogin() Exception!!"); }finally { try {
		 * 
		 * if (rs != null) { rs.close(); } if (ps != null) { ps.close(); } if
		 * (connection != null) { connection.close(); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally {
		 * 
		 * } }
		 */
		return sql.selectOne("user.mapper.appLogin", dto);
	}//appLogin()
}
