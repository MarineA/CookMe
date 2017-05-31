package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import bean.RecipeBean;
import model.ConnexionFactory;

public class RecipeDao {

	private Connection connexionDB;

	public RecipeDao(Connection connexion) {
		this.connexionDB = connexion;
	}

	public HashMap<String, RecipeBean> selectAll() throws Exception {
		connexionDB = ConnexionFactory.getInstance();
		ResultSet resultat;
		Statement state = connexionDB.createStatement();
		resultat = state.executeQuery("SELECT * FROM recipe");
		HashMap<String, RecipeBean> hashmapRecipe = new HashMap<>();
		while (resultat.next()) {
			hashmapRecipe.put(resultat.getString(0),
					new RecipeBean(resultat.getInt(0), resultat.getString(1), resultat.getInt(2), resultat.getInt(3),
							resultat.getString(4), resultat.getInt(5), resultat.getString(6), resultat.getString(7)));
		}
		resultat.close();
		connexionDB.close();
		return hashmapRecipe;
	}

	public HashMap<String, RecipeBean> research(int duration, int nbPeople, int expertise, String type)
			throws Exception {
		connexionDB = ConnexionFactory.getInstance();
		ResultSet resultat;
		Statement state = connexionDB.createStatement();
		resultat = state.executeQuery("SELECT * FROM recipe where duration=" + duration + " and nbPeople=" + nbPeople
				+ " and expertise=" + expertise + " and type=" + type);
		HashMap<String, RecipeBean> hashmapRecipe = new HashMap<>();
		while (resultat.next()) {
			hashmapRecipe.put(resultat.getString(0),
					new RecipeBean(resultat.getInt(0), resultat.getString(1), resultat.getInt(2), resultat.getInt(3),
							resultat.getString(4), resultat.getInt(5), resultat.getString(6), resultat.getString(7)));
		}
		resultat.close();
		connexionDB.close();
		return hashmapRecipe;
	}

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
				"INSERT INTO recipe(title, duration, expertise, type, nbPeople, img, description) values(?,?,?)")) {
			ps.setString(1, recipe.getTitle());
			ps.setInt(2, recipe.getDuration());
			ps.setInt(3, recipe.getexpertise());
			ps.setString(4, recipe.getType());
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
				"UPDATE recipe SET title=? duration=? expertise=? type=? nbPeople=? img=? description=? where id=?")) {
			ps.setString(1, recipe.getTitle());
			ps.setInt(2, recipe.getDuration());
			ps.setInt(3, recipe.getexpertise());
			ps.setString(4, recipe.getType());
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
