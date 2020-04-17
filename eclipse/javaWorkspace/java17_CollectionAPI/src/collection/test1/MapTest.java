package collection.test1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map
 * ::
 * key-value를 쌍으로 저장하는 특징을 가진다.
 */
public class MapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("강호동", 90);
		map.put("이수근", 100);
		map.put("피오", 90);
		map.put("규현", 85);
		
		System.out.println(map);
		//1. 키만 받아온다...keySet()
		Set<String> set = map.keySet(); //containsKey : 있나 없나 확인하는 것이니 중요!
		
		//2. 키에 해당하는 value를 찾아서 출력
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name + " ====  " + map.get(name));
		}
		
		//3. 
		Collection<Integer> col = map.values(); //90, 100, 90, 85
		int total = 0;
		
		Iterator<Integer> value = col.iterator();
		
		while(value.hasNext()) {
			total += value.next();
		}
		System.out.println("총점 : " + total);
		
		//4.
		System.out.println("평균 : " + total/map.size());
		System.out.println("최고점수 : " + Collections.max(col));
		System.out.println("최저점수 : " + Collections.min(col));
	}

}
