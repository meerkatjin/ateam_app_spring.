package recipe;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class RecipePage extends PageVO {
	private List<RecipeInfoVO> list;

	public List<RecipeInfoVO> getList() {
		return list;
	}

	public void setList(List<RecipeInfoVO> list) {
		this.list = list;
	}
}
