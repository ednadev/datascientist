package exam.test;
//필드와 static V가 어떻게 다른지를 확실하게 구분..
//static 변수는 생성된 객체들이 값을 공유한다...!!...의미를 정확하게 이해
class Car{
	int serialNumber; //Field -. Heap에 올라간다.
	static int counter; //static한 변수는 local에서 못 쓴다. .. class area에 올라간다. / static 값은 공유하는 서로 다른 객체들이 값을 공유할 때
	//객체마다 변하는 값은 field로 잡고, 서로 다른 객체들이 똑같이 공유해야 하는 건 static으로 잡는다. static은 고정된 상수값
	

	Car() {
		counter++; //1
		serialNumber = counter;
	}
}
public class StaticExamTest2 {

	public static void main(String[] args) {
		Car car1 = new Car(); // counter : 1 --> serialNumber : 1
		Car car2 = new Car(); // counter : 2 --> serialNumber : 2
		Car car3 = new Car(); // counter : 3 --> serialNumber : 3
		
		System.out.println("========== field =================");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("========== static V =================");
		System.out.println(Car.counter);
		System.out.println(car1.counter);
		System.out.println(car2.counter);
		System.out.println(car3.counter);
	}

}
