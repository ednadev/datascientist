package banking.test;

import banking.Account;
import banking.Customer;

public class BankClientTest {

	public static void main(String[] args) {
		/*
		 * james라는 이름의 고객을 생성...주민번호는 1234
		 * James가 잔액 10000원을 가진 계좌를 하나 개설
		 * 새로 만든 계좌를 통해서 
		 * 5000원, 12000원을 입금
		 * 7000원을 출금
		 * 최종적으로 James통장의 잔액을 출금
		 */
		Customer custom1 = new Customer("James", 1234);
		custom1.setAccount(new Account(10000)); //James가 통장을 하나 개설...
		
		Account james = custom1.getAccount();
		System.out.println("5000원을 입금합니다...");
		james.deposit(5000.0);
		
		System.out.println("12000원을 입금합니다...");
		james.deposit(12000.0);
		
		System.out.println("7000원을 입출금합니다...");
		james.withdow(7000.0);
		
		System.out.println("Jame's GetBalance...");
		System.out.println(james.getBalance());
		
	}

}
