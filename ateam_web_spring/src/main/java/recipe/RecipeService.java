package recipe;

import java.util.List;

import common.PageVO;

public interface RecipeService {
	RecipePage recipe_list(RecipePage page);	//레시피 페이지 리스트 뽑아내기
	List<RecipeIngVO> recipe_view(int id);	//레시피 세부 보기
}
