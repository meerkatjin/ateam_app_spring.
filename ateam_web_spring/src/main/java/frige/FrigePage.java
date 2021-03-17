package frige;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class FrigePage extends PageVO {
	private List<FrigeVO> list;

	public List<FrigeVO> getList() {
		return list;
	}

	public void setList(List<FrigeVO> list) {
		this.list = list;
	}
	
	
}
