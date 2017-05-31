package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RecipeBean implements Serializable{
	
	private int id;
	private String title;
	private int duration;
	private int expertise = 1;
	private String type;
	private List<String> typeList;
	private int nbPeople = 1 ;
	private String img;
	private String description;

		public RecipeBean(){
		
	}
	
	public RecipeBean(int id, String title, int duration, int expertise, String type, int nbPeople, String img,
			String description) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.expertise = expertise;
		this.type = type;
		this.nbPeople = nbPeople;
		this.img = img;
		this.description = description;
		this.typeList=new ArrayList<String>();
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


	public int getexpertise() {
		return expertise;
	}


	public void setexpertise(int expertise) {
		this.expertise = expertise;
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

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	
	
	
	
}
