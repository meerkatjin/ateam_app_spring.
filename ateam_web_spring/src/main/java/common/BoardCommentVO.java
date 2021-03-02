package common;

public class BoardCommentVO {
	
//	SUB_NO	NUMBER
//	BOARD_NO	NUMBER
//	SUB_PARENT_NO	NUMBER
//	USER_ID	NUMBER
//	SUB_CONTENT	VARCHAR2(2000 BYTE)
//	CREATE_DT	DATE
//	UPDATE_DT	DATE
//	USER_TYPE	VARCHAR2(20 BYTE)
	
	private long user_id;
	private int sub_no, board_no, sub_parent_no;
	private String sub_content, user_type, create_dt, update_dt, sub_writer;
	
	public String getSub_writer() {
		return sub_writer;
	}
	public void setSub_writer(String sub_writer) {
		this.sub_writer = sub_writer;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public int getSub_no() {
		return sub_no;
	}
	public void setSub_no(int sub_no) {
		this.sub_no = sub_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getSub_parent_no() {
		return sub_parent_no;
	}
	public void setSub_parent_no(int sub_parent_no) {
		this.sub_parent_no = sub_parent_no;
	}
	public String getSub_content() {
		return sub_content;
	}
	public void setSub_content(String sub_content) {
		this.sub_content = sub_content;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	

	
	

}
