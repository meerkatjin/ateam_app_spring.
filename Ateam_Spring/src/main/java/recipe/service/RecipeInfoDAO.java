package recipe.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import recipeinfo.dto.RecipeInfoDTO;


public class RecipeInfoDAO implements RecipeInfoInterface {
@Autowired @Qualifier("recipe") private SqlSession sql;
	
	@Override
	public RecipeInfoDTO recipeInfo(RecipeInfoDTO dto) {		
		return (RecipeInfoDTO) sql.selectList("user.mapper.recipeInfo", dto);
	}//recipeInfo()
}
