package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.CustomerDAO;
import jdbc.vo.Customer;
/*
 * dao란?
 * Database Access Object의 약자로...
 * 디비에 접근하는 로직(중요한 로직...일명 비지니스로직)을 담고 있는 객체이다.
 * ::
 * 공통적인 로직과 가변적인 로직 둘로 나눠어서 작성해준다.
 */
public class CustomerDAOImpl implements CustomerDAO{
	
	//싱글톤
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
    //공통적인 로직 
	@Override
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
    //비지니스 로직 /////////////////////////////////////////////////////////
	@Override
	public void registerCustomer(Customer vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnect();

		String query = "INSERT INTO cust(id, pass, cust_name, address) VALUES(?, ?, ?, ?)";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPass());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}

	@Override
	public void deleteCustomer(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnect();
		
		String query = "DELETE FROM cust WHERE id=?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}

	@Override
	public void updateCustomer(Customer vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnect();
		
		String query = "UPDATE cust SET cust_name=?, address=? WHERE pass=?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		ps.setString(2, vo.getAddress());
		ps.setString(3, vo.getPass());
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}

	@Override
	public Customer getCustomer(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		
		conn = getConnect();
		
		String query = "SELECT * FROM cust WHERE id=?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		rs = ps.executeQuery();
		while(rs.next()) {
			c = new Customer(rs.getString("id"), rs.getString("pass"), rs.getString("cust_name"), rs.getString("address"));
		}
		
		closeAll(rs, ps, conn);
		return c;	
	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> cList = new ArrayList<>();
		
		conn = getConnect();
		
		String query = "SELECT * FROM cust";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while(rs.next()) {
			cList.add(new Customer(rs.getString("id"), rs.getString("pass"), rs.getString("cust_name"), rs.getString("address")));
		}
		closeAll(rs, ps, conn);
		return cList;
	}

	@Override
	public Customer login(Customer vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		
		conn = getConnect();
		
		String query = "SELECT * FROM cust WHERE id=? AND pass=?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPass());
		
		rs = ps.executeQuery();
		while(rs.next()) {
			c = new Customer(rs.getString("id"), rs.getString("pass"), rs.getString("cust_name"), rs.getString("address"));
		}
		
		closeAll(ps, conn);
		return c;
	}

}
