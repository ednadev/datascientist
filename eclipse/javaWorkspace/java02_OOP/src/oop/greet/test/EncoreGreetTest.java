package oop.greet.test;

import java.util.Scanner; 

import oop.greet.EncoreGreet;

public class EncoreGreetTest {

	public static void main(String[] args) {//실행메소드 : JVM(실행되는 장소, Memory)
		//Local Variable - 일시적인 변수도 메모리에 올라간다 (Stack), 기본값이 없다.
		EncoreGreet en = new EncoreGreet(); //객체 생성 = 메모리에 올린다 = 객체의 구성요소가 다 올라간다 (Field, Method)
		/*
		 * JVM > Heap > en (name, message, sayHello()가 올라간다고 생각하면 됨) -> 결론은 주소값 할당 (1004)된 값이 en이라는 변수에 들어감
		 * JVM > Stack에 있는 변수 en에 주소값 (1004) 할당
		 */

		//Field와 Method 호출 en.을 하게 되면 Heap에 있는 en에 있는 name, message, sayHello() 등을 호출
		
		//지금처럼 소스코드에 값을 직접 하드코딩 하지 않고
		// 실행시에 키보드로 입력받은 처리되도록...Scanner 사용
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요>>>>");//임채은
		String scName = sc.nextLine();
		en.name = scName; //명시적 초기화
		
		System.out.println("메시지를 입력하세요>>>>");//안녕~~~
		String scMsg = sc.nextLine();
		en.message = scMsg;
		
		en.sayHello();
	}

}
