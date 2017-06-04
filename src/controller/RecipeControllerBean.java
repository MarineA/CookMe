package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
		recipeList.setRecipes(recipeDao.research(recipeBean.getDuration(), recipeBean.getNbPeople(), recipeBean.getExpertise()));
		System.out.println("search");
		
		return "search.xhtml";
		
	}
	
	
	public List<RecipeBean> getAll() throws Exception{
		RecipeDao recipeDao = new RecipeDao(ConnexionFactory.getInstance());
		RecipeList recipeList = new RecipeList();
		recipeList.setRecipes(recipeDao.selectAll());
		return recipeList.getRecipes();
	}
	
	public String delete(RecipeBean recipeBean) throws IOException, SQLException{
		RecipeDao recipeDao = new RecipeDao(ConnexionFactory.getInstance());
		recipeDao.delete(recipeBean);
		return "adminRecipes.xhtml";
	}
	
	public String update(RecipeBean recipeBean) throws IOException, SQLException{
		RecipeDao recipeDao = new RecipeDao(ConnexionFactory.getInstance());
		recipeDao.update(recipeBean);
		return "adminRecipes.xhtml";
	}
	
	public String create(RecipeBean recipeBean) throws IOException, SQLException{
		RecipeDao recipeDao = new RecipeDao(ConnexionFactory.getInstance());
		recipeDao.insert(recipeBean);
		
		return "adminRecipes.xhtml";
	}

}
