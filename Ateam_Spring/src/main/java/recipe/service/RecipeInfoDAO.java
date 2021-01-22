package recipe.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import recipe.dto.RecipeInfoDTO;

//@Repository 어노테이션 필요
@Repository
public class RecipeInfoDAO implements RecipeInfoInterface {
	//3. @Qualifier("recipe") 고치셔야합니다 default.xml 위 쿼리문 실행 객체를 "ateam" 으로 바꿨으니
	//@Qualifier("ateam") 으로 바꾸시면됩니다. 로그인쪽은 바꿨습니다.
	@Autowired @Qualifier("mappers") private SqlSession sql;
	
	@Override
	public List<RecipeInfoDTO> recipeInfo() {	
		//4. sql.selectList("user.mapper.recipeInfo", dto); 에서 
		//user.mapper. 를 recipe.mepper 로 바꾸셔야합니다
		//recipe-mapper.xml 의 <mapper namespace="recipe.mapper"> 즉 네임스페이스를
		//따라서 설정하시면 됩니다.   -> recipe-mapper.xml로
		 List<RecipeInfoDTO> list =
					 sql.selectList("recipe.mapper.recipeInfo");
//		 System.out.println(list.size());
//		 for (RecipeInfoDTO recipeInfoDTO : list) {
//			System.out.println(recipeInfoDTO.getRecipe_id());
//		}
		 return list;
	}//recipeInfo()
}
