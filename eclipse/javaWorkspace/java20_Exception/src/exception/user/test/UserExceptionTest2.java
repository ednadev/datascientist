package exception.user.test;

import java.util.Scanner;

class UnderAgeException extends Exception {
	UnderAgeException() {
		this("19세 미만은 성인영화 관람 불가입니다");
	}
	UnderAgeException(String message) {
		super(message);
	}
}

class AdultMovie{
	public void entrance(int age) throws UnderAgeException {
		/*
		 * 입력된 나이가 19세 미만이면 성인영화 관람 불가시키고
		 * 19세 이상이면 입장을 허용하도록 문장을 제어합니다..
		 * 이때
		 * 사용자정의 예외 클래스..UnderAgeException으로 합니다.
		 */
		if(age<19) {
			throw new UnderAgeException();
		} 
		System.out.println("Ticketing....입장!!");
		System.out.println("당신은 성인영화 관람 가능합니다..");
		
	}
}
public class UserExceptionTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 나이를 입력>>>");
		int age = sc.nextInt();
		
		AdultMovie am = new AdultMovie();
		System.out.println("성인영화관 입장여부를 판단합니다..");
		try {
			am.entrance(age);
		} catch (UnderAgeException e) {
			System.out.println(e.getMessage());
		}
	}

}
