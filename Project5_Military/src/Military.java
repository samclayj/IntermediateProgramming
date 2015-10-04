
public class Military extends Person {
	/***Data Fields***/
	private int militaryID; 
	private String assignedUnit;
	
	/***Constructor***/
	public Military(Name name, String birthday, String ssn, int militaryID, String assignedUnit) {
		super(name, birthday, ssn);
		setMilitaryID(militaryID);
		setAssignedUnit(assignedUnit);
	}//end constructor
	
	/***Set/Get***/
	public int getMilitaryID() {
		return this.militaryID;
	}//end getMilitaryID
	
	public void setMilitaryID(int militaryID) {
		this.militaryID = militaryID;
	}//end getMilitaryId
	
	public String getAssignedUnit() {
		return this.assignedUnit;
	}//end getAssignedUnit
	
	public void setAssignedUnit(String assignedUnit) {
		this.assignedUnit = assignedUnit;
	}//end setAssignedUnit
	
}//end class
