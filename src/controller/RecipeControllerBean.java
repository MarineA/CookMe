package controller;

import java.util.HashMap;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import bean.RecipeBean;
import dao.RecipeDao;
import model.ConnexionFactory;

@ManagedBean
@ApplicationScoped
public class RecipeControllerBean {

    private HashMap<String, RecipeBean> hashmapRecipe = new HashMap<>();
    
	public RecipeControllerBean() {
		
	}

	public String research(RecipeBean recipebean) throws Exception{
	
		System.out.println("search");
		RecipeDao recipeDao = new RecipeDao(ConnexionFactory.getInstance());
	
		recipeDao.research(10,4,2, "salade");
	
		return "search.xhtml";
		
	}
	
}
