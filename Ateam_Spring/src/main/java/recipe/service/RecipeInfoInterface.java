package recipe.service;

import java.util.List;

import recipe.dto.RecipeInfoDTO;
import user.dto.AppUserDTO;

public interface RecipeInfoInterface {
	List<RecipeInfoDTO> recipeInfo();	//레시피 프래그먼트
	RecipeInfoDTO recipeInfoMf(int recipe_id);	//매인 프래그먼트에서 레시피 띄우기
	
}
