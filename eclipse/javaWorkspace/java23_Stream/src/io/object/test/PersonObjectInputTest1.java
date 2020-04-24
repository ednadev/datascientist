/*
 * 역직렬화::pack
 */
package io.object.test;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
 * 직렬화 코드...
 * Serialization :: Data UnPack
 * Person 객체를 Sink 쪽으로 날린다.
 * 1. ObjectOutputStream 생성
 * 2. writeObject(object);
 */
public class PersonObjectInputTest1 {

	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\person.obj"));
		
		Person p = (Person) ois.readObject();
		System.out.println(p);
	}

}
