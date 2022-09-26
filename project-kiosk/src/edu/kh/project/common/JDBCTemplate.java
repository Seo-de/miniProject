package edu.kh.project.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	private static Connection conn = null;
	
	/** Connection 객체 생성 및 반환
	 * @return conn
	 */
	public static Connection getConnection() {
		
		try {
			if(conn == null || conn.isClosed()) {
				Properties prop = new Properties();
				
				prop.loadFromXML(new FileInputStream("driver.xml"));
				
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				Class.forName(driver);
				
				conn = DriverManager.getConnection(url, user, password);
				
				conn.setAutoCommit(false);
			}
			
			
		} catch (Exception e) {
			System.out.println("[Connection 생성 중 오류 발생]");
			e.printStackTrace();
		}	
		return conn;
	}
	
	
	/** Connection 객체 반환
	 * @param conn
	 */
	public static void close (Connection conn) {
		
		try {
			if(conn != null && conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** Statement 객체 반환
	 *  PreparedStatement 는 자식 객체라 안적어도 여기서 같이 반환
	 * @param stmt
	 */
	public static void close (Statement stmt) {
		try {
			if(stmt != null && stmt.isClosed()) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** ResultSet 객체 반환
	 * @param rs
	 */
	public static void close (ResultSet rs) {
		try {
			if(rs != null && rs.isClosed()) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 트랜잭션 commit 반환
	 * @param conn
	 */
	public static void commit (Connection conn) {
		try {
			if(conn != null && conn.isClosed())conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void rollback (Connection conn) {
		try {
			if(conn != null && conn.isClosed()) rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
