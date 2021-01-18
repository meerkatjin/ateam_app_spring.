package recipe.service;

import org.springframework.beans.factory.annotation.Autowired;

import recipeinfo.dto.RecipeInfoDTO;
import user.dto.AppUserDTO;
import user.service.AppUserDAO;

public class RecipeInfoService implements RecipeInfoInterface {
	@Autowired private RecipeInfoDAO dao;
	
	@Override
	public RecipeInfoDTO recipeInfo(RecipeInfoDTO dto) {
		return dao.recipeInfo(dto);
	}
}
