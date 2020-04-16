package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

public class Engineer extends Employee{
	private String tech;
	private double bonus;

	public Engineer(String name, double salary, MyDate birthDate, String tech, double bonus) {
		super(name, salary, birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	public double getBonus() {
		return bonus;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + ", " + tech + ", " + bonus;
	}
	
	public void changeTech(String tech) {
		this.tech = tech;
	}

}