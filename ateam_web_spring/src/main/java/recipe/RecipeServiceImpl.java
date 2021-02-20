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

}
