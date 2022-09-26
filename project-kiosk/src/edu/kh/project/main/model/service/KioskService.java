package edu.kh.project.main.model.service;

import static edu.kh.project.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.project.main.model.dao.KioskDAO;
import edu.kh.project.main.model.vo.Kiosk;

public class KioskService {

	private KioskDAO dao = new KioskDAO();

	/** 커피 메뉴 
	 * @return kioList
	 */
	public List<Kiosk> coffeeMenu() throws Exception {
		
		Connection conn = getConnection();
		
		List<Kiosk> kioList = dao.coffeeMenu(conn);
		
		close(conn);
		
		return kioList;
	}

	
	/** 노커피 메뉴
	 * @return kioList
	 */
	public List<Kiosk> nocoffeeMenu() throws Exception {
		
		Connection conn = getConnection();
		
		List<Kiosk> kioList = dao.nocoffeeMenu(conn);
		
		close(conn);
		
		return kioList;

	}


	/** 관리자 메뉴 추가
	 * @param kio
	 * @return result
	 * @throws Exception
	 */
	public int insertMenu(Kiosk kio) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.insertMenu(conn, kio);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	

	



	
}
