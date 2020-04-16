package inheritance.util;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/*
	 * 메소드 Overriding
	 * 1step. Object의 기능을 그대로 받아서
	 * 2step. 그 기능을 자식 본인에게 맞도록 고쳐쓴다.
	 */

	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
}
