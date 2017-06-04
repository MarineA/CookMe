package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserList implements Serializable{
	
	private List<UserBean> users;
	private UserBean selectedUser;

	public UserList() {
		this.users = new ArrayList<>();
	}

	public List<UserBean> getUsers() {
		return users;
	}
	public void setUsers(List<UserBean> users) {
		this.users = users;
	}
	
	public UserBean getSelectedUser() {
		return selectedUser;
	}
	
	public void setSelectedUser(UserBean selectedUser) {
		this.selectedUser = selectedUser;
	}


}
