
public class Student extends Person {

	/***Data Fields***/
	
	final String classStatus;
	
	public Student(String name, String address, String classStatus) {
		super(name, address);
		this.classStatus = classStatus;
	}//end
	
	public String getClassStatus() {
		return this.classStatus;
	}
	
}
