package search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frigecontents.dto.FrigeContentsDTO;
import recipe.dto.RecipeInfoDTO;
import search.dto.SearchDTO;

@Service
public class SearchService implements SearchInterface {
	@Autowired private SearchDAO dao;

	@Override
	public List<RecipeInfoDTO> searchRecipe(String searchText) {
		return dao.searchRecipe(searchText);
	}

	@Override
	public List<FrigeContentsDTO> searchIrdnt(SearchDTO dto) {
		return dao.searchIrdnt(dto);
	}

}
