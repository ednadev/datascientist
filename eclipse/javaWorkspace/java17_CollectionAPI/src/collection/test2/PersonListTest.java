package collection.test2;

import java.util.ArrayList;

public class PersonListTest {

	public static void main(String[] args) {
		//List안에 여러명의 Person들을 저장...순서대로..
		ArrayList<Person> list = new ArrayList<Person>(); //뒤에는 붙이든 안붙이든 상관없음
		
		list.add(new Person("이순신", "여의도", 67));
		list.add(new Person("강감찬", "순천", 45));
		list.add(new Person("을지문덕", "구미", 27));
		list.add(new Person("이순신1", "여의도", 37));
		list.add(new Person("강감찬1", "순천1", 45));
		list.add(new Person("을지문덕1", "여의도", 17));
		
		//System.out.println(list);
		
		//1. 두번째 장군을 찾아서 정보를 출력
		System.out.println(list.get(1));
		
		//2. 리스트에 들어있는 장군들의 숫자를 출력
		System.out.println(list.size());

		//3. 리스트에 저장된 장군들의 평균 연령을 출력
		int sum = 0;
		for(Person p : list) {
			sum += p.getAge();
		}
		System.out.println(sum/list.size());
		
		//4. 저장된 장군들의 이름만 출력
		for(Person p : list) {
			System.out.print(p.getName() + " ");
		}
		System.out.println();
		
		//5. 여의도에 사는 사람들만 출력
		for(Person p : list) {
			if(p.getAddr().equals("여의도")) {
				System.out.println(p.toString());
			}
		}
	}

}
