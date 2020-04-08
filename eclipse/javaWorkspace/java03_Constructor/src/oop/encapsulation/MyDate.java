package oop.encapsulation;

public class MyDate {
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	//로컬변수와 필드의 이름이 같을때 구분하기 위해서 필드 앞에 this(해당 클래스 자기 자신 / 해당 클래스 주소값을 참조)를 지정한다.
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
}
