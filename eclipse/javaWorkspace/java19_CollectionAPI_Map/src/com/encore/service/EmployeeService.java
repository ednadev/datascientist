package com.encore.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;
// Manager[ ]을 ArrayList<Employee> 사용
public class EmployeeService {
	
	//추가...
	private Map<Integer, Employee> map;
	
	//싱글톤
	private static EmployeeService service = new EmployeeService();	
	private EmployeeService(){
		map = new HashMap<Integer, Employee>();
	}
	public static EmployeeService getInstance() {
		return service;
	}
	
	
	//추가
	public void getEmployee() {
		Set<Integer> set = map.keySet();
		for(int i : set) {
			System.out.println(map.get(i));
		}
	}	
	
	public void addEmployee(Employee e) {	
		boolean flag = false;
		Set<Integer> set = map.keySet();
		for(int i : set) {
			if(map.get(i).getName().equals(e.getName())) {
				flag = true;
				System.out.println(e.getName() + "님은 이미 회원이십니다.");
				return;
			}
		}
		if(flag==false) {
			map.put(e.getSsn(), e);
			System.out.println("회원으로 등록되셨습니다.");
		}
	}	
	
	public void deleteEmployee(int ssn) {	
		boolean flag = false;
		Set<Integer> set = map.keySet();
		for(int i : set) {
			if(i == ssn) {
				flag = true;
				System.out.println(map.get(i).getName() + "님을 삭제합니다.");
				map.remove(i);
				break;
			}
		}
		if(flag == false) {
			System.out.println("삭제할 대상이 존재하지 않습니다.");
		}
	}	
	public void updateEmployee(Employee e, int ssn) {
		map.replace(ssn, e);
	}	
	
	public Employee findEmployee(int ssn) {
		return map.get(ssn);
	}	
	
	public ArrayList<Employee> findEmployee(double sal) {
		ArrayList<Employee> temp = new ArrayList<>();
		Set<Integer> set = map.keySet();
		for(int i : set) {
			if(map.get(i).getSalary() == sal) {
				temp.add(map.get(i));
			}
		}
		return temp;
	}	
	
}







