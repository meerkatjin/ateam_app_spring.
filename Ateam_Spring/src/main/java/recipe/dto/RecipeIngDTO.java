package recipe.dto;

public class RecipeIngDTO {
     private int recipe_id;
     private int cooking_no;
     private String cooking_dc;
     private String stre_step_image_url;
     private String step_tip;
    

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getCooking_no() {
        return cooking_no;
    }

    public void setCooking_no(int cooking_no) {
        this.cooking_no = cooking_no;
    }

    public String getCooking_dc() {
        return cooking_dc;
    }

    public void setCooking_dc(String cooking_dc) {
        this.cooking_dc = cooking_dc;
    }

    public String getStre_step_image_url() {
        return stre_step_image_url;
    }

    public void setStre_step_image_url(String stre_step_image_url) {
        this.stre_step_image_url = stre_step_image_url;
    }

    public String getStep_tip() {
        return step_tip;
    }

    public void setStep_tip(String step_tip) {
        this.step_tip = step_tip;
    }
     
     
}