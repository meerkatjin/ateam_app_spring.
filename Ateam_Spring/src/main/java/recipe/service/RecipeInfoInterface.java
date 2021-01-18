package recipe.service;

import java.util.List;

import recipe.dto.RecipeInfoDTO;
import user.dto.AppUserDTO;

public interface RecipeInfoInterface {
	List<RecipeInfoDTO> recipeInfo(int recipe_id);	
}
