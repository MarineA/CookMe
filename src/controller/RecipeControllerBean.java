package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import bean.RecipeBean;
import dao.RecipeDao;
import model.ConnexionFactory;

@ManagedBean
@ApplicationScoped
public class RecipeControllerBean {
	
	
	public String Research(RecipeBean recipe) throws IOException, SQLException{
		
		
		RecipeDao recipeDao = new RecipeDao(ConnexionFactory.getInstance());
	
		
		return "search.xhtml";
		
	}

}
