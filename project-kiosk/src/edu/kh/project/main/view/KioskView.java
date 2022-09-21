package edu.kh.project.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.project.main.model.service.KioskService;

public class KioskView {
	
	private Scanner sc = new Scanner(System.in);
	
	private KioskService service = new KioskService();
	
	public void mainMenu() {
		
		int input = -1;
		
		do {
			try {
				System.out.println("de커피 메뉴");
				System.out.println();
				
				System.out.print("1. 커피");
				System.out.print("2. 논커피");
				System.out.print("3. 디저트");
				System.out.print("4. 랜덤 추천 메뉴");
				System.out.print("99. 관리자메뉴");
				
				System.out.println("메뉴 선택 : ");
				input = sc.nextInt();
				
				switch(input) {
				case 1 : coffeeMenu(); break;
				case 2 :  break;
				case 3 :  break;
				case 4 :  break;
				case 99 :  break;
				default : System.out.println("메뉴에 있는 번호만 선택해주세요.");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("!! 입력 방식이 올바르지 않습니다. !!");
				e.printStackTrace();
			}

		} while (input != 0);
	}
		
	
	public void coffeeMenu() {
		System.out.println("<커피 메뉴>");
		System.out.println();
		
		
	}
		
		

}
