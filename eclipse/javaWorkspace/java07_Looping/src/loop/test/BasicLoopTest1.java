package loop.test;
/*
 * 반복문
 * ::
 * 해당하는 조건이 참인동안 코드블락을 계속 수행하는 로직
 * for /while/ do~while
 */
public class BasicLoopTest1 {

	public static void main(String[] args) {
		System.out.println("======= for =======");
		for(int i=0; i<=10; i++) {//0,1,2,...10
			System.out.println(i + ".Hello..For Loop..");
		}
		
		System.out.println("======= while =======");
		int i=10;
		while(i>0) {
			System.out.println(i + ".Hello..While Loop..");
			i--;
		}
		
		System.out.println("======= do~while =======");
		int j=0;
		do {
			System.out.println(j + ". Always Print..");
			j++; //증감식
		}while(j<10);

	}

}
