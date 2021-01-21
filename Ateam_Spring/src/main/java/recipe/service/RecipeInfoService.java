package recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.dto.RecipeInfoDTO;
import user.dto.AppUserDTO;
import user.service.AppUserDAO;

@Service
public class RecipeInfoService implements RecipeInfoInterface {
	@Autowired private RecipeInfoDAO dao;
	
	@Override
	public List<RecipeInfoDTO> recipeInfo() {
		return dao.recipeInfo();	//RecipeInfoDAO로
	}
	
	
}
