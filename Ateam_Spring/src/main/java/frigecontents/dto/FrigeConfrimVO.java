package frigecontents.dto;

import java.io.Serializable;
import java.util.Date;

public class FrigeConfrimVO implements Serializable {
	private int content_list_id;
	private String content_nm;
	private String content_ty;
	private Date shelf_life_start;
	private Date shelf_life_end;
	
	public int getContent_list_id() {
		return content_list_id;
	}
	public void setContent_list_id(int content_list_id) {
		this.content_list_id = content_list_id;
	}
	public String getContent_nm() {
		return content_nm;
	}
	public void setContent_nm(String content_nm) {
		this.content_nm = content_nm;
	}
	public String getContent_ty() {
		return content_ty;
	}
	public void setContent_ty(String content_ty) {
		this.content_ty = content_ty;
	}
	public Date getShelf_life_start() {
		return shelf_life_start;
	}
	public void setShelf_life_start(Date shelf_life_start) {
		this.shelf_life_start = shelf_life_start;
	}
	public Date getShelf_life_end() {
		return shelf_life_end;
	}
	public void setShelf_life_end(Date shelf_life_end) {
		this.shelf_life_end = shelf_life_end;
	}
}
