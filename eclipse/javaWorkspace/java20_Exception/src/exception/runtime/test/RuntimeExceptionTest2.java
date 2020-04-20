/*
 * NullPointerException::
 * 객체 생성하지 않고 객체의 멤버에 접근하려고 할때 발생하는 예외....
 * 객체 생성하지 않고 == null
 * (발생하면 null을 만난 곳으로 찾는다. 객체 생성하지 않고 발생하는 곳을 찾는다)
 * 
 * cat는 여러번 할수 있다...
 * 하지만 그 중에서 단 한번만 수행된다...
 * 
 * finally
 * ::
 * 예외와 상관없이 무조건 수행되어져야 하는 코드가 있다면...
 * 이 안에다 집어넣어야 한다.
 */
package exception.runtime.test;

public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		System.out.println("========== NullPointerException========");
		//String str1 = "Encore"; //Literal Pool
		String str = new String("Encore"); //Heap
		System.out.println(str.toString()); //Encore : Object의 toString을 물려받아서 String에서는 toString을 오버라이딩 해서 쓴다. 그래서 주소값이 아닌 Encore가 나옴
		
		str = null; 
		try {
			System.out.println("str의 데이타 값 :: " + str); //null
			System.out.println("str 문자열 길이 :: " + str.length()); //
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("잡았다...1");
		} catch (NullPointerException e) {
			System.out.println("잡았다...2");
		} catch (Exception e) {
			System.out.println("잡았다...3");
		} finally {
			System.out.println("Always Print...");
		}
	}
}
/*
 * 1. 예외 발생코드 작성... + 예외가 발생 안함.
 * 	  try + finally
 * 2. 예외 발생코드 작성... + 예외가 발생 + 그 예외를 잘 잡음.
 * 	  catch + finally
 * 3. 예외 발생코드 작성... + 예외가 발생 + 그 예외를 잘 못잡음.
 *    finally
 *    
 *    finally에 주로 넣는 코드
 *    --> 자원을 반납하는 코드...close()
 *    
 *    finally가 동작하지 않는 경우가 있다.
 *    1) 이 안에서 다시 예외가 발생할때...이 안의 try~catch로 감싸야 한다. (finally 안에서 또다른 예외가 발생할 때 실행이 안된다. finally를 try~catch를 싸서 돌려야 한다.)
 */