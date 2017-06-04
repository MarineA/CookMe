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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.UserBean;
import model.ConnexionFactory;

@ManagedBean
@SessionScoped
public class UserDao {

	private Connection connexionDB;

	public UserDao(Connection connexion){
	       this.connexionDB = connexion;
	    }
	   
	    public List<UserBean> selectAll() throws Exception{
	        connexionDB = ConnexionFactory.getInstance();
	        ResultSet resultat;
	        Statement state = connexionDB.createStatement();
	        resultat = state.executeQuery("SELECT * FROM users");
	        List<UserBean> users = new ArrayList<>();
	        while(resultat.next()){
	            users.add(new UserBean(resultat.getInt(1), resultat.getString(2),resultat.getString(3), resultat.getInt(4), resultat.getString(5), resultat.getString(6), resultat.getString(7), resultat.getInt(8)));
	        }
	        resultat.close();
	        connexionDB.close();
	        return users;
	    }
	    
	    public UserBean select(int id) throws SQLException,IOException{
	        connexionDB = ConnexionFactory.getInstance();
	        ResultSet resultat;
	        UserBean userbean;
	        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM users WHERE id=?")) {
	            PS.setInt(0, id);
	            resultat = PS.executeQuery();
	            resultat.next();
	            userbean = new UserBean(resultat.getInt(1), resultat.getString(2),resultat.getString(3), resultat.getInt(4), resultat.getString(5), resultat.getString(6), resultat.getString(7), resultat.getInt(8));
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
	    

	    public boolean delete(UserBean userbean)throws SQLException,IOException{
	        boolean res = true;
	        connexionDB = ConnexionFactory.getInstance();
	        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM users where id=?")) {
	            ps.setInt(1, userbean.getId());
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
	    


	    public boolean update(UserBean userbean)throws SQLException,IOException{
	        boolean res = true;
	        connexionDB = ConnexionFactory.getInstance();
	        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE users SET firstName=?, lastName=?, age=?, email=?, login=?, passwd=? where id=?")) {
	            ps.setString(1, userbean.getFirstName());
	            ps.setString(2, userbean.getLastName());
	            ps.setInt(3,userbean.getAge());
	            ps.setString(4,userbean.getEmail());
	            ps.setString(5,userbean.getLogin());
	            ps.setString(6,userbean.getPassword());
	            ps.setInt(7,userbean.getId());

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
