package fly.test;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;

public class FlyerTest {

	public static void main(String[] args) {
		//Flyer f1 = new Flyer(); 
		/*
		 * 오류! instantiate..플라잉 타입으로 객체 생성할 수 없다. 추상화가 한 방울이라도 들어가 있으면 instantiate(객체 생성)가 안된다. 
		 * 설계도에 해당하는 것이 class, class로 instantiate를 하게 됨.. 완벽한 타입! = 완벽한 설계도
		 * 하나라도 추상이 들어가있으면 제품을 못 만든다. 추상이 조금이라도 들어가 있으면 instantiate가 안 된다.
		 * 대신에 타입으로써는 작용한다. 타입은 super급! 완벽한 설계도는 Class!
		 * 
		 * 다형성 : 부모 타입으로 자식 객체를 만드는 것 - Polymorphism, 헤터럴.. 이건 좀더 공부하고
		 * 부모꺼를 호출하지만 실제 자식 객체(가상 객체)가 실행되는 것을 Virtual Machine. 원리?
		 * 자신만의 멤버를 호출하려면 '오브젝트 캐스팅..Object Casting'
		 */
		//폴리몰피즘.
		Flyer bird = new Bird();
		Flyer ap = new AirPlane();
		Flyer sp = new SuperMan();
		
		//1.
		bird.fly(); //Virtual Method Invocation 원리..오버라이딩된 메소드에서만 나타남
		
		//2.
		String ret = ((Bird) bird).layEggs();
		System.out.println(ret);
	}

}
