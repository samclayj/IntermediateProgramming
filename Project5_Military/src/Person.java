
public class Person {

	/***Data Fields***/
	private Name name;
	private String birthday;
	private String ssn;
	
	/***Constructor***/
	public Person(Name name, String birthday, String ssn) {
		setName(name);
		setBirthday(birthday);
		setSSN(ssn);
	}
	
	/***Set/Get***/
	public Name getName() {
		return this.name;
	}//end getName
	
	public void setName(Name name) {
		this.name = name;
	}//end setName
	
	public String getBirthday() {
		return this.birthday;
	}//end getBirthday
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}//end getBirthday
	
	public String getSSN() {
		return this.ssn;
	}//end getSSN
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}//end setSSN
	
}//end class
