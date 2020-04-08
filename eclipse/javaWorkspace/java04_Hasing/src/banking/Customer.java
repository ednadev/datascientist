package banking;
/*
 * 통장을 개설하고자 하는 고객의 정보를 저장하고 있는 클래스..
 * 고객만의 정보를 가지고 있는 건 생성자, account가 주입되는 건 setter
 * Customer + Account ---> Has a Relation
 * 1. 필드에 Account를 선언
 * 2. Account를 주입 ---- 생성자(빡세게) / setter(느슨하게)
 */
public class Customer {
	private String name;
	private int ssn;
	
	//추가 - 필드 생성
	private Account account;
	
	public Customer(String name, int ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	// setter로 주입
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}

	public String getCustInfo(String name, int ssn) {
		return name + ", " + ssn;
	}
}
