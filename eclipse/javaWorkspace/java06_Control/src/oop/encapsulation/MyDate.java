package oop.encapsulation;
/*
 * 월을 먼저 입력 : 1~12사이의 값만 받고..그 이외의 값이 들어오면 필드에 할당되지 않도록 로직을 작성
 * 날짜 입력 : 
 * 	1, 3, 5, 7, 8, 10, 12월 : 1~31일
 *  2월 : 1~28일
 *  4, 6, 9, 11월 : 1~30일 까지의 값만 허용하도록 그 외의 날짜가 입력되면 필드에 할당되지 않도록 로직을 작성
 */
public class MyDate {
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	//로컬변수와 필드의 이름이 같을때 구분하기 위해서 필드 앞에 this(해당 클래스 자기 자신 / 해당 클래스 주소값을 참조)를 지정한다.
	public void setMonth(int month) {
		//제어문...사용
		if(month >= 1 && month <= 12) {
			this.month = month;
		} else {
			System.out.println("잘못된 월!!");
			System.exit(0);
		}
		
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		//제어문...사용
		int days = 0;
		switch(month) {
			case 2: 
				days = 28; 
				break;
			case 4: case 6: case 9: case 11: 
				days = 30; 
				break;
			default: days = 31; 
		}
		if(day <= days) {
			this.day = day;
		} else {
			System.out.println("잘못된 날짜!!");
			System.exit(0);
		}
		
	}
	
	
}
