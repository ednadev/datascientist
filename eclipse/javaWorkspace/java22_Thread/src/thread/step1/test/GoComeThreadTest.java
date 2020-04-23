package thread.step1.test;

import thread.step1.ComeThread;
import thread.step1.GoThread;

public class GoComeThreadTest {

	public static void main(String[] args) {
		//1. Thread 생성....
		GoThread go = new GoThread("GoThread");
		ComeThread come = new ComeThread("ComeThread");

		//2. start를 호출...
		go.start(); //Runnable ---> run(); ---> run(){}
		come.start(); //Runnable ---> run(); ---> run(){}
		
		//런메소드 호출을 받는 쓰레드는 시간이 좀 걸릴 뿐이지 cpu 보장을 받는다. 무조건 running 된다.
		//go, come 섞여서 나옴.. 쓰레드의 본성은 인터럭티브.. 끼어드는 것! waiting하지 않는다.
		
		
	}

}
