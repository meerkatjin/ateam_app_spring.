package recipe;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	@Override
	public RecipeInfoVO recipe_select(int id) {
		return sql.selectOne("recipe.mapper.select", id);
	}

	@Override
	public List<RecipeIrdntVO> recipe_irdnt_get(int id) {
		return sql.selectList("recipe.mapper.irdnt_get", id);
	}

	@Override
	public void recipe_random_recommend() {
		sql.delete("recipe.mapper.random_delete");
		sql.insert("recipe.mapper.random_recommend");
	}

	@Override
	public List<RecipeInfoVO> recommend_list() {
		return sql.selectList("recipe.mapper.recommend_list");
	}
}
