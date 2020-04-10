package step3.test;

import service.ProductStoreService;
import vo.Product;

public class ProductStoreServiceTest {

	public static void main(String[] args) {
		ProductStoreService service = new ProductStoreService();
		
		Product[] pros = {
				new Product("HP", 120000, 2),
				new Product("SAMSUNG", 230000, 3),
				new Product("LG", 500000, 13),
				new Product("HP", 5000000, 1)
		};
		
		System.out.println("1. 모든 상품의 maker를 출력합니다...");
		service.printAllProductMaker(pros);

		System.out.println("2. 모든 상품의 총가격을 받아옵니다...");
		System.out.println(service.getTotalPrice(pros) + " 원");
		
		System.out.println("3. 20만원 이상의 제품들 입니다...");
		service.printMorePrice(pros, 200000);

		System.out.println("4. 동일한 회사의 제품들입니다...");
		Product[] products = service.getCertainMaker(pros, "HP");
		for(Product p : products) {
			if(p==null) continue;
			System.out.println(p.getMaker() + ", " + p.getPrice());
		}
	}

}
