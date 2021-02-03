package search.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import frigecontents.dto.FrigeContentsDTO;
import recipe.dto.RecipeInfoDTO;
import search.dto.SearchDTO;

@Repository
public class SearchDAO implements SearchInterface {
	@Autowired @Qualifier("mappers") private SqlSession sql;

	@Override
	public List<RecipeInfoDTO> searchRecipe(String searchText) {
		System.out.println("DAO : " + searchText);
		List<RecipeInfoDTO> list = sql.selectList("search.mapper.searchRecipe", searchText);
		System.out.println(list.size());
		return list;
	}

	@Override
	public List<FrigeContentsDTO> searchIrdnt(SearchDTO dto) {
		//System.out.println("DAO : " + dto.getSearchText());
		//System.out.println("DAO : " + dto.getUser_id());
		List<FrigeContentsDTO> list = sql.selectList("search.mapper.searchIrdnt", dto);
		System.out.println(list.size());
		return list;
	}

}
