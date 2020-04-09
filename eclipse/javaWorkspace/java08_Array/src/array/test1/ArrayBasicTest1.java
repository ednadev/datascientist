package array.test1;

class ArrayExam{
	String type = "배열";
	public String type() {
		return type;
	}
}
public class ArrayBasicTest1 {

	public static void main(String[] args) {
		ArrayExam exam = new ArrayExam();
		//1. 선언과 생성
		int[] arr = new int[3]; // |0|0|0|
		
		/*for(int i=0; i<arr.length; i++) { //length()가 아니다. length는 함수가 아닌 필드!
			System.out.print(arr[i] + " ");
		}*/
		
		System.out.println("=== Default Value ===");
		//향상된 for문...뭐가 어디안에서 돌아가는가?
		for(int val : arr) System.out.print(val + " ");
		
		//FQCN(Full Qualified Class Name) : 패키지 명을 포함한 클래스 전체 이름을 뜻한다. array.test1.ArrayExam 등
		System.out.println("\n"+exam); //array.test1.ArrayExam@7852e922 : array.test1 패키지에 있는 ArrayExam 클래스의 주소 위치는 7852e922이다.
		System.out.println("\n"+exam.toString()); //레퍼런스변수는 무조건 뒤에 toString이 생략된다.
		
		System.out.println(arr); //[I@4e25154f : Array는 클래스 타입이 존재하지 않는다. API에서 length를 못 찾음.. 딱 이거만 field로 가지고 있음
		
		//2. 배열의 초기화(명시적 초기화)
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		for(int val : arr) System.out.print(val + " ");
		
		System.out.println();
		
		//3. 선언 + 생성 + 초기화를 한꺼번에
		int[] arr2 = {11, 22, 33};
		System.out.println("arr2 주소값 : " + arr2);
		for(int val : arr2) System.out.print(val + " ");
		System.out.println("\n arr2 배열의 크기 " + arr2.length); //3
		
		//4. arr2
		/*
		 * 배열은 Resizing이 안된다.
		 * 만약에 사이즈를 변경하면 새로운 배열객체가 생성...
		 */
		arr2 = new int[5];
		System.out.println("arr2 주소값 : " + arr2);
		arr2[3] = 44;
		arr2[4] = 55;
		for(int val : arr2) System.out.println(val + " ");
	}

}
