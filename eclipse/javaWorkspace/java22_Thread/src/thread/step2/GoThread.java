/*
 * 쓰레드를 만드는 방법
 * 1. extends Thread
 * 2. implements Runnable ---> v //다중 상속을 받을 때는 이 방법 사용해야 하기 때문에! API를 확인하면 메소드가 run밖에 없다
 */
package thread.step2;
//Thread 클래스...
public class GoThread implements Runnable {
	
	//private String name;
/*	public GoThread(String name) {
		super(name);
	}*/

	@Override
	public void run() {
		int i = 0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				
			}
			String tname = Thread.currentThread().getName();
			System.out.println("CurrentThread :: " + tname + ", " + i);
			i++;
			if(i==20) break;
		}
	}

}
