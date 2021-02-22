package common;

import java.sql.Date;

public class CommuVO {
	
//	BOARD_GP	VARCHAR2(2 BYTE)
//	BOARD_NO	NUMBER
//	USER_ID	NUMBER
//	CREATE_DT	DATE
//	UPDATE_DT	DATE
//	BOARD_READCOUNT	NUMBER
//	BOARD_TITLE	VARCHAR2(20 BYTE)
//	BOARD_CONTENT	VARCHAR2(4000 BYTE)
//	USER_TYPE	VARCHAR2(20 BYTE)
	
	private String board_qp, board_title, board_content, user_type, name;
	private int board_no, user_id, board_readcount, no;
	private Date create_dt, update_dt;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBoard_qp() {
		return board_qp;
	}
	public void setBoard_qp(String board_qp) {
		this.board_qp = board_qp;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBoard_readcount() {
		return board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public Date getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
	}
	public Date getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}
	
	

}
