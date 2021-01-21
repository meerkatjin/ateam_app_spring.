package recipe.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import recipe.dto.RecipeInfoDTO;
import recipe.dto.RecipeIngDTO;

@Repository
public class RecipeIngDAO implements RecipeIngInterface {
    @Autowired @Qualifier("recipeIng") private SqlSession sql;
    
    @Override
    public List<RecipeIngDTO> recipeIng(RecipeIngDTO dto) {    
        System.out.println("bytis" + dto.getRecipe_id());
         List<RecipeIngDTO> list =
                     sql.selectList("recipeIng.mapper.recipeIng" ,dto);

         return list;
    }//recipeInfo()
}