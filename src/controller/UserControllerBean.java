package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.ConnexionFactory;
import bean.UserBean;
import bean.UserList;
import dao.UserDao;

@ManagedBean
@ApplicationScoped
public class UserControllerBean {
	private UserBean selectedUser;
	
	private Boolean displayDialog;

	public UserControllerBean() {
		
	}
	
	public String create(UserBean userbean) throws IOException, SQLException{
		UserDao userDao = new UserDao(ConnexionFactory.getInstance());
		userbean.setTypeUser(0);
		userDao.insert(userbean);
		
		return "connexionResult.xhtml";
	}
	
	public String update(UserBean userbean) throws IOException, SQLException{
		UserDao userDao = new UserDao(ConnexionFactory.getInstance());
		userDao.update(userbean);
		return "adminUsers.xhtml";
	}
	
	public List<UserBean> getAll() throws Exception{
		UserDao userDao = new UserDao(ConnexionFactory.getInstance());
		UserList userList = new UserList();
		userList.setUsers(userDao.selectAll());
		return userList.getUsers();
	}
	
	public UserBean get(UserBean userBean) throws Exception{
		UserDao userDao = new UserDao(ConnexionFactory.getInstance());
		return userDao.select(userBean.getId());
	}
	
	public String delete(UserBean userbean) throws IOException, SQLException{
		UserDao userDao = new UserDao(ConnexionFactory.getInstance());
		userDao.delete(userbean);
		return "adminUsers.xhtml";
	}
}
