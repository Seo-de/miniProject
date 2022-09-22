package edu.kh.project.main.model.service;

import static edu.kh.project.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.project.main.model.dao.KioskDAO;
import edu.kh.project.main.model.vo.Kiosk;

public class KioskService {

	KioskDAO dao = new KioskDAO();

	/** 커피 메뉴 선택
	 * @return kioList
	 * @throws Exception
	 */
	public List<Kiosk> coffeeMenu() throws Exception {
		
		Connection conn = getConnection();
		
		Kiosk kiost = dao.coffeeMenu(conn, )
		
		List<Kiosk> kioList = dao.coffeeMenu();
		
		
		return null;
	}
	
}
