package recipe;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.PageVO;

@Repository
public class RecipeDAO implements RecipeService {
	@Autowired private SqlSession sql;
	
	@Override
	public RecipePage recipe_list(RecipePage page) {
		int returnnum = sql.selectOne("recipe.mapper.totalList", page);
		page.setTotalList(returnnum);
		page.setList(sql.selectList("recipe.mapper.list", page));
		return page;
	}

	@Override
	public List<RecipeIngVO> recipe_view(int id) {
		return sql.selectList("recipe.mapper.view", id);
	}
}
