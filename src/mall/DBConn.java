package mall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	public DBConn() {
		String url = "jdbc:mysql://localhost:3306/javaclass3";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~");
		} catch (SQLException e) {
			System.out.println("DB 연동 실패~");
		}
	}
	
	// connClose()
	public void concClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// pstmtClose()
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}
	}
	
	// rsClose()
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			pstmtClose();
		} catch (SQLException e) {}
	}
}
