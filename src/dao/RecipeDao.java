package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.RecipeBean;
import bean.RecipeList;
import model.ConnexionFactory;

public class RecipeDao {

	private Connection connexionDB;

	public RecipeDao(Connection connexion) {
		this.connexionDB = connexion;
	}

	public List<RecipeBean> selectAll() throws Exception{
        connexionDB = ConnexionFactory.getInstance();
        ResultSet resultat;
        Statement state = connexionDB.createStatement();
        resultat = state.executeQuery("SELECT * FROM recipe");
        List<RecipeBean> recipeList = new ArrayList<>();
        while(resultat.next()){
        	recipeList.add(new RecipeBean(resultat.getInt(1), resultat.getString(2), resultat.getInt(3),resultat.getInt(4), resultat.getString(5), resultat.getInt(6), resultat.getString(7), resultat.getString(8)));
        }
        resultat.close();
        connexionDB.close();
        return recipeList;
    }

	
	public List<RecipeBean> research(int duration, int nbPeople, int expertise) throws Exception{
        connexionDB = ConnexionFactory.getInstance();
        ResultSet resultat;
        Statement state = connexionDB.createStatement();
        resultat = state.executeQuery("SELECT * FROM recipe where duration=" + duration + " and nbPeople=" + nbPeople + " and expertise=" + expertise);
        List<RecipeBean> recipeList = new ArrayList<>();
        while(resultat.next()){
        	recipeList.add(new RecipeBean(resultat.getInt(1), resultat.getString(2), resultat.getInt(3),resultat.getInt(4), resultat.getString(5), resultat.getInt(6), resultat.getString(7), resultat.getString(8)));
        }
        resultat.close();
        connexionDB.close();
        return recipeList;
    }
	
	
	
//	// public HashMap<String, RecipeBean> research(int duration, int nbPeople,
//	// int expertise, String typeRecipe)
//	public List<RecipeBean> research(int duration, int nbPeople, int expertise)
////	public List<RecipeBean> research(RecipeBean recipe)
//			throws Exception {
//		connexionDB = ConnexionFactory.getInstance();
//		ResultSet resultat;
//		Statement state = connexionDB.createStatement();
////		resultat = state.executeQuery("SELECT * FROM recipe where duration=" + duration + " and nbPeople=" + nbPeople
////				+ " and expertise=" + expertise);
//		resultat = state.executeQuery("SELECT * FROM recipe");
//		List<RecipeBean> listResearch = new ArrayList<>();
//		while (resultat.next()) {
//			listResearch.add(new RecipeBean(resultat.getInt(1), resultat.getString(2), resultat.getInt(3), resultat.getInt(4),
//							resultat.getString(5), resultat.getInt(6), resultat.getString(7), resultat.getString(8)));
//		}
//		
//		resultat.close();
//		connexionDB.close();
//		return listResearch;
//		
////		connexionDB = ConnexionFactory.getInstance();
////		boolean res = true;
////		ResultSet resultat = null;
////		try (PreparedStatement ps = connexionDB.prepareStatement(
////				"SELECT * FROM recipe where duration=? and nbPeople=? and expertise=?")) {
////			ps.setInt(1, recipe.getDuration());
////			ps.setInt(5, recipe.getNbPeople());
////			ps.setInt(3, recipe.getExpertise());
////			try {
////				resultat = ps.executeQuery();
////			} catch (SQLException e) {
////				System.err.println(e.getMessage());
////				ps.cancel();
////				res = false;
////			}
////			List<RecipeBean> listResearch = new ArrayList<>();
////			while (resultat.next()) {
////				listResearch.add(new RecipeBean(resultat.getInt(1), resultat.getString(2), resultat.getInt(3), resultat.getInt(4),
////								resultat.getString(5), resultat.getInt(6), resultat.getString(7), resultat.getString(8)));
////			}
////  			ps.close();
////		resultat.close();
////		connexionDB.close();
////		return listResearch;
////
////		}
//		
//	}

	public RecipeBean select(int id) throws SQLException, IOException {
		connexionDB = ConnexionFactory.getInstance();
		ResultSet resultat;
		RecipeBean recipe;
		try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM recipe WHERE id=?")) {
			PS.setString(0, Integer.toString(id));
			resultat = PS.executeQuery();
			resultat.next();
			recipe = new RecipeBean(resultat.getInt(0), resultat.getString(1), resultat.getInt(2), resultat.getInt(3),
					resultat.getString(4), resultat.getInt(5), resultat.getString(6), resultat.getString(7));
		}
		resultat.close();
		connexionDB.close();
		return recipe;
	}

	public boolean insert(RecipeBean recipe) throws SQLException, IOException {
		boolean res = true;
		connexionDB = ConnexionFactory.getInstance();
		try (PreparedStatement ps = connexionDB.prepareStatement(
				"INSERT INTO recipe(title, duration, expertise, typeRecipe, nbPeople, img, description) values(?,?,?)")) {
			ps.setString(1, recipe.getTitle());
			ps.setInt(2, recipe.getDuration());
			ps.setInt(3, recipe.getExpertise());
			ps.setString(4, recipe.getTypeRecipe());
			ps.setInt(5, recipe.getNbPeople());
			ps.setString(6, recipe.getImg());
			ps.setString(7, recipe.getDescription());
			try {
				ps.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				ps.cancel();
				res = false;
			}
			connexionDB.commit();
			ps.close();
			connexionDB.close();
		}
		return res;
	}

	public boolean delete(RecipeBean recipe) throws SQLException, IOException {
		boolean res = true;
		connexionDB = ConnexionFactory.getInstance();
		try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM recipe where id=?")) {
			ps.setString(1, recipe.getTitle());
			try {
				ps.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				ps.cancel();
				res = false;
			}
			connexionDB.commit();
			ps.close();
			connexionDB.close();
		}
		return res;
	}

	public boolean update(RecipeBean recipe) throws SQLException, IOException {
		boolean res = true;
		connexionDB = ConnexionFactory.getInstance();
		try (PreparedStatement ps = connexionDB.prepareStatement(
				"UPDATE recipe SET title=? duration=? expertise=? typeRecipe=? nbPeople=? img=? description=? where id=?")) {
			ps.setString(1, recipe.getTitle());
			ps.setInt(2, recipe.getDuration());
			ps.setInt(3, recipe.getExpertise());
			// ps.setList(4, recipe.gettypeRecipeList());
			ps.setInt(5, recipe.getNbPeople());
			ps.setString(6, recipe.getImg());
			ps.setString(7, recipe.getDescription());
			try {
				ps.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				ps.cancel();
				res = false;
			}
			connexionDB.commit();
			ps.close();
			connexionDB.close();
		}
		return res;
	}

}
