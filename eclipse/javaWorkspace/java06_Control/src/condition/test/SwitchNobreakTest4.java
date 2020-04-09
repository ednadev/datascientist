package condition.test;
/*
 * Math - Static 성질을 가지고 있음 (S로 표시), 미리 메모리에 올라가 있어서 객체 생성 하지 않아도 된다.
 * Math.random() 와 함께
 * switch문에서의 break 키워드에 대해서 살펴보자.
 */
public class SwitchNobreakTest4 {

	public static void main(String[] args) {
		//8~11사이의 랜덤한 정수
		int time = (int)(Math.random()*4) + 8; 
		System.out.println("[현재시간: " + time + " 시]");
		
		switch(time) {
			case 8:
				System.out.println("출근합니다.");
			case 9:
				System.out.println("오전회의 합니다.");
			case 10:
				System.out.println("오전 업무 봅니다.");
			case 11:
				System.out.println("외근나갑니다.");
		}
	}

}
