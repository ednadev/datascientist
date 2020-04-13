package step4.test;

import service.OutletStoreService;
import vo.Customer;
import vo.Product;

public class OutletStoreServiceTest {

	public static void main(String[] args) {
		//1. 고객을 먼저 생성....2명만 생성
		Customer[] customers = new Customer[3];
		customers[0] = new Customer(123, "이나영", "방배동");
		customers[1] = new Customer(321, "김태희", "서초동");
		customers[2] = new Customer(444, "원빈", "방배동");
		
		//2. 고객이 구매할 상품들 정보생성
		Product[] pros1 = {
				new Product("진라면", 8000, 2),
				new Product("엘라스틴샴푸", 18000, 1),
				new Product("달걀", 5000, 1)
		};
		
		Product[] pros2 = {
				new Product("맥심커피", 32000, 3),
				new Product("스파게티 소스푸", 55000, 1),
				new Product("달걀", 6000, 2),
				new Product("공기청정기", 450000, 1)
		};
		
		//3. 이나영이 커피, 스파게티, 달걀, 공기청정기를 구매 | 김태희가 진라면, 엘라스틴샴푸, 달걀을 구매하도록
		//이 부분에서 Customer와 Product와의 Hasing이 일어난다. Has a Relation
		customers[0].buyProducts(pros2);
		customers[1].buyProducts(pros1);
		
		//4. Service 객체를 생성....메소드를 호출...
		OutletStoreService service = new OutletStoreService();
		
		Customer selectCustomer = customers[0];
		
		String[] products = service.getAllProductMaker(selectCustomer);
		System.out.println(selectCustomer.getName() + " 님이 구매하신 제품명 입니다.");
		if(products != null) {
			for(String product : products) {
				System.out.print(product + " ");
			}
		}

		System.out.println("\n========= 2. 고객정보 출력 =========");
		for(Customer customer : service.getAllCustomer(customers)) {
			System.out.print(customer.getName());
			System.out.println(" 고객님이 구매하신 상품정보입니다.");
			if(customer.getProducts()!=null) {
				for(Product product : customer.getProducts()) {
					System.out.println(product.getMaker());
				}
			}
		}
		
		System.out.println("\n======  3. 특정 고객 검색 =============");
		Customer aCust = service.getACustomer(customers, selectCustomer.getSsn()); 
		System.out.println(aCust.getName() + ", " + aCust.getSsn() + ", " + aCust.getAddress());
		if(aCust.getProducts()!=null) {
			for(Product product : aCust.getProducts()) {
				System.out.println(product.getMaker());
			}
		}
		
		System.out.println("\n======  4. 특정 고객의 최고가 상품 검색 =============");
		System.out.println(selectCustomer.getName() + " 님이 구매하신 최고가 상품은....");
		if(selectCustomer.getProducts()!=null) {
			System.out.println(service.maxPriceProduct(selectCustomer)+" 원입니다.");
		}else {
			System.out.println("없습니다.");
		}
		
		
		System.out.println("\n======  5. 평균가 이상되는 상품 검색 =============");
		System.out.println("해당 상품의 평균가는 " + service.avgPrice(customers[0]) + "원 입니다.");
		for(Product product : service.getMoreAvgProduct(selectCustomer)) {
			if(product!=null) System.out.println(product.getMaker() + ", " + product.getPrice());
		}

/*		
		Product[ ] avgPro=service.getMoreAvgProduct(customers[0]);
		System.out.println("해당 상품의 평균가는 "+service.avgPrice(customers[0])+"원 입니다");
		System.out.println(customers[0].getName()+" 님의 상품중에 평균가 이상되는 상품입니다.");
		for(Product p : avgPro) {
			if(p==null)continue;
			System.out.println(p.getProduct());
		}	*/
	}

}
