package oop.self;

public class Programmer {
	public String name;
	public int age;
	public float salary;
	public int bonus;
	
	public void setProgrammer(String n, int a, float s, int b) {
		//Field Initialization
		name = n;
		age = a;
		salary = s;
		bonus = b;
	}
	
	public String getProgrammer() {
		//Field값 리턴하기
		return name + ", " + age + ", " + salary + ", " + bonus;
	}
	
	public float getAnnualSalary() {
		return salary*12 + bonus;
	}
}
