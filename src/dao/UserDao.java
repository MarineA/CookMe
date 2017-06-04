package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.UserBean;
import bean.UserLogin;
import model.ConnexionFactory;

@ManagedBean
@SessionScoped
public class UserDao {

	private Connection connexionDB;

	public UserDao(Connection connexion){
	       this.connexionDB = connexion;
	    }
	   
	    public HashMap<String, UserBean> selectAll() throws Exception{
	        connexionDB = ConnexionFactory.getInstance();
	        ResultSet resultat;
	        Statement state = connexionDB.createStatement();
	        resultat = state.executeQuery("SELECT * FROM users");
	        HashMap<String, UserBean> hashmapRecipe = new HashMap<>();
	        while(resultat.next()){
	            hashmapRecipe.put(resultat.getString(1),new UserBean(resultat.getInt(0), resultat.getString(1), resultat.getString(2),resultat.getInt(3), resultat.getString(4), resultat.getString(5), resultat.getString(6), resultat.getInt(7)));
	        }
	        resultat.close();
	        connexionDB.close();
	        return hashmapRecipe;
	    }
	    
	    public UserBean select(int id) throws SQLException,IOException{
	        connexionDB = ConnexionFactory.getInstance();
	        ResultSet resultat;
	        UserBean userbean;
	        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM users WHERE id=?")) {
	            PS.setString(0, Integer.toString(id));
	            resultat = PS.executeQuery();
	            resultat.next();
	            userbean = new UserBean(resultat.getInt(0), resultat.getString(1), resultat.getString(2),resultat.getInt(3), resultat.getString(4), resultat.getString(5), resultat.getString(6), resultat.getInt(7));
	        }
	        resultat.close();
	        connexionDB.close();
	        return userbean;
	    }
	    
	  
	    public boolean insert(UserBean userbean) throws SQLException,IOException{
	        boolean res = true;
	        connexionDB = ConnexionFactory.getInstance();
	        try (PreparedStatement ps = connexionDB.prepareStatement("INSERT INTO users(firstName,lastName,age,email,login,passwd,typeUser) values(?,?,?,?,?,?,?)")) {
	            ps.setString(1, userbean.getFirstName());
	            ps.setString(2, userbean.getLastName());
	            ps.setInt(3,userbean.getAge());
	            ps.setString(4,userbean.getEmail());
	            ps.setString(5,userbean.getLogin());
	            ps.setString(6,userbean.getPassword());
	            ps.setInt(7,userbean.getTypeUser());

	            try {
	                ps.executeUpdate();
	            } catch (SQLException e) {
	                System.err.println("SQL Exception : "+e.getMessage());
	                ps.cancel();
	                res = false;
	            }
	            connexionDB.commit();
	            ps.close();
	            connexionDB.close();
	        }
	        return res;
	    }
	    

	    public boolean delete(UserBean userbean)throws SQLException,IOException{
	        boolean res = true;
	        connexionDB = ConnexionFactory.getInstance();
	        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM users where id=?")) {
	            ps.setString(1, userbean.getFirstName());
	            try {
	                ps.executeUpdate();
	            } catch (SQLException e) {
	                System.err.println("SQL Exception : "+e.getMessage());
	                ps.cancel();
	                res = false;
	            }
	            connexionDB.commit();
	            ps.close();
	            connexionDB.close();
	        }
	        return res;
	    }
	    


	    public boolean update(UserBean userbean)throws SQLException,IOException{
	        boolean res = true;
	        connexionDB = ConnexionFactory.getInstance();
	        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE users SET firstName=? lastName=? age=? email=? login=? password=? where id=?")) {
	            ps.setString(1, userbean.getFirstName());
	            ps.setString(2, userbean.getLastName());
	            ps.setInt(3,userbean.getAge());
	            ps.setString(4,userbean.getEmail());
	            ps.setString(5,userbean.getLogin());
	            ps.setString(6,userbean.getPassword());
	            ps.setInt(7,userbean.getTypeUser());

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
	    
	    public boolean validate(UserLogin user) throws SQLException, IOException {
	    	boolean res = false;
	        connexionDB = ConnexionFactory.getInstance();
			PreparedStatement ps = null;

			try {
				
				ps = connexionDB.prepareStatement("Select login, passwd from Users where login = ? and passwd = ?");
				ps.setString(1, user.getLogin());
				ps.setString(2, user.getPassword());

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					//result found, means valid inputs
					res = true;
				}
			} catch (SQLException ex) {
				System.out.println("Login error -->" + ex.getMessage());
				res = false;
			} finally {
				connexionDB.close();
			}
			return res;
		}
}
