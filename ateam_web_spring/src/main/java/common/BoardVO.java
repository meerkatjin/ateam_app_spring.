package common;

import java.util.Date;

public class BoardVO {
	
//	BOARD_GP        NOT NULL VARCHAR2(2)    
//	BOARD_NO        NOT NULL NUMBER         
//	USER_ID         NOT NULL NUMBER         
//	CREATE_DT       NOT NULL DATE           
//	UPDATE_DT                DATE           
//	BOARD_READCOUNT NOT NULL NUMBER         
//	BOARD_TITLE     NOT NULL VARCHAR2(20)   
//	BOARD_CONTENT   NOT NULL VARCHAR2(4000) 
//	USER_TYPE                VARCHAR2(20)   

	private long user_id;
	private int board_no, board_readcount, no;
	private String board_gp, board_title, board_content, user_type, filename, filepath, name;
	private Date create_dt, update_dt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public int getBoard_readcount() {
		return board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public String getBoard_gp() {
		return board_gp;
	}
	public void setBoard_gp(String board_gp) {
		this.board_gp = board_gp;
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
