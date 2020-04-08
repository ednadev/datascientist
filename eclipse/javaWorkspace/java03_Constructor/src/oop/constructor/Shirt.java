package oop.constructor;
/*
 * Default Constructor:
 * 1. 인자값이 없는 생성자
 * 2. 구현부에서 아무런 일도 하지 않는 생성자
 */
public class Shirt {
	public String maker; //기본값을 가진다...null (선언할 때 가지는 것이므로..)
	public boolean longSleeved;
	public char color;
	
	//하나의 클래스에는 하나 이상의 생성자가 존재한다.
	public Shirt() {}//Default Constructor - 아무일도 안함..생성자가 하는 일이 없음
	public Shirt(String m, boolean longs, char c) {
		// 필드 초기화 : 명시적 생성자가 하는 일
		maker = m;
		longSleeved = longs;
		color = c;
	}
	
	public String getDetails() { //worker method = 구현부가 있는 메소드
		return maker + ", " + longSleeved + ", " + color;
	}
	
}
