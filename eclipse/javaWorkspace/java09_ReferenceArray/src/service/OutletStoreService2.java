package service;
/*
 * 상품을 구입하는 고객, 상점에 입점된 상품에 대한 기능들을 다루는 서비스 클래스...
 */

import vo.Customer;
import vo.Product;

public class OutletStoreService2 {
	int prosize = 4;
	int custsize = 3;
	
	public Product[ ] getProduct(Customer vo) {
		return vo.getProducts();
	}
	public String[ ] getAllProductMaker(Customer vo) {
		String[ ] temp = new String[prosize];
		Product[ ] pros=vo.getProducts();
		int cnt = 0;
		for(Product p : pros) {			
			System.out.println(p.getMaker());
			temp[cnt++] = p.getMaker();
		}
		return temp;
	}
	
	
	public Customer[ ] getAllCustomer(Customer[ ] custs) {
		Customer[ ] cs = new Customer[custsize];
		int cnt = 0;
		for(Customer c : custs) {
			cs[cnt++] = c;
		}
		return cs;
	}
	
	public Customer getACustomer(Customer[ ] custs, int ssn) {
		Customer cust = null;
		for(Customer c : custs) {
			if(c.getSsn()==ssn) cust = c;			
		}
		return cust;
	}
	
	public int maxPriceProduct(Customer c) {
		int max = 0;
		System.out.println(c.getName()+" 님이 구매하신 최고가 상품은....");
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			if(p.getPrice()>max) max = p.getPrice();
		}
		return max;
	}
	//추가
	public int avgPrice(Customer c) {
		int total = 0;		
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			total += p.getPrice();
		}
		return total/pros.length;
	}
	public Product[ ] getMoreAvgProduct(Customer c) {
		Product[ ] temp = new Product[prosize];
		Product[ ] pros=c.getProducts();
		int cnt = 0;
		for(Product p : pros) {
			if(p.getPrice()>=avgPrice(c)) 
				temp[cnt++] = p;			
		}
		return temp;
	}
}

/*
 * getAllProductMaker()
 * getAllCustomer()
 * getACustomer()
 * maxPriceProduct()
 * getMoreAvgProduct();특정한 고객이 구입한 상품들 중에서
 */

