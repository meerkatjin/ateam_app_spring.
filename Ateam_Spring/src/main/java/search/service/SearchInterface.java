package search.service;

import java.util.List;

import frigecontents.dto.FrigeContentsDTO;
import recipe.dto.RecipeInfoDTO;

public interface SearchInterface {
	List<FrigeContentsDTO> searchIrdnt();
	List<RecipeInfoDTO> searchRecipe(String searchText);
}
