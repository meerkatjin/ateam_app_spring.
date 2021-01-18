package recipeinfo.dto;

public class RecipeInfoDTO {
	 private int recipe_id;
     private int img_url;
     private String recipe_nm_ko;
     private String sumry;
     private String nation_nm;
     private String ty_nm;
     private String cooking_time;
     private String calorie;
     private String qnt;
     private String level_nm;
     private String irdnt_code;
     
     public RecipeInfoDTO() {}

	public RecipeInfoDTO(int recipe_id, int img_url, String recipe_nm_ko, String sumry, String nation_nm, String ty_nm,
			String cooking_time, String calorie, String qnt, String level_nm, String irdnt_code) {
		super();
		this.recipe_id = recipe_id;
		this.img_url = img_url;
		this.recipe_nm_ko = recipe_nm_ko;
		this.sumry = sumry;
		this.nation_nm = nation_nm;
		this.ty_nm = ty_nm;
		this.cooking_time = cooking_time;
		this.calorie = calorie;
		this.qnt = qnt;
		this.level_nm = level_nm;
		this.irdnt_code = irdnt_code;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public int getImg_url() {
		return img_url;
	}

	public void setImg_url(int img_url) {
		this.img_url = img_url;
	}

	public String getRecipe_nm_ko() {
		return recipe_nm_ko;
	}

	public void setRecipe_nm_ko(String recipe_nm_ko) {
		this.recipe_nm_ko = recipe_nm_ko;
	}

	public String getSumry() {
		return sumry;
	}

	public void setSumry(String sumry) {
		this.sumry = sumry;
	}

	public String getNation_nm() {
		return nation_nm;
	}

	public void setNation_nm(String nation_nm) {
		this.nation_nm = nation_nm;
	}

	public String getTy_nm() {
		return ty_nm;
	}

	public void setTy_nm(String ty_nm) {
		this.ty_nm = ty_nm;
	}

	public String getCooking_time() {
		return cooking_time;
	}

	public void setCooking_time(String cooking_time) {
		this.cooking_time = cooking_time;
	}

	public String getCalorie() {
		return calorie;
	}

	public void setCalorie(String calorie) {
		this.calorie = calorie;
	}

	public String getQnt() {
		return qnt;
	}

	public void setQnt(String qnt) {
		this.qnt = qnt;
	}

	public String getLevel_nm() {
		return level_nm;
	}

	public void setLevel_nm(String level_nm) {
		this.level_nm = level_nm;
	}

	public String getIrdnt_code() {
		return irdnt_code;
	}

	public void setIrdnt_code(String irdnt_code) {
		this.irdnt_code = irdnt_code;
	}
     
     
}
