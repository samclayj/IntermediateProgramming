
public class Name {

	/***Data fields***/
	private String givenName;
	private String surName;
	
	/***Constructor***/
	public Name(String surName) {
		setSurName(surName);
	}//end constructor
	
	public Name(String givenName, String surName) {
		setGivenName(givenName);
		setSurName(surName);
	}//end constructor
	
	/***Set/Get***/
	public String getGivenName() {
		return this.givenName;
	}//end getGivenName
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}//end setGivenName
	
	public String getSurName() {
		return this.surName;
	}//end getSurName
	
	public void setSurName(String surName) { 
		this.surName = surName;
	}//end setSurName
	
}//end class
