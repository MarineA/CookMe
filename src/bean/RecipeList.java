package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class RecipeList implements Serializable{
	private List<RecipeBean> recipes;
	private RecipeBean selectedRecipe;

	public RecipeList() {
		this.recipes = new ArrayList<>();
	}

	public List<RecipeBean> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<RecipeBean> recipes) {
		this.recipes = recipes;
	}
	
	public RecipeBean getSelectedRecipe() {
		return selectedRecipe;
	}
	
	public void setSelectedRecipe(RecipeBean selectedRecipe) {
		this.selectedRecipe = selectedRecipe;
	}
}
