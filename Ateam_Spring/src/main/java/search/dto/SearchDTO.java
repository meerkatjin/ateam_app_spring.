package search.dto;

import java.io.Serializable;

public class SearchDTO implements Serializable {
	private String searchText;
	private Long user_id;
	
	public SearchDTO() {}
	

	public SearchDTO(String searchText, Long user_id) {
		super();
		this.searchText = searchText;
		this.user_id = user_id;
	}


	public String getSearchText() {
		return searchText;
	}


	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	

}
