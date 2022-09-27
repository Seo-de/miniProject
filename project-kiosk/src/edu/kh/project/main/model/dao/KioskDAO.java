package edu.kh.project.main.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.project.main.model.vo.Kiosk;
import edu.kh.project.main.view.KioskView;

public class KioskDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	
	public KioskDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("kiosk-query.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/** 커피 메뉴
	 * @return
	 */
	/**
	 * @param conn
	 * @return
	 */
	public List<Kiosk> coffeeMenu(Connection conn) throws Exception {
		
		List<Kiosk> kioList = new ArrayList();
		
		try {
			String sql = prop.getProperty("coffee");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Kiosk kio = new Kiosk();
				
				kio.setCoffeeNo(rs.getInt("MENU_COFFEE_NO"));
				kio.setMenuName(rs.getString("MENU_NAME"));
				kio.setMenuPrice(rs.getInt("MENU_PRICE"));
				
				kioList.add(kio);
			}

		} finally {
			close(rs);
			close(stmt);
		}

		return kioList;
	}


	/** 노커피
	 * @param conn
	 * @return kioList
	 */
	public List<Kiosk> nocoffeeMenu(Connection conn) throws Exception{
		
		List<Kiosk> kioList = new ArrayList();
		
		try {
			String sql = prop.getProperty("nocoffee");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Kiosk kio = new Kiosk();
				
				kio.setNocoffeeNo(rs.getInt(1));
				kio.setMenuName(rs.getString(2));
				kio.setMenuPrice(rs.getInt(3));
				
				kioList.add(kio);
			}

		} finally {
			close(rs);
			close(stmt);
		}

		return kioList;
	}
	
	

	/** 디저트
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Kiosk> desertMenu(Connection conn) throws Exception {
		List<Kiosk> kioList = new ArrayList();
		
		try {
			String sql = prop.getProperty("desert");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Kiosk kio = new Kiosk();
				
				kio.setDesertNo(rs.getInt(1));
				kio.setMenuName(rs.getString(2));
				kio.setMenuPrice(rs.getInt(3));
				
				kioList.add(kio);
			}

		} finally {
			close(rs);
			close(stmt);
		}
		return kioList;
	}
	
	
	/** 기타
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Kiosk> ectMenu(Connection conn) throws Exception {
		List<Kiosk> kioList = new ArrayList();
		
		try {
			String sql = prop.getProperty("ect");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Kiosk kio = new Kiosk();
				
				kio.setEctNo(rs.getInt(1));
				kio.setMenuName(rs.getString(2));
				kio.setMenuPrice(rs.getInt(3));
				
				kioList.add(kio);
			}

		} finally {
			close(rs);
			close(stmt);
		}
		return kioList;
	}
	
	
	
	/** 랜덤 메뉴 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Kiosk> allMenu(Connection conn) throws Exception{
		
		List<Kiosk> kioList = new ArrayList<>();
		try {
			String sql = prop.getProperty("random");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Kiosk kio = new Kiosk();
				kio.setMenuName(rs.getString(1));
				kio.setMenuPrice(rs.getInt(2));
				
				kioList.add(kio);
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		return kioList;
	}
	
	

	/** 관리자 메뉴 추가
	 * @param conn
	 * @param kio
	 * @return result
	 * @throws Exception
	 */
	public int insertMenu(Connection conn, int input, Kiosk kio) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("plusMenu1")
						+ prop.getProperty("plusMenu2-"+input);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kio.getMenuName());
			pstmt.setInt(2, kio.getMenuPrice());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 관리자 메뉴 수정
	 * @param conn
	 * @param input
	 * @param kio
	 * @return
	 * @throws Exception
	 */
	public int updateMenu(Connection conn, int input, Kiosk kio) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateMenu1")
						+ prop.getProperty("updateMenu2-"+input);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kio.getMenuName());
			pstmt.setInt(2, kio.getMenuPrice());
			if (input == 1) pstmt.setInt(3, kio.getCoffeeNo());
			else if(input == 2) pstmt.setInt(3, kio.getNocoffeeNo());
			else if(input == 3) pstmt.setInt(3, kio.getDesertNo());
			else pstmt.setInt(3, kio.getEctNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}


	/** 관리자 메뉴 삭제
	 * @param conn
	 * @param input
	 * @param kio
	 * @return
	 */
	public int deleteMenu(Connection conn, int input, Kiosk kio) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteMenu1")
						+ prop.getProperty("deleteMenu2-"+input);
			
			pstmt = conn.prepareStatement(sql);

			if (input == 1) pstmt.setInt(1, kio.getCoffeeNo());
			else if(input == 2) pstmt.setInt(1, kio.getNocoffeeNo());
			else if(input == 3) pstmt.setInt(1, kio.getDesertNo());
			else pstmt.setInt(1, kio.getEctNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}






		
		

}
