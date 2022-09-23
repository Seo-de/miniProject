package edu.kh.project.main.model.coffee;

import static edu.kh.project.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import edu.kh.project.main.model.vo.Kiosk;

public class Coffee {
	
		Connection conn;
		Statement stmt;
//		PreparedStatement pstmt;
		ResultSet rs;
		Properties prop;
	
	public Coffee() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("kiosk-query.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Kiosk> coffeeMenu() {
		
		Connection conn = getConnection();
		List<Kiosk> kioList = new ArrayList<>();
		
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
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				close(rs);
				close(stmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return kioList;
	}
			

			
			

	

}
