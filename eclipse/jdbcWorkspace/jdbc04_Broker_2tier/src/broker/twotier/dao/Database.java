package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate{
	
	public Database(String serverIp) throws ClassNotFoundException{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공....");
	}
	//공통적인 로직....
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn =DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();		
	}
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);	
	}
	
	public boolean isExist(String ssn, Connection conn)throws SQLException {
		//있는지 없는지 존재유무 확인...
		String sql ="SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}	
	
	//중복, record not found, .. 주식 100개 가지고 있는데 150개 팔려고 할 때
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			if(!isExist(cust.getSsn(), conn)) { //ssn이 없는거야...
				String query = "INSERT INTO customer(ssn, cust_name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
			
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
			
				System.out.println(ps.executeUpdate()+" 명 INSERT OK....addCustomer()...");
			}else { //ssn이 있는거야...
				throw new DuplicateSSNException(cust.getName()+" 님은 이미 회원이십니다...");
			}			
			
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			if(isExist(ssn, conn)) {
				String query = "DELETE FROM customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate() + " 명 DELETE OK....deleteCustomer()...");
			}else {
				throw new RecordNotFoundException("회원 정보를 찾을 수 없습니다...");
			}
		} finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			if(isExist(cust.getSsn(), conn)) {
				String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getSsn());
				
				System.out.println(ps.executeUpdate() + " 명 UPDATE OK....updateCustomer()...");
			} else {
				throw new RecordNotFoundException("회원 정보를 찾을 수 없습니다...");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public Vector<SharesRec> getPortfolio(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<SharesRec> list = new Vector<>();
		
		try {
			conn = getConnect();
			
			if(isExist(ssn, conn)) {
				String query = "SELECT * FROM shares WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new SharesRec(rs.getString("ssn"), rs.getString("symbol"), rs.getInt("quantity")));
				}
			} else {
				throw new RecordNotFoundException("회원 정보를 찾을 수 없습니다...");
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec c = null;
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				c = new CustomerRec(ssn, rs.getString("cust_name"), rs.getString("address"), getPortfolio(ssn));
			} else {
				throw new RecordNotFoundException("회원 정보를 찾을 수 없습니다...");
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return c;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustomerRec> list = new ArrayList<>();
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM customer";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CustomerRec(rs.getString("ssn"), rs.getString("cust_name"), rs.getString("address"), getPortfolio(rs.getString("ssn"))));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StockRec> list = new ArrayList<>();
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM stock";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new StockRec(rs.getString("symbol"), rs.getFloat("price")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			if(isExist(ssn, conn)) {
				String query = "INSERT INTO shares VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				ps.setString(2, symbol);
				ps.setInt(3, quantity);
				System.out.println(ps.executeUpdate() + "번 주식을 샀습니다.");
				
			} else {
				throw new RecordNotFoundException("회원 정보를 찾을 수 없습니다...");
			}
			
		} finally {
			closeAll(ps, conn);
		}
		
		
	}

	@Override
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			if(isExist(ssn, conn)) {
				
				for(SharesRec sr : getPortfolio(ssn)) {
					if(sr.getQuantity() == quantity) {
						String query = "DELETE FROM shares WHERE ssn=? AND symbol=?";
						ps = conn.prepareStatement(query);
						ps.setString(1, ssn);
						ps.setString(2, symbol);
					} else {
						String query = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
						ps = conn.prepareStatement(query);
						ps.setInt(1, quantity);
						ps.setString(2, ssn);
						ps.setString(3, symbol);
					}
					System.out.println(ps.executeUpdate() + "번 주식을 팔았습니다.");
					break;
				}
			} else {
				throw new RecordNotFoundException("회원 정보를 찾을 수 없습니다...");
			}
			
		} finally {
			closeAll(ps, conn);
		}
		
	}

}
