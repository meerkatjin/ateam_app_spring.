package recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.dto.RecipeInfoDTO;
import recipe.dto.RecipeIngDTO;

@Service
public class RecipeIngService implements RecipeIngInterface{
    @Autowired private RecipeIngDAO dao;
    
    @Override
    public List<RecipeIngDTO> recipeIng(int recipe_id) {
        System.out.println("inter");
        return dao.recipeIng(recipe_id );    //RecipeIngDAO로
    }
}