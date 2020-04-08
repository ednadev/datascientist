package test;
/*
 * 선언된 위치에 따라서 나눠진다.
 * 		    Field				 Local V
 * 1. 클래스 바로 밑, 메소드 바깥	|	메소드{ 안
 * 2. 기본값이 있다				|	기본값이 없다...반드시 초기화 하고 사용..에러
 * 3. Heap					|	Stack
 * 4. Member Variable		| 	지역변수, Temporary V, Automatically V
 * 	  인스턴스 변수, 객체변수	
 */
public class OperatorAppTest1 {

	public static void main(String[] args) {
		//Local Variable 선언...
		int i=5;
		int j=3;
		
		Operator o1 = new Operator();//100
		Operator o2 = new Operator();//200
		
		o1 = o2;//주소값이 o2로 동일해진다....숙제
		
		System.out.println("o1주소값 : " + o1);
		System.out.println("o2주소값 : " + o2);
		
		System.out.println(o1==o2); //true
		
		System.out.println("연산자 % :: " + i % j); //2
		System.out.println(i==j); //false
		System.out.println(i!=j); //true
		
		boolean flag = false;
		System.out.println(flag); //false
		System.out.println(!flag); //true
		
		int k = 10;
		System.out.println(k++);//나중에 1씩 증가..10
		System.out.println(k);//11
		
		int m = 10;
		System.out.println(++m);//먼저 1씩 증가..11
		System.out.println(m);//11
		
		//Short Circuit
		System.out.println(o1.test1() || o1.test2()); //true
		System.out.println(o1.test2() && o1.test1()); //false

	}
}

//클래스를 연달아서 만들때는 딱 하나의 클래스에만 public을 붙일 수 있다. public이 지정된 이름으로 저장해야 한다.
class Operator{
	public boolean test1() {
		System.out.println("test1() call.....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() call.....");
		return false;
	}
}
