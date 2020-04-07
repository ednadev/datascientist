package oop.greet;
//EncoreGreet 클래스의 용도...
/*
 * EncoreGreet는
 * Encore 교육센타 수강생들에게 전하는 인사말을 저장하고 있는 클래스
 */
public class EncoreGreet {
	//Variable (값이 저장되는 공간) : Field
	public String name; //Initialization(초기화)
	public String message;
	//필드 추가...
	public int classRoom;
	public String subject;
	
	//Method (기능)
	public void sayHello() {
		System.out.println(name + ", " + message);
	}
	//메소드 추가
	public String getEncore() {
		return name + "\t" + message + "\t" + classRoom + "\t" + subject;
	}
	
	//함수 추가..여러개의 값을 한번에 필드에 주입하는 기능을 구현
	//메소드 정의 = 메소드 선언부 + 메소드 구현부(필드 초기화)
	public void setEncore(String n, String m, int c, String s) {
		name = n; //field 초기화
		message = m;
		classRoom = c;
		subject = s;
	}
}
