package collection.test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CustomerMapTest {

	public static void main(String[] args) {
		HashMap<String, Customer> map = new HashMap<>();
		
		map.put("111", new Customer("kim", "김제동", 40));
		map.put("222", new Customer("seung", "성유리", 35));
		map.put("333", new Customer("lee", "이경규", 55));
		
		Set<String> keys = map.keySet();
		//1. 222에 해당하는 사람의 정보를 출력
/*		for(String key : keys) {
			if(key.equals("222")) {
				System.out.println(map.get(key).toString());
			}
		}*/
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			if(name.equals("222")) {
				System.out.println(map.get(name).toString());
			}
		}
		
		//2. id가 kim인 사람을 찾아서 그 사람의 이름을 출력
		for(String key : keys) {
			if(map.get(key).getId().equals("kim")) {
				System.out.println(map.get(key).getName());
			}
		}
		
		//3. map에 저장된 모든 key값을 출력
		for(String key : keys) {
			System.out.print(key + " ");
		}
		
		//4. 모든 사람의 나이의 총합과 평균연령을 출력
		int sum = 0;
		for(String key : keys) {
			sum += map.get(key).getAge();
		}
		System.out.println("\n총합 : " + sum);
		System.out.println("평균연령 : " + sum/map.size());
	}

}
