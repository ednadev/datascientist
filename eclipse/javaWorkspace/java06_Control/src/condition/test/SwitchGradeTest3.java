package condition.test;

import java.util.Scanner;

/*
 * 등급에 따라서
 * 해당하는 case문이 실행되도록 로직을 작성...
 * 이전에 실행시 값을 성적을 입력받았다면
 * 등급을 입력받도록 로직을 수정...
 */
public class SwitchGradeTest3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 이름을 입력하세요...\n");
		String name = sc.nextLine();
		System.out.println("당신의 등급을 입력하세요...\n");
		String grade = sc.nextLine();
		
		String message = "";
		switch(grade) {
			case "A":
				message = name + "님, 당신의 성적은 90~100";
				break;
			case "B":
				message = name + "님, 당신의 성적은 80~90";
				break;
			case "C":
				message = name + "님, 당신의 성적은 70~80";
				break;
			default:
				message = "Try Again!!";
		}
		
		System.out.println(message);

	}

}
