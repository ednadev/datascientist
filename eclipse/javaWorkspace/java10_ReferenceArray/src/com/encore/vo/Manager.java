package com.encore.vo;

import com.encore.util.MyDate;

public class Manager {
	private String name;
	private MyDate birthDate;
	private double salary;
	private String dept;
	private int deptno;
	
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.dept = dept;
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public String getDetails() {
		return name + ", " + birthDate.getDate() + ", " + salary + ", " + dept + ", " + deptno;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getDeptno() {
		return deptno;
	}
	
}
