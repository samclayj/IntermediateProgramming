import java.util.Date;

public class Employee extends Person {

	/***Data Fields***/
	String office;
	int salary;
	Date dateHired;

	public Employee(String name, String address, String office, int salary) {
		super(name, address);
		setOffice(office);
		setSalary(salary);
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}
	
}
