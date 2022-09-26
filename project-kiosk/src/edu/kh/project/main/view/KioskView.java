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
				System.out.println("4. 기타 메뉴");
				System.out.println("5. 랜덤 추천 메뉴");
				System.out.println("0. 주문 취소");
				System.out.println("99. 관리자메뉴");
				
				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : selectCoffee(); break;
				case 2 : selectNocoffee(); break;
				case 3 : selectDesert(); break;
				case 4 : selectEct(); break;
				case 5 :  break;
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
				System.out.print("커피 메뉴 선택 : ");
				int choiceCo = sc.nextInt();
				System.out.printf("%d %s을/를 선택하셨습니다.\n", choiceCo, kioList.get(choiceCo-1));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("!! 커피 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
		
	}
			

	private void selectNocoffee() {
		System.out.println("\n<논커피 메뉴>\n");
		

		try {
			List<Kiosk> kioList = service.nocoffeeMenu();
			
			if(kioList.isEmpty()) System.out.println("논커피 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getNocoffeeNo(), k.getMenuName(), k.getMenuPrice());
				}
				System.out.print("논커피 메뉴 선택 : ");
				int choiceNoco = sc.nextInt();
				System.out.printf("%d %s을/를 선택하셨습니다.\n", choiceNoco, kioList.get(choiceNoco-1));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("!! 논커피 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
		
	}
	
	private void selectDesert() {
		System.out.println("\n<디저트 메뉴>\n");
		try {
			List<Kiosk> kioList = service.desertMenu();
			
			if(kioList.isEmpty()) System.out.println("디저트 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getDesertNo(), k.getMenuName(), k.getMenuPrice());
				}
				System.out.print("디저트 메뉴 선택 : ");
				int choiceNoco = sc.nextInt();
				System.out.printf("%d %s을/를 선택하셨습니다.\n", choiceNoco, kioList.get(choiceNoco-1));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("!! 디저트 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
	}
	
	private void selectEct() {
		System.out.println("\n<기타 메뉴>\n");
		try {
			List<Kiosk> kioList = service.ectMenu();
			
			if(kioList.isEmpty()) System.out.println("기타 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getEctNo(), k.getMenuName(), k.getMenuPrice());
				}
				System.out.print("기타 메뉴 선택 : ");
				int choiceNoco = sc.nextInt();
				System.out.printf("%d %s을/를 선택하셨습니다.\n", choiceNoco, kioList.get(choiceNoco-1));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("!! 기타 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
	}
	
	
	private void managerMenu() {
		System.out.println("<<관리자 메뉴>>\n");
		
		System.out.print("아이디 : ");
		String id = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		try {
			if(id.equals("id12") && pw.equals("pw12")) {
				
				System.out.println("<<관리자 메뉴에 접속하셨습니다.>>\n");
				
				System.out.println("1. 메뉴 추가");
				System.out.println("2. 메뉴 수정");
				System.out.println("3. 메뉴 삭제");
				System.out.println("4. 로그아웃");
				
				System.out.print("번호 입력 : ");
				int input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : insertMenu(); break;
				case 2 : updateMenu(); break;
				case 3 :  break;
				case 4 :  break;
				default : System.out.println("메뉴의 번호만 입력해주세요.");
				} 
			
			} else System.out.println("!! 아이디/비밀번호를 다시 입력해주세요 !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	/**
	 * 관리자 메뉴 추가
	 */
	private void insertMenu() {
		try {
			System.out.println("\n<<관리자 메뉴 추가>>\n");
			
			int input = -1;
			do {
				System.out.println("1. 커피 추가");
				System.out.println("2. 논커피 추가");
				System.out.println("3. 디저트 추가");
				System.out.println("4. 기타 추가");
				System.out.println("0. 취소");
				
				System.out.print("번호 입력 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				if(input >= 1 && input <= 4) {
					System.out.print("추가할 메뉴 이름 : ");
					String plusMenu = sc.nextLine();
					System.out.println();
					
					
					System.out.print("추가할 메뉴 금액 : ");
					int plusPrice = sc.nextInt();
					sc.nextLine();
					
					Kiosk kio = new Kiosk();
					kio.setMenuName(plusMenu);
					kio.setMenuPrice(plusPrice);
					
					int result = service.insertMenu(input, kio);
					
					if(result > 0) System.out.println("메뉴가 추가 되었습니다.");
					else 			System.out.println("메뉴 추가에 실패했습니다.");
				}
				
				}while(input != 0);
				
				
			} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

		
			
	/**
	 * 관리자 메뉴 수정
	 */
	private void updateMenu() {
		
		try {
			
			System.out.println("\n<<관리자 메뉴 수정>>\n");
			
			int input = -1;
			do {
				System.out.println("1. 커피 수정");
				System.out.println("2. 논커피 수정");
				System.out.println("3. 디저트 수정");
				System.out.println("4. 기타 수정");
				System.out.println("0. 취소");
				
				System.out.print("번호 입력 : ");
				input = sc.nextInt();
				sc.nextLine();
						
				if(input == 1) {
					selectCoffee();
					updatePrint(input);
				} else if (input == 2) {
					selectNocoffee();
					updatePrint(input);
				} else if (input == 3) {
					selectDesert();
					updatePrint(input);
				} else {
					selectEct();
					updatePrint(input);
				}
					

				
			}while(input != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	private void updatePrint(int input) {
		try {
			System.out.println("수정할 번호 이름 : ");
			int updateNo = sc.nextInt();
			sc.nextLine();
			
			System.out.print("수정할 메뉴 이름 : ");
			String updateMenu = sc.nextLine();
			System.out.println();
			
			
			System.out.print("수정할 메뉴 금액 : ");
			int updatePrice = sc.nextInt();
			sc.nextLine();
			
			Kiosk kio = new Kiosk();
			kio.setMenuName(updateMenu);
			kio.setMenuPrice(updatePrice);
		
			int result = service.updateMenu(input, kio);
			
			if(result > 0) System.out.println("메뉴가 수정 되었습니다.");
			else 			System.out.println("메뉴 수정에 실패했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
