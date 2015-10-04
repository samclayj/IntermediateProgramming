
public class Plane {

	/***Data Fields***/
	private String name;
	private String location;
	
	/***Constructor***/
	public Plane(String name, String location) {
		setName(name);
		setLocation(location);
	}//end constructor
	
	/***Set/Get***/
	public String getName() {
		return this.name;
	}//end getName
	
	public void setName(String name) {
		this.name = name;
	}//end setName
	
	public String getLocation() {
		return this.location;
	}//end getLocation
	
	public void setLocation(String location) {
		this.location = location;
	}//end setLocation

}//end class

