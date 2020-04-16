package inheritance.service;

import inheritance.child.Engineer;
import inheritance.parent.Employee;

public class EmployeeService {
	public void printInfo(Employee e) {
		System.out.println(e.getDetails());
	}
	
	public void printAllInfo(Employee[] ea) {
		for(Employee e : ea) {
			System.out.println(e.getDetails());
		}
	}
	
	public Employee findEmployeeByName(Employee[] ea, String name) {
		Employee emp = null;
		for(Employee e : ea) {
			if(e.getName().equals(name)) emp = e;
		}
		return null;
	}
	
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int) (e.getSalary()*12);
		
		if(e instanceof Engineer) {
			Engineer eg = (Engineer) e;
			annualSalary = (int) (e.getSalary()*12 + eg.getBonus());
		}
		return annualSalary;
	}
	
	public int getTotalCoast(Employee[] ea) {
		int total = 0;
		for(Employee e : ea) {
			total += getAnnualSalary(e);
		}
		return total;
	}
}