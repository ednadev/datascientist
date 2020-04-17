package pizza.child;

import pizza.parent.Pizza;

//자식 클래스...
public class BugogiPizza extends Pizza {

	public BugogiPizza(int price, String storeName) {
		//부모의 필드가 protected로 지정되어서 super 안사용해도 된다.
		this.price = price;
		this.storeName = storeName;
	}

	@Override
	public void topping() {
		System.out.println("Bugogi Topping Pizza....");
		
	}

}
