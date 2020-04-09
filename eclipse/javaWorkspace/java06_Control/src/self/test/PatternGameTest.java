package self.test;

import java.util.Scanner;

public class PatternGameTest {

	public static void main(String[] args) {
		/*  Scanner를 통해서
			10~99 사이의 정수중 하나의 숫자를 입력받는다.
			3의 배수가 들어가 있는 숫자에는 @를 표시한다.
			예를 들어
			31 --> @
			11 --> 11
			96 --> @@
			29 --> @     */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// %, / 연산자를 사용
		int start = n/10; //10의 자리
		int end = n%10;   //1의 자리
		if(start==3 || start==6 || start==9) {
			if(end==3 || end==6 || end==9) {
				System.out.println("@@");
				System.exit(0);
			}
			System.out.println("@");
		}else if(end==3 || end==6 || end==9) {
			System.out.println("@");
		}else {
			System.out.println(n);
		}

	}

}
