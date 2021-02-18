package notice;

import java.util.List;

import org.springframework.stereotype.Component;

import common.CommuVO;
import common.PageVO;

@Component
public class NoticePage extends PageVO{
	
	private List<CommuVO> list;

	public List<CommuVO> getList() {
		return list;
	}

	public void setList(List<CommuVO> list) {
		this.list = list;
	}
	
	

}
