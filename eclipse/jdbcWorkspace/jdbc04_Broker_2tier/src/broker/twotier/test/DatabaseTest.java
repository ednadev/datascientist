package broker.twotier.test;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception{
		Database db = new Database("127.0.0.1");
		
		//db.addCustomer(new CustomerRec("123-123", "아이유", "판교"));
		//db.deleteCustomer("123-123");
		//db.updateCustomer(new CustomerRec("123-123", "강호동", "서초동"));
		
		/*for(StockRec r : db.getAllStocks()) {
			System.out.println(r.toString());
		}*/
		
		//db.buyShares("123-123", "GMEnt", 20);
		/*for(SharesRec sr : db.getPortfolio("123-123")) {
			System.out.println(sr.toString());
		}*/
		
		//주식 사고 나서 portfolio 제대로 들어오는지 확인
		//System.out.println(db.getCustomer("123-123")); 
		/*for(CustomerRec c : db.getAllCustomers()) {
			System.out.println(c.toString());
		}*/
		
		db.sellShares("123-123", "TMAs", 10);
		
	}

}
