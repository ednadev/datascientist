package inheritance.service;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;

//기능만을 모아놓은 서비스 클래스...
public class PolymorphismService {
	//1.step
	public void handleManageR(Manager m) {}
	public void manageEngineer(Engineer eg) {}
	public void getSecretary(Secretary se) {}
	
	//2.step
	public void handleEmployee(Manager m) {}
	public void handleEmployee(Engineer eg) {}
	public void handleEmployee(Secretary se) {}
	
	//3.step
	public void handleEmployee(Employee[] earr) {
		for(Employee e : earr) {
			if(e instanceof Manager) {//e가는 객체가 Manager라면
				if(e.getName().equals("강호동2")) ((Manager) e).changeDept("총무부");
			}
			if(e instanceof Engineer) {//e라는 객체가 Engineer라면
				
			}
			if(e instanceof Secretary) {//e라는 객체가 Secretary라면
				
			}
		}
	}
}