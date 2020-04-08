package banking;
/*
 * 통장의 정보를 저장하는 클래스..
 */
public class Account {
	private double balance; //- balance:double : -의미는 private  //10000 ---> 15000
	
	
	public Account(double balance) {// +Account(double Balance) : +의 의미는 public / 아무것도 붙이지 않으면 안쓰기
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//인자값 필요 - 저금
	public void deposit(double amt) { //5000
		//balance = balance + amt;
		balance += amt;
	}
	
	//인자값 필요 - 인출
	public void withdow(double amt) {
		balance -= amt;
	}
}
