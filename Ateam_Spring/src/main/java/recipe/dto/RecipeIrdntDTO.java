package recipe.dto;

import java.io.Serializable;

public class RecipeIrdntDTO implements Serializable {
	private int recipe_id;
	private String irdnt_nm, irdnt_cpcty, irdnt_ty_nm;
	
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getIrdnt_nm() {
		return irdnt_nm;
	}
	public void setIrdnt_nm(String irdnt_nm) {
		this.irdnt_nm = irdnt_nm;
	}
	public String getIrdnt_cpcty() {
		return irdnt_cpcty;
	}
	public void setIrdnt_cpcty(String irdnt_cpcty) {
		this.irdnt_cpcty = irdnt_cpcty;
	}
	public String getIrdnt_ty_nm() {
		return irdnt_ty_nm;
	}
	public void setIrdnt_ty_nm(String irdnt_ty_nm) {
		this.irdnt_ty_nm = irdnt_ty_nm;
	}
	
	
}
