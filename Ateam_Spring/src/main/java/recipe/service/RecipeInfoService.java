package recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.dto.RecipeInfoDTO;
import user.dto.AppUserDTO;
import user.service.AppUserDAO;

//@Service 어노테이션 필요
@Service
public class RecipeInfoService implements RecipeInfoInterface {
	@Autowired private RecipeInfoDAO dao;
	
	@Override
	public List<RecipeInfoDTO> recipeInfo() {
		return dao.recipeInfo();	//RecipeInfoDAO로
	}
	
	@Override
	public RecipeInfoDTO recipeInfoMf(int recipe_id) {
		return dao.recipeInfoMf(recipe_id);
	}
}
