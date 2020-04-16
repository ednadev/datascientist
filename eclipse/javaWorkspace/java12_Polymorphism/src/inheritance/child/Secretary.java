package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

public class Secretary extends Employee{
	private String nameOfBoss;
	
	public Secretary(String name, double salary, MyDate birthDate, String nameOfBoss) {
		super(name, salary, birthDate);
		this.nameOfBoss = nameOfBoss;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + ", " + nameOfBoss;
	}
	
}