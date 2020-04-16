package exam.test;
/*
 * 
 * final 키워드 + static 키워드
 * final :: 내가 마지막이야~~~
 * final + 변수 : 내가 마지막 변수야~~~ --> 상수를 의미 static final int COUNTER = 1;
 * final + 클래스 : 내가 마지막 클래스야~~~ --> 상속금지
 * final + 메소드 : 내가 마지막 메소드야~~~ --> 오버라이딩 금지
 */
class A {
	//공용의 의미로 public도 붙이기!
	public final static int BASE_SALARY = 300;
	public final String test() {
		return "Overriding 금지";
	}
}

final class B { //상속금지
	
}
/*class C extends B { C는 B를 상속받지 못한다.
}*/

class D extends A {
	//기입을 했다는 건 고쳐 쓰겠다는 것! 그건 Overriding이므로 final로 금지시켜놓아서 에러!
	/*public final String test() {
		return "Overriding 금지";
	}*/
}
public class StaticExamTest4 {
	
	public static void main(String[] args) {
		
	
	}
	
}
