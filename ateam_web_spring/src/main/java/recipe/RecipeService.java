package recipe;

import java.util.List;

public interface RecipeService {
	RecipePage recipe_list(RecipePage page);	//레시피 페이지 리스트 뽑아내기
	List<RecipeIngVO> recipe_view(int id);	//레시피 세부 보기
	RecipeInfoVO recipe_select(int id);	//선택된 레시피 정보 가져오기
	List<RecipeIrdntVO> recipe_irdnt_get(int id);	//선택된 레시피의 재료 정보 가져오기
	void recipe_random_recommend();	//랜덤으로 추천레시피 뽑기
	List<RecipeInfoVO> recommend_list();	//
}
