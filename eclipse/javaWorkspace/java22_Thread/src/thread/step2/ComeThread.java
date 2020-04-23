package thread.step2;
//Thread 클래스...
public class ComeThread implements Runnable {
	
/*	public ComeThread(String name) {
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
