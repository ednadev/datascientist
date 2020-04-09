package self.test;

import java.util.Scanner;

public class CatchMouseTest {
	
	public static String solv(int x, int y, int z) {
		/*
		 * 구현...
		 * Math.abs()
		 */
		if(Math.abs(x-z) == Math.abs(y-z)) return "Mouse Escapes!!";
		else if(Math.abs(x-z) > Math.abs(y-z)) return "CatB Catch!";
		else return "CatA Catch!";
	}	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cata = sc.nextInt();
		int catb = sc.nextInt();
		int mouse = sc.nextInt();
		
		//순서대로 값을 입력받고
		String result = solv(cata, catb, mouse);
		System.out.println("Result :: " + result);
	}

}
