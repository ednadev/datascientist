package fly.child;

import fly.Flyer;

/*
 * stop_bullet() 추가...마무리...
 */
public class SuperMan implements Flyer{
	
	@Override
	public void fly() {
		System.out.println("슈퍼맨이 난다.");
		//SIZE = 150;
		System.out.println("시속 " + SIZE + "km...");
	}

	@Override
	public void land() {
		System.out.println("슈퍼맨이 land.");
		
	}

	@Override
	public void take_off() {
		System.out.println("슈퍼맨이 take_off.");
		
	}
	
	public void stop_bullet() {
		
	}

}
