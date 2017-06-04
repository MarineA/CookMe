package controller;

import java.util.HashMap;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import bean.RecipeBean;
import bean.RecipeList;
import dao.RecipeDao;
import model.ConnexionFactory;

@ManagedBean
@ApplicationScoped
public class RecipeControllerBean {

    
	public RecipeControllerBean() {
		
	}
				
	public String research(RecipeBean recipeBean) throws Exception{
	
		
		RecipeDao recipeDao = new RecipeDao(ConnexionFactory.getInstance());
		RecipeList recipeList = new RecipeList();
		recipeList.setRecipeList(recipeDao.research(recipeBean.getDuration(), recipeBean.getNbPeople(), recipeBean.getExpertise()));
		System.out.println("search");
		
		return "search.xhtml";
		
	}
	
}
