package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RecipeBean implements Serializable{
	
	private int id;
	private String title;
	private int duration;
	private int expertise = 1;
	private String type;
	private int nbPeople = 1 ;
	private String img;
	private String description;

		public RecipeBean(){
		
	}
	
	public RecipeBean(int id, String title, int duration, int expertyse, String type, int nbPeople, String img,
			String description) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.expertise = expertyse;
		this.type = type;
		this.nbPeople = nbPeople;
		this.img = img;
		this.description = description;
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


	public void setExpertise(int expertyse) {
		this.expertise = expertyse;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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
	
	
	
	
}
