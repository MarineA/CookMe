package bean;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
 
@ManagedBean
@SessionScoped
public class UserLogin implements Serializable{
    //@ManagedProperty("#{sessionBean}")
    //private SessionBean sessionBean;
    
    private String login;
    private String password;
 
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
   /* public void login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(login, password);
            context.addMessage(null, new FacesMessage("Et hop, reconnu"));
        } catch (ServletException e) {
            // Handle unknown username/password in request.login().
            context.addMessage(null, new FacesMessage("Unknown login "+e.getMessage()));
            // �ventuellement log.log(Level.SEVERE, "Failed to logout user!", e);
            // avec private static Logger log = Logger.getLogger(AuthBackingBean.class.getName());
        }
    }  
    */
}
