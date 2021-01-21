package recipe.service;

import java.util.List;

import recipe.dto.RecipeIngDTO;

public interface RecipeIngInterface {
	List<RecipeIngDTO> recipeIng(RecipeIngDTO dto);
}
