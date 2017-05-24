package bean;

public class RecipeBean {
	
	private int id;
	private String title;
	private int duration;
	private int expertyse;
	private String type;
	private int nbPeople;
	private String img;
	private String descritpion;
	
	
	public RecipeBean(){
		
	}
	
	public RecipeBean(int id, String title, int duration, int expertyse, String type, int nbPeople, String img,
			String descritpion) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.expertyse = expertyse;
		this.type = type;
		this.nbPeople = nbPeople;
		this.img = img;
		this.descritpion = descritpion;
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


	public int getExpertyse() {
		return expertyse;
	}


	public void setExpertyse(int expertyse) {
		this.expertyse = expertyse;
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


	public String getDescritpion() {
		return descritpion;
	}


	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}
	
	
	
	
}
