package recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.PageVO;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired private RecipeDAO dao;

	@Override
	public RecipePage recipe_list(RecipePage page) {
		return dao.recipe_list(page);
	}

	@Override
	public List<RecipeIngVO> recipe_view(int id) {
		return dao.recipe_view(id);
	}

	@Override
	public RecipeInfoVO recipe_select(int id) {
		return dao.recipe_select(id);
	}

	@Override
	public List<RecipeIrdntVO> recipe_irdnt_get(int id) {
		return dao.recipe_irdnt_get(id);
	}

}
