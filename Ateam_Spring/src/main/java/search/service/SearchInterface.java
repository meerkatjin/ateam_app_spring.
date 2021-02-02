package search.service;

import java.util.List;

import frigecontents.dto.FrigeContentsDTO;
import recipe.dto.RecipeInfoDTO;
import search.dto.SearchDTO;

public interface SearchInterface {
	List<FrigeContentsDTO> searchIrdnt(SearchDTO dto);
	List<RecipeInfoDTO> searchRecipe(String searchText);
}
