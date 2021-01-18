package recipe.service;

import org.springframework.beans.factory.annotation.Autowired;

import recipeinfo.dto.RecipeInfoDTO;
import user.dto.AppUserDTO;
import user.service.AppUserDAO;

//@Service 어노테이션 필요
public class RecipeInfoService implements RecipeInfoInterface {
	@Autowired private RecipeInfoDAO dao;
	
	@Override
	public RecipeInfoDTO recipeInfo(RecipeInfoDTO dto) {
		return dao.recipeInfo(dto);	//RecipeInfoDAO로
	}
}
