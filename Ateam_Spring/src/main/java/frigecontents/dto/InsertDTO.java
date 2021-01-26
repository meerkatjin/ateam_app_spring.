package frigecontents.dto;

import java.io.Serializable;

public class InsertDTO implements Serializable {
	private String content_nm;
	private Long user_id;
	
	public InsertDTO() {}

	public InsertDTO(String content_nm, Long user_id) {
		super();
		this.content_nm = content_nm;
		this.user_id = user_id;
	}

	public String getContent_nm() {
		return content_nm;
	}

	public void setContent_nm(String content_nm) {
		this.content_nm = content_nm;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
}
