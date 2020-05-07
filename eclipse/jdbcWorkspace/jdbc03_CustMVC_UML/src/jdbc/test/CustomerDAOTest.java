package jdbc.test;

import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.impl.CustomerDAOImpl;
import jdbc.vo.Customer;

public class CustomerDAOTest {
	//static 초기화 블락...
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading OK!!.....");
		} catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail.....");
		}
	}
	public static void main(String[] args) throws SQLException {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		//메소드 호출...할때 값 입력...해서 하나씩 완성해 나가보세요
		//dao.registerCustomer(new Customer("test2", "1234", "강호동", "서초동"));
		//dao.deleteCustomer("test");
		//dao.updateCustomer(new Customer("test", "1234", "이경규", "방배동"));
		//System.out.println(dao.getCustomer("test").toString());
		/*ArrayList<Customer> cList = dao.getAllCustomer();
		for(Customer c : cList) {
			System.out.println(c.toString());
		}*/
		System.out.println("로그인 성공 : " + dao.login(new Customer("test", "1234")).toString());
	}

}
