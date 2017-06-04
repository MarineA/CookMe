package controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import bean.UserBean;
import bean.UserLogin;
import model.ConnexionFactory;
import dao.UserDao;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable{

	//@EJB
	//private UserBean userbean;
	//private UserLogin user;
	private static String loginU;
	public String connectionState = "connection failed";
	
	public String getConnectionState(){
		return connectionState;
	}	
	
	public void login(UserLogin user) throws SQLException, IOException {
		//FacesContext context = FacesContext.getCurrentInstance();
		//context.getExternalContext().getSessionMap().put("user", userbean);
		
		HttpServletRequest request;
	
		//request.getSession().invalidate();
		boolean valid = new UserDao(ConnexionFactory.getInstance()).validate(user);
		
		if (valid){
			request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", user.getLogin());
		} else {
			
			
		}
		
	}
	
	public void logout() throws SQLException, IOException{
		HttpServletRequest request;
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.getSession().invalidate();
	}
}
