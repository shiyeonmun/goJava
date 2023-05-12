package ch20.oracle.sec06;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardingWithFileInsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"java_cli",
				"java_cli"
			);
			
			// 매개변수화된 SQL문
			String sql = "" + 
			"INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " + 
			"VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";
			
			//preparedStatement 얻기, 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"bno"});
			pstmt.setString(1, "눈 오는 날");
			pstmt.setString(2, "함박눈이 내려요");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "snow.jpg");
			pstmt.setBlob(5, new FileInputStream("src/ch20/oracle/sec06/snow.jpg"));
			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수:" + rows);
			
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno: " + bno);
				}
				rs.close();
			} pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {}
			}
		}
	}
}
