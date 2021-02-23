package common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import recipe.RecipeDAO;

@Service
public class CommonService {
	@Autowired private RecipeDAO recipeDao;
	
//	@Scheduled( cron="0 0 0 0 01 * ?") //매월 1일 12시 0분 0 0초 
	
	//매 시간마다 작동
	@Scheduled( cron="0 0 * * * *") //초 분 시 일 월 요일 년
	public void process() {
		recipeDao.recipe_random_recommend();
		System.out.println("테스트");
	}
}
