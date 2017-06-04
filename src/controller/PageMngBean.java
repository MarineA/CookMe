package controller;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class PageMngBean implements Serializable{
	
	public PageMngBean(){
	}
	
	public String goToFirstPage(){
		return "CookMe.xhtml";
	}

	public String goToEmergencyPage(){
		return "emergency.xhtml";
	}
	
	public String goToRecipePage(){
		return "recipe.xhtml";
	}
	
	public String goToShopPage(){
		return "shop.xhtml";
	}
	
	public String goToConnectPage(){
		return "recipe.xhtml";
	}
	
	public String goToAdminRecipesPage(){
		return "adminRecipes.xhtml";
	}
	
	public String goToAdminUsersPage(){
		return "adminUsers.xhtml";
	}
	
	public String goToRecipeCreationPage(){
		return "recipeCreation.xhtml";
	}
	
	
}
