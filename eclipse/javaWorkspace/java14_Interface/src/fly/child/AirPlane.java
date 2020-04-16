package fly.child;

import fly.Flyer;

//
public class AirPlane implements Flyer{

	@Override
	public void fly() {
		System.out.println("비행기 난다.");
		
	}

	@Override
	public void land() {
		System.out.println("비행기 land.");
		
	}

	@Override
	public void take_off() {
		System.out.println("비행기 take_off.");
		
	}

}
