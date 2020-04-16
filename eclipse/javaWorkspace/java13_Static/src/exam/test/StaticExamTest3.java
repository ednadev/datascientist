package exam.test;
//static block
public class StaticExamTest3 {
	static int i;
	
	public static void main(String[] args) {
		System.out.println("1. main method static block...." + i);
		
		//객체 생성...(); ---> (){ // }
		//생성자 생성은 객체 초기화! 객체 마다 초기화 하는 것!
	}
	
	static {
		i=300;
		System.out.println("2. static initialization block...." + i); // main보다 static이 먼저 돌아간다.
		//main method static block보다 static initialization block이 먼저 돌아간다.
		//객체들이 다 받아갈 값은 static으로!
	}

}
