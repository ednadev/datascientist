package com.encore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Count {

	public String execute(String book) {
		String word = "";
		
		HashMap<String, Integer> map = new HashMap<>();
		for(String b : book.toLowerCase().split(" ")) {
			Integer count = map.get(b);
			map.put(b, (count == null) ? 1 : count+1);
		}
		
		Iterator<String> it = map.keySet().iterator();
		int max = 0; //돌리면서 이 값보다 큰 값을 넣고 해당하는 value를 max
		while(it.hasNext()) {
			String key = it.next();
			if(map.get(key)>max) {
				max = map.get(key);
			}
		}
		
		TreeMap<String, Integer> tm = new TreeMap<>(map);
		Iterator<String> it2 = tm.descendingKeySet().iterator();
		while(it2.hasNext()) {
			String key = it2.next();
			if(max==tm.get(key)) {
				word = key;
			}
		}

		return word;
	}

	public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
