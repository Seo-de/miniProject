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

	public List<Kiosk> desertMenu() throws Exception {
		Connection conn = getConnection();
		
		List<Kiosk> kioList = dao.desertMenu(conn);
		
		close(conn);
		
		return kioList;

	}

	public List<Kiosk> ectMenu() throws Exception {
		Connection conn = getConnection();
		
		List<Kiosk> kioList = dao.ectMenu(conn);
		
		close(conn);
		
		return kioList;
	}
	
	/** 관리자 메뉴 추가
	 * @param kio
	 * @return result
	 * @throws Exception
	 */
	public int insertMenu(int input, Kiosk kio) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.insertMenu(conn, input, kio);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 관리자 메뉴 수정
	 * @param input
	 * @param kio
	 * @return
	 * @throws Exception
	 */
	public int updateMenu(int input, Kiosk kio) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateMenu(conn, input, kio);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}




	
	
	

	



	
}
