package oop.encapsulation.test;
/*
 * Encapsulation 작성 패턴
 * 1. 필드앞 ---> private
 * 2. setter() /getter() ---> public
 * 3. setter(){
 *    첫라인에서(필드 초기화 하기 직전에) 값을 타당성을 검사하는 제어문을 통해서 valid한 값만 필드에 할당되도록 한다
 */
import oop.encapsulation.MyDate;

public class MyDateTest1 {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		//필드에 직접적으로 값을 할당
		/*md.month = 13;
		md.day = 33;*/
		
		md.setMonth(13);
		System.out.println(md.getMonth());
		
		/*
		 * 클래스에서 사용하는 필드는 무조건 private로 막아야 한다.
		 * 통로는 생성자랑, setter -> public으로 열어놓는다. (조건문 사용할 수 있음) 
		 */

	}

}
