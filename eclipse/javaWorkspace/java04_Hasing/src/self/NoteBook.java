package self;

public class NoteBook {
	private String brandName;
	private int price;
	
	//클래스가 public이면 생성자도 public.. 클래스를 따라간다고 생각
	public NoteBook(String brandName, int price) {
		this.brandName = brandName;
		this.price = price;
	}
	
	public String getNoteBook() {
		return brandName + ", " + price;
	}
	
}
