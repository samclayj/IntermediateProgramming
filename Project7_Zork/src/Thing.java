
public class Thing {

	/***Data Fields***/
	private String name;
	private String description;
	
	/***Constructors***/
	public Thing() {
		setName("No name.");
		setDescription("No description.");
	}
	
	public Thing(String name, String description) {
		setName(name);
		setDescription(description);
	}

	/***Set/Get***/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}//end class
