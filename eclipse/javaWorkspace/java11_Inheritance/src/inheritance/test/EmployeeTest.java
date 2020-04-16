package inheritance.test;

import inheritance.child.Manager;
import inheritance.parent.Employee;
import inheritance.util.MyDate;

public class EmployeeTest {

	public static void main(String[] args) {
		//부모 객체를 생성
		Employee e1 = new Employee("이수근");
		Employee e2 = new Employee("강호동", 11000.0, new MyDate(1976, 2, 11));
		
		//자식 객체를 생성
		Manager m = new Manager("James", 230000.0, new MyDate(1990, 1, 1), "개발부");
		
		System.out.println(m.getDetails());
		System.out.println(e1.getDetails());
		System.out.println(e2.getDetails());

	}

}
