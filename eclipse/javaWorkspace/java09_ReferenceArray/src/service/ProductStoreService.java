package service;

import vo.Product;

/*
 * ProductStore에 있는 다양한 상품들을 다루는 기능을 모아놓은 서비스 클래스...
 * 이 클래스에서 다루는 기능들....
 * 1)다양한 상품들의 maker를 출력
 * 2)상품들의 총 금액을 리턴
 * 3)상품들의 평균가를 리턴
 * 4)특정 금액 이상되는 상품의 정보를 출력
 * 5)특정회사 제품들의 상품을 리턴하는 기능
 */
public class ProductStoreService {
	/*public 리턴타입 이름(인자값) {
		
	}*/
	
	//1)다양한 상품들의 maker를 출력
	public void printAllProductMaker(Product[] pros) {
		for(Product pro : pros) System.out.print(pro.getMaker() + " ");
		System.out.println();
	}
	
	//2)상품들의 총 금액을 리턴
	public int getTotalPrice(Product[] pros) {
		int total = 0;
		for(Product pro : pros) {
			total += pro.getPrice()*pro.getCount();
		}
		return total;
	}
	
	//3)상품들의 평균가를 리턴 - 메소드의 재사용성
	public int getAvgPrice(Product[] pros) {
		return getTotalPrice(pros) / pros.length;
	}
	
	//4)특정 금액 이상되는 상품의 정보를 출력
	public void printMorePrice(Product[] pros, int price) {
		for(Product pro : pros) {
			if(pro.getPrice() >= price) System.out.println(pro.getMaker() + ", " + pro.getPrice());
		}
	}
	
	//5)특정회사 상품을 리턴하는 기능
	public Product[] getCertainMaker(Product[] pros, String maker) {
		Product[] products = new Product[pros.length];
		int idx = 0;
		for(Product pro : pros) {
			if(pro.getMaker().equals(maker)) {
				products[idx++] = pro;
			}
		}
		return products;
	}
}
