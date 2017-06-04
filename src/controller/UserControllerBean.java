package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
	
	/*public void login(UserBean userbean) throws SQLException, IOException {
		//FacesContext context = FacesContext.getCurrentInstance();
		//context.getExternalContext().getSessionMap().put("user", userbean);
		boolean valid = new UserDao(ConnexionFactory.getInstance()).validate(userbean);
		if (valid){
			HttpSession session = SessionUtils.getSession();
		}
	}
	
	public void logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	*/

}
