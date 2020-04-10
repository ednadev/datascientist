package vo;
// 상품에 대한 정보를 저장하는 VO 클래스
// VO : Value Object -> DB랑 연계되는 객체 (Value-정보만 있어야 함..알고리즘-기능이 있으면 안된다)
public class Product {
	private String maker;
	private int price;
	private int count;
	
	public Product(String maker, int price, int count) {
		this.maker = maker;
		this.price = price;
		this.count = count;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
