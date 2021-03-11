package frigecontents.dto;

import java.io.Serializable;

public class FrigeContentsDTO implements Serializable {
	int user_id, content_list_id;
	String content_nm, content_ty;
	String shelf_life_start, shelf_life_end;
	double x1, y1, x2, y2;
	String image_name, image_path;
	int num;
	String device_token;
	
	//public FrigeContentsDTO() {}
	
//	public FrigeContentsDTO(int num, String device_token) {
//		super();
//		this.num = num;
//		this.device_token = device_token;
//	}

//	public FrigeContentsDTO(int content_list_id, String content_nm, String content_ty, String shelf_life_start,
//			String shelf_life_end) {
//		super();
//		this.content_list_id = content_list_id;
//		this.content_nm = content_nm;
//		this.content_ty = content_ty;
//		this.shelf_life_start = shelf_life_start;
//		this.shelf_life_end = shelf_life_end;
//	}
//
//	public FrigeContentsDTO(int content_list_id, String content_nm, 
//			String content_ty,String shelf_life_start, String shelf_life_end,
//			String image_name, String image_path) {
//		super();
//		this.content_list_id = content_list_id;
//		this.content_nm = content_nm;
//		this.content_ty = content_ty;
//		this.shelf_life_start = shelf_life_start;
//		this.shelf_life_end = shelf_life_end;
//		this.image_name = image_name;
//		this.image_path = image_path;
//	}
//
//	public FrigeContentsDTO(int user_id, int content_list_id, String content_nm, String shelf_life_start,
//			String shelf_life_end, double x1, double y1, double x2, double y2) {
//		super();
//		this.user_id = user_id;
//		this.content_list_id = content_list_id;
//		this.content_nm = content_nm;
//		this.shelf_life_start = shelf_life_start;
//		this.shelf_life_end = shelf_life_end;
//		this.x1 = x1;
//		this.y1 = y1;
//		this.x2 = x2;
//		this.y2 = y2;
//	}
	
	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

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
