package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//자식, Child, Sub 클래스..
public class Manager extends Employee{
	private String dept;
	
	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate);
		this.dept = dept;
	}

	//method....1.그대로 물려받는다  2.고친다
	@Override
	public String getDetails() {
		return super.getDetails() + ", " + dept; //Employee의 getDetails()호출
	}	
	
}