package menus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private String  driver  = "oracle.jdbc.OracleDriver";
	private String  dburl   = "jdbc:oracle:thin:@localhost:1521:xe";
	private String  dbuid   = "test";
	private String  dbpwd   = "1234";
	
	private Connection conn = null;
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, dbuid, dbpwd);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버설정을 확인하세요");
		} catch (SQLException e) {
			System.out.println("db연결이 잘못되었습니다");
		}
		
		return conn;
 
	}
	// db 연결
}
