package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class RecipeBean implements Serializable{
	
	private int id;
	private String title;
	private int duration;
	private int expertise = 1;
	private String typeRecipe;
	private List<String> typeRecipeList;
	private int nbPeople = 1 ;
	private String img;
	private String description;

		public RecipeBean(){
		
	}
	
	public RecipeBean(int id, String title, int duration, int expertise, String typeRecipe, int nbPeople, String img,
			String description) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.expertise = expertise;
		this.typeRecipe = typeRecipe;
		this.nbPeople = nbPeople;
		this.img = img;
		this.description = description;
//		this.typeRecipeList=new ArrayList<String>();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getExpertise() {
		return expertise;
	}


	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}


	public String getTypeRecipe() {
		return typeRecipe;
	}


	public void setTypeRecipe(String typeRecipe) {
		this.typeRecipe = typeRecipe;
	}


	public int getNbPeople() {
		return nbPeople;
	}


	public void setNbPeople(int nbPeople) {
		this.nbPeople = nbPeople;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTypeRecipeList() {
		return typeRecipeList;
	}

	public void setTypeRecipeList(List<String> typeRecipeList) {
		this.typeRecipeList = typeRecipeList;
	}
	
	
	
	
}
