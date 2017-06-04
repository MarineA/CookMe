package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class RecipeList implements Serializable {
	
	private List<RecipeBean> recipeList;
	private RecipeBean selectedRecipe;

	public RecipeList() {
		this.recipeList = new ArrayList<>();
	}

	public List<RecipeBean> getRecipeList() {
		return recipeList;
	}
	public void setRecipeList(List<RecipeBean> recipeList) {
		this.recipeList = recipeList;
	}
	
	public RecipeBean getSelectedRecipe() {
		return selectedRecipe;
	}
	
	public void setSelectedUser(RecipeBean selectedRecipe) {
		this.selectedRecipe = selectedRecipe;
	}
		
	
}
