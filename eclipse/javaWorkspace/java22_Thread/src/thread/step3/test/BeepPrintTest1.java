/*
 * 해당코드에서는 별도의 쓰레드를 작성하지 않고 실행....
 * 경고음을 발생시키고 / 동시에 경고음을 콘솔로 프린팅하는 작업 --> 병렬적인 작업
 * 두가지 일을 main 아래에서 처리하도록 할 것이다.
 */
package thread.step3.test;

import java.awt.Toolkit;

public class BeepPrintTest1 {
	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit();
		//경고음 5번 울리는 작업...
		for(int i=0; i<5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}//for
		
		//띵띵띵띵띵을 5번 출력하는 작업
		for(int i=0; i<5; i++) {
			System.out.println("띵~~~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		//thread X , process 작업  -- Test 클래스는 프로세스! 메인이 꼭 있어야 하는데, 즉! 메인이 쓰레드 (demon thread) Single Thread 모드!
		//thread가 하나라 병렬작업이 불가능.. Single Thread가 돌고 있다는 것만 확인
	}

}
