package condition.test;

public class ConditionTest5 {

	public static void main(String[] args) {
		int dice = (int)(Math.random()*6 + 1);//1~6사이의 랜덤한 정수가 할당되도록...
		/*
		 * 1이면 Dice1
		 */
		switch(dice) {
			case 1: System.out.println("Dice 1"); break;
			case 2: System.out.println("Dice 2"); break;
			case 3: System.out.println("Dice 3"); break;
			case 4: System.out.println("Dice 4"); break;
			case 5: System.out.println("Dice 5"); break;
			case 6: System.out.println("Dice 6"); break;
			default: System.out.println("잘못된 결과입니다.");
		}
	}

}
