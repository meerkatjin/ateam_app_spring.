package frige;

import java.io.Serializable;

public class FrigeVO implements Serializable {
	private int user_id, content_list_id;
	private String content_nm, content_ty;
	private String shelf_life_start, shelf_life_end;
	private double x1, y1, x2, y2;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
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
	public String getShelf_life_start() {
		return shelf_life_start;
	}
	public void setShelf_life_start(String shelf_life_start) {
		this.shelf_life_start = shelf_life_start;
	}
	public String getShelf_life_end() {
		return shelf_life_end;
	}
	public void setShelf_life_end(String shelf_life_end) {
		this.shelf_life_end = shelf_life_end;
	}
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getY1() {
		return y1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public double getY2() {
		return y2;
	}
	public void setY2(double y2) {
		this.y2 = y2;
	}
	
}
