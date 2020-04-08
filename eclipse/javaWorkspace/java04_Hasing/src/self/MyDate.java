package self;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getBirthDay() {
		return year + "-" + month + "-" + day; //String + nonString이 만나면 String
	}
}
