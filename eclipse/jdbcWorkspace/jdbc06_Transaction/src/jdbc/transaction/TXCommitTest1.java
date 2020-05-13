package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TXCommitTest1 {

	public static void main(String[] args) throws Exception{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("Driver Loading....");
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DBServer Connection....");
		
		String query1 = "INSERT INTO encore(name) VALUES(?)";//4
		String query2 = "SELECT no, name FROM encore WHERE no=?";
		
		//트랜잭션 시작...
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement(query1);
		ps.setString(1, "전지현");
		ps.executeUpdate();
		
		//no 7번에 해당하는 레코드가 존재하지 않는다...실패..rollback
		//no 7번에 해당하는 레코드가 존재하면은...성공..commit
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 3);//7
		ps2.executeQuery();
		ResultSet rs = ps2.executeQuery();
		
		if(!rs.next()) { //레코드가 존재하지 않다면..
			conn.rollback();
			System.out.println("찾는 번호에 해당하는 회원이 없어서 rollback!!! ");
		} else { //레코드가 존재한다면...
			conn.commit();
			System.out.println("번호에 해당하는 회원 발견 commit!!! ");
		}
		
		//트랜잭션 처리를 다시 원래대로 돌려놓음
		conn.setAutoCommit(true);
	}

}
