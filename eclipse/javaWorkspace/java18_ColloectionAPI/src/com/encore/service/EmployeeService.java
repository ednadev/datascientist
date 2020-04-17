package com.encore.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

// Manager[]을 ArrayList<Employee> 사용
public class EmployeeService {
	//추가...
	private ArrayList<Employee> list;
	private static EmployeeService service = new EmployeeService();
	private EmployeeService() {
		list = new ArrayList<>();
	}
	public static EmployeeService getInstance() {
		return service;
	}
	 
	//추가 조건
	public void addEmployee(Employee e) {
		boolean find = false;
		for(Employee emp : list) {
			if(e.getName().equals(emp.getName())) { //이미 그런 사람이 있다면..
				find = true;
				System.out.println(e.getName() + "님은 이미 회원이십니다.");
				return;
			}
		}
		if(find==false) { //추가하고자 하는 사람은 기존의 리스트에는 없다...
			list.add(e);
			System.out.println(e.getName() + "님이 회원으로 등록되셨습니다...");
		}
	}

	//삭제 조건
	public void deleteEmployee(String name) {		
		boolean find = false;
		for(Employee e : list) {
			if(e.getName().equals(name)) { //삭제하려는 대상이 있다면...
				find = true;
				System.out.println(e.getName() + "님을 삭제합니다..");
				list.remove(e);
				break;
			}
		}
		if(find==false) {
			System.out.println("삭제할 대상이 존재하지 않습니다.");
		}
	}
	
	//수정 조건
	public void updateEmployee(Employee e) {
		boolean find = false;
/*		for(Employee emp : list) {
			if(e.getName().equals(emp.getName())) {
				emp.setName(e.getName());
				emp.setBirthDate(e.getBirthDate());
				emp.setSalary(e.getSalary());
				if(emp instanceof Manager) {
					((Manager) emp).setDept(((Manager)e).getDept());
					((Manager) emp).setDeptno(((Manager) e).getDeptno());
				}
				if(emp instanceof Engineer) {
					((Engineer) emp).setTech((Engineer) e);
				}
			}
		}*/
		
		int index = 0;
		for(Employee em : list) {
			if(em.getName().equals(e.getName())) {
				break;
			}
			index++;
		}
		list.set(index, e);
	}
	
	public ArrayList<Employee> findEmployee(double salary) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee em : list) {
			if(em.getSalary() == salary) {
				temp.add(em);
			}
		}
		
		return temp;
	}

	//추가
	public void getEmployee() {
		for(Employee e : list) System.out.println(e);
	}
}
