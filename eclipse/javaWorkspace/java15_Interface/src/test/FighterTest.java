package test;

public class FighterTest {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		if(f instanceof Unit) {
			System.out.println("f는 Unit의 자손입니다..");
		}
		if(f instanceof Movable) {
			System.out.println("f는 Movable의 자손입니다..");
		}
		if(f instanceof Fightable) {
			System.out.println("f는 Fightable의 자손입니다..");
		}
	}
}

class Unit{
	int currentHP; //유닛의 체력
	int x;		//유닛의 위치(x좌표)	
	int y;		//유닛의 위치(y좌표)
}

interface Movable{
	void move(int x, int y);
}

interface Attackable{
	void attack(Unit u); //Hasing - Attackable에서 Unit을 가져다 썼으므로 
}

interface Fightable extends Movable, Attackable {
	//약할 때는 공격만 하지만, 강할 때는 움직이면서 공격도 해야 한다. 인터페이스와 인터페이스의 관계 : 상속!
	//자바는 단일 상속만 가능하지만 인터페이스는 다중 상속이 가능하다 --> 템플릿 기능이 강화된다
	//오버라이드 할 필요 없음..상속 받았으니까
}

//extends가 먼저 나오고, implements가 나중에 나와야 한다.
//이유는 extends 클래스는 단일 상속, implements 인터페이스는 다중 상속이 가능하기 때문!
class Fighter extends Unit implements Fightable {

	@Override
	public void move(int x, int y) {

	}

	@Override
	public void attack(Unit u) {

	}
	
}