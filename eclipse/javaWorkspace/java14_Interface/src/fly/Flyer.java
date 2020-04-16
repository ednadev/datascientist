package fly;
//완벽한 추상화...구현된 것이 하나도 없어야 인터페이스이다.
//인터페이스 구성요소 = 추상메소드 + 상수
public interface Flyer {
	public static final int SIZE = 100;
	//날으는 것과 관련된 기능의 Template을 선언...
	public abstract void fly(); 
	void land(); //무조건 앞에 public abstract 가 생략된다.
	void take_off();
}
