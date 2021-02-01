package frigecontents.dto;

import java.io.Serializable;

public class FrigeDeleteDTO implements Serializable {
	private Long user_id;
	private int content_list_id;
	
	public FrigeDeleteDTO() {}

	public FrigeDeleteDTO(Long user_id, int content_list_id) {
		super();
		this.user_id = user_id;
		this.content_list_id = content_list_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getContent_list_id() {
		return content_list_id;
	}

	public void setContent_list_id(int content_list_id) {
		this.content_list_id = content_list_id;
	}
	
	
}
