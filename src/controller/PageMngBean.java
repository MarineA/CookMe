package controller;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class PageMngBean implements Serializable{
	
	public PageMngBean(){
		
	}
	
	public String goToFirstPage(){
		return "CookMe.xhtml";
	}

	public String goToEmergencyPage(){
		return "emergency.xhtml";
	}
	
	public String goToRecipePage(){
		return "recipe.xhtml";
	}
	
	public String goToShopPage(){
		return "shop.xhtml";
	}
}
