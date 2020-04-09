package self.test;

import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요.");
		int number = sc.nextInt();
		String user = "";
		
		while(true) {
			//User
			System.out.print("가위바위보 중 하나 입력: ");
			user = sc.next();
			
			//Computer
			int randomNumber = (int)(Math.random()*3) + 1;
			String computer = "";
			switch(randomNumber) {
				case 1: computer = "가위"; break;
				case 2: computer = "주먹"; break;
				case 3: computer = "보"; break;
			}
			
			//TEST CODE - 나중에 지우기
			System.out.println(computer);
			System.out.println(user);
			
			int count = 0;
			if(user.equals(computer)) {
				System.out.println("비겼습니다!!!");
			} else if(user.equals("가위")) {
				if(computer.equals("주먹")) {
					System.out.println("졌습니다!!!");
				}else {
					System.out.println("이겼습니다!!!");
					count++;
				}
			} else if(user.equals("주먹")) {
				if(computer.equals("보")) {
					System.out.println("졌습니다!!!");
				}else {
					System.out.println("이겼습니다!!!");
					count++;
				}
			} else if(user.equals("보")){ 
				if(computer.equals("가위")) {
					System.out.println("졌습니다!!!");
				} else {
					System.out.println("이겼습니다!!!");
					count++;
				}
			} else {
				System.out.println("잘못 입력했습니다.");
			}
			
		}
		
	}

}
