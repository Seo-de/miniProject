package edu.kh.project.main.view;

import static edu.kh.project.common.JDBCTemplate.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.project.main.model.coffee.Coffee;
import edu.kh.project.main.model.service.KioskService;
import edu.kh.project.main.model.vo.Kiosk;

public class KioskView {
	
	private Scanner sc = new Scanner(System.in);
	
	private KioskService service = new KioskService();
	
	private Coffee cof = new Coffee();
	
	public void mainMenu() {
		
		int input = -1;
		
		do {
			try {
				System.out.println("de커피 메뉴");
				System.out.println();
				
				System.out.println("1. 커피");
				System.out.println("2. 논커피");
				System.out.println("3. 디저트");
				System.out.println("4. 랜덤 추천 메뉴");
				System.out.println("0. 주문 취소");
				System.out.println("99. 관리자메뉴");
				
				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : selectCoffee(); break;
				case 2 : selectNocoffee(); break;
				case 3 :  break;
				case 4 :  break;
				case 0 : System.out.println("주문을 취소하셨습니다"); break;
				case 99 : managerMenu(); break;
				default : System.out.println("메뉴에 있는 번호만 선택해주세요.");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("!! 입력 방식이 올바르지 않습니다. !!");
				sc.nextLine();
				e.printStackTrace();
			}

		} while (input != 0);
	}
		
	
	private void selectCoffee() {
		System.out.println("\n<커피 메뉴>\n");
		

		try {
			List<Kiosk> kioList = service.coffeeMenu();
			
			if(kioList.isEmpty()) System.out.println("커피 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getCoffeeNo(), k.getMenuName(), k.getMenuPrice());
				}
				System.out.println("커피 메뉴 선택 : ");
				int choiceCo = sc.nextInt();
				System.out.printf("%d %s을/를 선택하셨습니다.\n", choiceCo, kioList.get(choiceCo-1));

			}
		} catch (Exception e) {
			System.out.println("!! 커피 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
		
	}
			

	private void selectNocoffee() {
		System.out.println("\n<커피 메뉴>\n");
		

		try {
			List<Kiosk> kioList = service.nocoffeeMenu();
			
			if(kioList.isEmpty()) System.out.println("논커피 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getNocoffeeNo(), k.getMenuName(), k.getMenuPrice());
				}
				System.out.println("논커피 메뉴 선택 : ");
				int choiceNoco = sc.nextInt();
				System.out.printf("%d %s을/를 선택하셨습니다.\n", choiceNoco, kioList.get(choiceNoco-1));

			}
		} catch (Exception e) {
			System.out.println("!! 커피 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
		
	}
	
	
	
	private void managerMenu() {
		System.out.println("<<관리자 메뉴>>\n");
		
		System.out.println("아이디 : ");
		String id = sc.next();
		
		System.out.println("비밀번호 : ");
		String pw = sc.next();
		
		try {
			if(id.equals("id12") && pw.equals("pw12")) {
				
				System.out.println("<<관리자 메뉴에 접속하셨습니다.>>\n");
				
				System.out.println("1. 메뉴 추가");
				System.out.println("2. 메뉴 수정");
				System.out.println("3. 메뉴 삭제");
				System.out.println("4. 로그아웃");
				
				System.out.println("번호 입력 : ");
				int input = sc.nextInt();
				
				switch(input) {
				case 1 : insertMenu(); break;
				case 2 :  break;
				case 3 :  break;
				case 4 :  break;
				default : System.out.println("메뉴의 번호만 입력해주세요.");
				} 
			
			} else System.out.println("!! 아이디/비밀번호를 다시 입력해주세요 !!");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
