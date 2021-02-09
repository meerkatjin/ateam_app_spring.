package recipe.service;

import java.util.List;

import recipe.dto.RecipeIngDTO;
import recipe.dto.RecipeIrdntDTO;

public interface RecipeIngInterface {
    List<RecipeIngDTO> recipeIng(int recipe_id );
    List<RecipeIrdntDTO> recipeIrdnt(int recipe_id);
}