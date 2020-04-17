package pizza.test;

import java.util.Vector;

import pizza.child.BugogiPizza;
import pizza.child.PineApplePizza;
import pizza.child.PotatoPizza;
import pizza.parent.Pizza;
import pizza.service.PizzaService;

public class PizzaServiceTest {

	public static void main(String[] args) {
		PizzaService service = new PizzaService();
		Vector<Pizza> v = new Vector<>();//10칸짜리 만들어진다.
		
		v.add(new PotatoPizza(12000, "Pizza Hut"));
		v.add(new BugogiPizza(12000, "Domino Pizza"));
		v.add(new PineApplePizza(27000, "미스터 피자"));
		v.add(new BugogiPizza(25000, "오구피자"));
		
		System.out.println("Vector안에 저장된 피자의 수 : " + v.size()); //저장된 데이타 갯수
		System.out.println("Vector의 Capacity : " + v.capacity()); //벡터의 용량
		System.out.println("Pizza Information" + v);//객체정보
		
		service.allMakePizza(v);
	}

}
