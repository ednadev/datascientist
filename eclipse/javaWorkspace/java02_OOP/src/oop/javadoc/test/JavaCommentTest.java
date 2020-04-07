package oop.javadoc.test;

import oop.javadoc.JavaComment;

/*
 * main() 가지고 실행을 하는 실행클래스
 * 실행.....
 * JavaComment 객체를 생성 == 메모리에 올린다. == 식구(Member-Field, Method)가 메모리에 올라간다
 * 													  |
 * 											      JVM > Heap (힙에 올라가는 멤버들은 new라는 키워드로 생성한 객체만 올라간다)
 * 객체 생성의 결론?	저장된 객체의 위치값이 지정됨...1004
 */
public class JavaCommentTest {

	public static void main(String[] args) {
		JavaComment jc = new JavaComment(); //1004
		//jc를 참조변수...reference Variable
		System.out.println(jc);
		
		//jc라는 이름의 객체를 생성한 이유?-->쓸려고, 사용할려고
		//필드사용---> 값 할당
		//메소드 사용 --> 호출(호출해야지만 기능이 동작한다)
		
		jc.name = "ednadev"; //값 할당
		System.out.println(jc.scoreSum(100, 100)); // METHOD Calling(호출)
		
	}

}
