package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import bean.UserBean;
import model.ConnexionFactory;

public class UserDao {

	private Connection connexionDB;

	public UserDao(Connection connexion){
	       this.connexionDB = connexion;
	    }
	   
	    public HashMap<String, UserBean> selectAll() throws Exception{
	        connexionDB = ConnexionFactory.getInstance();
	        ResultSet resultat;
	        Statement state = connexionDB.createStatement();
	        resultat = state.executeQuery("SELECT * FROM user");
	        HashMap<String, UserBean> hashmapRecipe = new HashMap<>();
	        while(resultat.next()){
	            hashmapRecipe.put(resultat.getString(1),new UserBean(resultat.getInt(0), resultat.getString(1), resultat.getString(2),resultat.getInt(3), resultat.getString(4), resultat.getString(5), resultat.getString(6)));
	        }
	        resultat.close();
	        connexionDB.close();
	        return hashmapRecipe;
	    }
	    
	    public UserBean select(int id) throws SQLException,IOException{
	        connexionDB = ConnexionFactory.getInstance();
	        ResultSet resultat;
	        UserBean recipe;
	        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM user WHERE id=?")) {
	            PS.setString(0, Integer.toString(id));
	            resultat = PS.executeQuery();
	            resultat.next();
	            recipe = new UserBean(resultat.getInt(0), resultat.getString(1), resultat.getString(2),resultat.getInt(3), resultat.getString(4), resultat.getString(5), resultat.getString(6));
	        }
	        resultat.close();
	        connexionDB.close();
	        return recipe;
	    }
	    
	   
	    public boolean insert(UserBean recipe) throws SQLException,IOException{
	        boolean res = true;
	        connexionDB = ConnexionFactory.getInstance();
	        try (PreparedStatement ps = connexionDB.prepareStatement("INSERT INTO user(firstName,lastName,age,email,password) values(?,?,?,?,?)")) {
	            ps.setString(1, recipe.getFirstName());
	            ps.setString(2, recipe.getLastName());
	            ps.setInt(3,recipe.getAge());
	            ps.setString(4,recipe.getEmail());
	            ps.setString(5,recipe.getLogin());
	            ps.setString(6,recipe.getPassword());
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
	    

	    public boolean delete(UserBean recipe)throws SQLException,IOException{
	        boolean res = true;
	        connexionDB = ConnexionFactory.getInstance();
	        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM user where id=?")) {
	            ps.setString(1, recipe.getFirstName());
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
	    

	    public boolean update(UserBean recipe)throws SQLException,IOException{
	        boolean res = true;
	        connexionDB = ConnexionFactory.getInstance();
	        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE user SET firstName=? lastName=? age=? email=? login=? password=? where id=?")) {
	            ps.setString(1, recipe.getFirstName());
	            ps.setString(2, recipe.getLastName());
	            ps.setInt(3,recipe.getAge());
	            ps.setString(4,recipe.getEmail());
	            ps.setString(5,recipe.getLogin());
	            ps.setString(6,recipe.getPassword());
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
