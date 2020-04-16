package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

public class Manager extends Employee{
	private String dept;
	
	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate);
		this.dept = dept;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + ", " + dept;
	}
	
	public void changeDept(String dept) {
		this.dept = dept;
	}

}