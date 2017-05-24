package controller;

import java.io.IOException;
import java.sql.SQLException;

import model.ConnexionFactory;
import bean.UserBean;
import dao.UserDao;

public class UserControllerBean {

	public UserControllerBean() {
		
	}
	
	public void create(UserBean userbean) throws IOException, SQLException{
		UserDao userDao = new UserDao(ConnexionFactory.getInstance());
		userbean.setTypeUser(0);
		userDao.insert(userbean);
		
		
	}

}
