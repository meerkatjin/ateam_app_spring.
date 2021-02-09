package recipe.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import recipe.dto.RecipeInfoDTO;
import recipe.dto.RecipeIngDTO;
import recipe.dto.RecipeIrdntDTO;

@Repository
public class RecipeIngDAO implements RecipeIngInterface {
    @Autowired @Qualifier("mappers") private SqlSession sql;
    
    @Override
    public List<RecipeIngDTO> recipeIng(int recipe_id) {    
        System.out.println("bytis" +  recipe_id);
         List<RecipeIngDTO> list =
                     sql.selectList("recipeIng.mapper.recipeIng" , recipe_id);

         return list;
    }//recipeInfo()

	@Override
	public List<RecipeIrdntDTO> recipeIrdnt(int recipe_id) {
		List<RecipeIrdntDTO> list = sql.selectList("recipeIng.mapper.recipeIrdnt", recipe_id);
		return list;
	}
}