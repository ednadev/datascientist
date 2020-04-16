package inheritance.test;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;
import inheritance.service.PolymorphismService;
import inheritance.util.MyDate;

public class PolymorphismTest2 {

	public static void main(String[] args) {
		System.out.println("=========== Polymorphisim 방식으로 객체 생성===============");
		Employee e2 = new Manager("강호동2", 23000.0, new MyDate(1972, 11, 1), "체육부");
		Employee e3 = new Engineer("박나래2", 56000.0, new MyDate(1989, 3, 1), "R", 200.0);
		Employee e4 = new Secretary("박보검2", 34000.0, new MyDate(1990, 3, 1), "강호동");
		Employee e5 = new Manager("강호동3", 23000.0, new MyDate(1972, 11, 1), "체육부");
		
		//Heterogeneous Collection - 다른 타입의 데이터들을 모아놓은 배열
		Employee[ ] emps = {e2,e3,e4,e5};
		
		PolymorphismService service = new PolymorphismService();
		service.handleEmployee(emps);
		
		for(Employee e : emps) {
			System.out.println(e.getDetails());
		}
			
	}
}