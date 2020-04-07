package oop.self.test;

import oop.self.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		Programmer pro = new Programmer();
		System.out.println("======정보를 출력합니다.======\n");
		pro.setProgrammer("Peter", 44, 30000.0F, 100);
		
		System.out.println(pro.getProgrammer());
		
		System.out.println("======당신의 연봉은...======\n");
		System.out.println(pro.getAnnualSalary() + " 만원");
	}

}
