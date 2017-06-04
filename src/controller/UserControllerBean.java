package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.ConnexionFactory;
import bean.UserBean;
import dao.UserDao;

@ManagedBean
@ApplicationScoped
public class UserControllerBean {

	public UserControllerBean() {
		
	}
	
	public String create(UserBean userbean) throws IOException, SQLException{
		UserDao userDao = new UserDao(ConnexionFactory.getInstance());
		userbean.setTypeUser(0);
		userDao.insert(userbean);
		
		return "connexionResult.xhtml";
	}

}
