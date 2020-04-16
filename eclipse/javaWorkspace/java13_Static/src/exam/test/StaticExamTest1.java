package exam.test;
/*
 * 1. static 한 멤버는 객체 생성없이 사용할 수 있다
 */
class Member{
	static String name = "길똥이";
	static int age = 22; //static V, class V, 전역변수
	int count = 1; //필드, 멤버V
	
	public static void getMember() {
		System.out.println("우/유/빛/깔/ " + name);
		//static영역에는 static만 사용할 수 있기 때문에 count를 사용하지 못한다.
		//System.out.println("count : " + count);
	}
	//non-static
	public void getMember2() {
		System.out.println("우/유/빛/깔/ " + name);
	}
}
public class StaticExamTest1 {

	public static void main(String[] args) {
		/*Member m = new Member();
		m.getMember();*/
		
		Member.getMember();
		//static은 static끼리 통한다.. main이 static이기 때문에 static한 애들을 사용할 수 있다
		//Member.getMember2();
		
		//static은 메모리에 미리 올라가므로 Heap이 아닌 class area에 올라간다. 가비지 컬렉터의 대상이 아니라 지워지지 않는다. 가비지 컬렉터는 Heap만 청소하기 때문에
		//전부 static으로 만들면 메모리 효율성을 급격하게 저하시킬 수 있다.
		

	}

}
