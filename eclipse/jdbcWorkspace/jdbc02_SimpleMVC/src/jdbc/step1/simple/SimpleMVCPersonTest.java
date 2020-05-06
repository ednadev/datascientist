package jdbc.step1.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*  구조적으로...작성....
 * 1. 드라이버 로딩
 * 2. 디비연결
 * 3. PreparedStatement 생성
 * 4. 쿼리문 실행
 * 5. close
 */
public class SimpleMVCPersonTest {

	public void addPerson(int ssn, String name, String address) throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		String query = "INSERT INTO person(ssn, name, address) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
	
		ps.setInt(1, ssn);
		ps.setString(2, name);
		ps.setString(3, address);
		
		ps.executeUpdate();
		System.out.println(name + " 님, 회원가입 되셨습니다...");
		
		ps.close();
		conn.close();
	}
	public void removePerson(int ssn) throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		String query = "DELETE FROM person WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, ssn);
		ps.executeUpdate();
		System.out.println("회원 탈퇴 하셨습니다...");
		
		ps.close();
		conn.close();
	}
	public void updatePerson(int ssn, String name, String address) throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		String query = "UPDATE person SET name=?, address=? WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setInt(3, ssn);
		
		ps.executeUpdate();
		System.out.println(name + " 님, 회원 수정 하셨습니다...");
		
		ps.close();
		conn.close();
	}
	public void searchAllPerson() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		String query = "SELECT name, address FROM person";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			System.out.println(name + ", " + address);
		}
		
		rs.close();
		ps.close();
		conn.close();
	}
	public void searchAPerson(int ssn) throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		String query = "SELECT name, address FROM person WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, ssn);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			System.out.println(name + ", " + address);
		}
		
		rs.close();
		ps.close();
		conn.close();
	}
	public static void main(String[] args) {
		SimpleMVCPersonTest mvc = new SimpleMVCPersonTest();
		/*try {
			mvc.addPerson(444, "아이유", "제주도"); //calling
		}catch(SQLException e) {
			System.out.println("회원 가입 실패...");
		}*/
		/*try {
			mvc.removePerson(444);
		} catch (SQLException e) {
			System.out.println("회원 탈퇴 실패...");
		}*/
		/*try {
			mvc.updatePerson(333, "강호동", "제주도");
		} catch (SQLException e) {
			System.out.println("회원 수정 실패...");
		}*/
		/*try {
			mvc.searchAllPerson();
		} catch (SQLException e) {
			System.out.println("회원 전체 조회 실패...");
		}*/
		try {
			mvc.searchAPerson(111);
		} catch (SQLException e) {
			System.out.println("회원 조회 실패...");
		}

	}

	//static initialization block...
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading....Success...");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading....Fail...");
		}
		System.out.println("static....");
	}
}
