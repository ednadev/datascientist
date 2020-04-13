package service;

import java.util.Arrays;

import vo.Customer;
import vo.Product;

/*
 * 상품을 구입하는 고객, 상점에 입점된 상품에 대한 기능들을 다루는 서비스 클래스...
 */
public class OutletStoreService {
/*
 * getAllProductMaker() //모든 상품들의 메이커를 리턴하는 메소드 - 인자값 타입 등은 알아서
 * getAllCustomer() //모든 고객의 정보를 반환.. ssn, name, adress, 등 뭘 구매했는지 products까지
 * getACustomer() //특정한 고객에 대한 모든 정보를 리턴
 * maxPriceProduct() // 최고가 상품의 가격만 리턴
 * getMoreAvgProduct() // 평균가 이상의 상품들만 출력.. 특정한 고객이 구입한 상품들 중에서
 */
	
	//특정 고객이 산 모든 상품의 메이커
	public String[] getAllProductMaker(Customer customer) {
		if(customer.getProducts()!=null) {
			String[] maker = new String[customer.getProducts().length];
			int i = 0;
			for(Product product : customer.getProducts()) {
				maker[i++] = product.getMaker();
			}
			return maker;
		}
		return null;
	}

	//모든 고객의 정보를 반환
	public Customer[] getAllCustomer(Customer[] customers) {
		return customers;
	}
	
	//특정한 고객에 대한 모든 정보를 리턴
	public Customer getACustomer(Customer[] customers, int ssn) {
		for(Customer customer : customers) {
			if(customer.getSsn() == ssn) {
				return customer;
			}
		}
		return null;
	}
	
	//최고가 상품의 가격만 리턴
	public int maxPriceProduct(Customer customer) {
		int max = 0;
		for(Product product : customer.getProducts()) {
			if(product.getPrice() > max) {
				max = product.getPrice();
			}
		}
		return max;
	}
	
	//평균가 이상의 상품들만 출력
	public Product[] getMoreAvgProduct(Customer customer) {
		Product[] products = new Product[customer.getProducts().length];
		int sum = 0;
		int i = 0;
		for(Product product : customer.getProducts()) {
			sum += product.getPrice();
		}
		int avg = sum / customer.getProducts().length;
		for(Product product : customer.getProducts()) {
			if(product.getPrice() > avg) {
				products[i++] = product;
			}
		}
		return products;
	}

	public int avgPrice(Customer customer) {
		int sum = 0;
		for(Product product : customer.getProducts()) {
			sum += product.getPrice();
		}
		return 0;
	}
	
}
