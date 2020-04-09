package condition.test;

import java.util.Scanner;

/*
 * 성적과 대상자의 이름을 실행시에 입력받아서 로직을 작성..
 */
public class IfGradeTest2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 성적과 이름을 입력하세요...\n");
		
		int grade = sc.nextInt();
		String name = sc.nextLine();
		
		if(grade>=90 && grade<=100) {
			System.out.println(name + ", A Grade...");
		}else if(grade>=80 && grade<90) {
			System.out.println(name + ", B Grade...");
		}else if(grade>=70 && grade<80) {
			System.out.println(name + ", C Grade...");
		}else {
			System.out.println(name + ", Try Again!!");
		}

	}

}
