
public class Pilot extends Military {

	/***Data Fields***/
	private long hoursLogged;
	private Plane assignedPlane;
	
	/***Constructor***/
	public Pilot(Name name, String birthday, String ssn, int militaryID, String assignedUnit, long hoursLogged, Plane assignedPlane) {
		super(name, birthday, ssn, militaryID, assignedUnit);
		setHoursLogged(hoursLogged);
		setAssignedPlane(assignedPlane);
	}//end constructor
	
	/***Set/Get***/
	public long getHoursLogged() {
		return this.hoursLogged;
	}//end getHoursLogged
	
	public void setHoursLogged(long hoursLogged) {
		this.hoursLogged = hoursLogged;
	}//end setHoursLogged
	
	public Plane getAssignedPlane() {
		return this.assignedPlane;
	}//end getAssignedPlane
	
	public void setAssignedPlane(Plane assignedPlane) {
		this.assignedPlane = assignedPlane;
	}//end setAssignedPlane
	
}//end class
