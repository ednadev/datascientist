package inheritance.parent;

import inheritance.util.MyDate;

//부모, Parent, Super 클래스...
public class Employee {
	public static final double BASE_SALARY = 100.0; //상수값
	private String name;
	private double salary;
	private MyDate birthDate;
	
	/*
	 * this
	 * 1) 변수 앞에 붙이는 this : 로컬변수와 필드의 이름이 같을 때 둘을 구분하기 위해서 필드 앞에 붙인다.
	 * 2) 생성자 앞에 붙이는 this : 하나의 클래스에서 서로다른 생성자를 호출할 때 사용됨
	 */
	public Employee() {}
	public Employee(String name, double salary, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	public Employee(String name) {
		this(name, BASE_SALARY, new MyDate(1980, 1, 1));
	}
	
	public String getDetails() {
		return name + ", " + salary + ", " + birthDate;
	}
	
}