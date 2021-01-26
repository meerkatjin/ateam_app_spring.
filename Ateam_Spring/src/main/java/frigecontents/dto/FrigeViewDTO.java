package frigecontents.dto;

import java.io.Serializable;

public class FrigeViewDTO implements Serializable {
	private Long user_id;
	private String content_ty;
	
	public FrigeViewDTO() {}
	
	public FrigeViewDTO(Long user_id, String content_ty) {
		super();
		this.user_id = user_id;
		this.content_ty = content_ty;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getContent_ty() {
		return content_ty;
	}

	public void setContent_ty(String content_ty) {
		this.content_ty = content_ty;
	}
	
	

}
