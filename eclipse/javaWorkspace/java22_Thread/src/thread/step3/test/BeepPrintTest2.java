/*
 * BeepPrintTest1 실행클래스....하나의 프로세스
 * 이 안에는 메인쓰레드 하나밖에 없었다.
 * 병렬작업이 불가능했다.
 * -------------------------------------------
 * BeepPrintTest2 실행클래스....하나의 프로세스
 * 이 안에 메인쓰레드 + 작업쓰레드를 하나 더 추가
 * 1) 메인쓰레드 : beep()를 5번---경고음을 5번 발생
 * 2) 작업쓰레드 - BeepPrintThread - --- 띵을 5번 출력
 * 
 */
package thread.step3.test;

import java.awt.Toolkit;

public class BeepPrintTest2 {
	public static void main(String[] args) { //출발점
		
		BeepPrintThread beepT = new BeepPrintThread();
		beepT.start(); //하나는 run으로 가고, 하나는 밑으로 실행 (병렬 작업 시작되는 시점)
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		//경고음 5번 울리는 작업...
		for(int i=0; i<5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}//for
	}
	
}

class BeepPrintThread extends Thread{

	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("띵~~~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
	}//run
}//class
