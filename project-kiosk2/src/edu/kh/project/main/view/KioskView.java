package edu.kh.project.main.view;

import static edu.kh.project.common.JDBCTemplate.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.project.main.model.service.KioskService;
import edu.kh.project.main.model.vo.Kiosk;

public class KioskView {
	
	private Scanner sc = new Scanner(System.in);
	
	private KioskService service = new KioskService();
	
	public void mainMenu() {
		
		int input = -1;
		
		do {
			try {
				System.out.println("\nde커피 메뉴");
				System.out.println();
				
				System.out.println("1. 커피");
				System.out.println("2. 논커피");
				System.out.println("3. 디저트");
				System.out.println("4. 기타 메뉴");
				System.out.println("5. 랜덤 메뉴 추천");
				System.out.println("0. 주문 취소");
				System.out.println("99. 관리자메뉴");
				
				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : selectCoffee(); break;
				case 2 : selectNocoffee(); break;
				case 3 : selectDesert(); break;
				case 4 : selectEct(); break;
				case 5 : selectRandom(); break;
				case 0 : System.out.println("주문을 취소하셨습니다"); break;
				case 99 : managerMenu(); break;
				default : System.out.println("\n메뉴에 있는 번호만 선택해주세요.\n");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("\n!! 입력 방식이 올바르지 않습니다. !!\n");
				sc.nextLine();
				e.printStackTrace();
			}

		} while (input != 0);
	}
		

	
	
	
	private void selectCoffee() {
		System.out.println("\n<커피 메뉴>\n");
		int choice=0;
		int sum=0;
		int input = -1;
		int inputNo=-1;
		try {
			List<Kiosk> kioList = service.coffeeMenu();
			List<Kiosk> addList = new ArrayList<>();
			if(kioList.isEmpty()) System.out.println("커피 메뉴 없음");
			
			else {
				do {
					for(Kiosk k : kioList) {
						System.out.printf("%d |  %-1s   %d원\n", k.getCoffeeNo(), k.getMenuName(), k.getMenuPrice());
						}
					
					System.out.println("0 | 커피 메뉴 취소");


					same(kioList);
					
					
					
				} while(choice != 0); System.out.println("\n취소하셨습니다.");
			}
		} catch (Exception e) {
			System.out.println("!! 커피 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
	}
			
	
	private void same(List<Kiosk> kioList) {
		List<Kiosk> addList = new ArrayList<>();
		int choice=-1;
		int sum = 0;
		int inputNo = -1;
		
		try {
			System.out.print("\n커피 메뉴 선택 : ");
			choice = sc.nextInt();
			sc.nextLine();
			for(Kiosk k : kioList) {
				
				if(choice != 0) {
					System.out.printf("%d. %s\n", choice, kioList.get(choice-1));
					System.out.println();
					
					sum += kioList.get(choice-1).getMenuPrice();
					addList.add(kioList.get(choice-1));
					
					System.out.println("1. 결제");
					System.out.println("2. 메뉴 추가");
					System.out.println("0. 취소");
					System.out.print("메뉴 입력 : ");	
					inputNo = sc.nextInt();
					sc.nextLine(); System.out.println();
					
					switch(inputNo) {
					case 1 : System.out.printf("%s \n총 %d 입니다.\n",addList, sum); choice = 0; break;
					case 2 : break;
					case 0 : System.out.println("첫 화면으로 돌아갑니다."); break;
					default : System.out.println("메뉴의 번호만 입력해주세요.");
					}
					
					break;
				}
			}
			if(inputNo == 1 || inputNo == 0) return;
		} catch (Exception e) {
			System.out.println("same의 오류");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	private void selectNocoffee() {
		System.out.println("\n<논커피 메뉴>\n");
		int choice=0;
		int input = -1;
		int inputNo = -1;
		int sum=0;

		try {
			List<Kiosk> kioList = service.nocoffeeMenu();
			List<Kiosk> addList = new ArrayList<>();
			if(kioList.isEmpty()) System.out.println("논커피 메뉴 없음");
			
			else {
				do {
					for(Kiosk k : kioList) {
						System.out.printf("%d |  %-1s   %d원\n", k.getNocoffeeNo(), k.getMenuName(), k.getMenuPrice());
					}
					System.out.println("0 | 논커피 메뉴 취소");
					System.out.print("\n논커피 메뉴 선택 : ");
					choice = sc.nextInt();
					sc.nextLine();
					for(Kiosk k : kioList) {
						if(choice != 0) {
							System.out.printf("%d. %s\n", choice, kioList.get(choice-1));
							System.out.println();
							
							sum += kioList.get(choice-1).getMenuPrice();
							addList.add(kioList.get(choice-1));
							
							System.out.println("1. 결제");
							System.out.println("2. 메뉴 추가");
							System.out.println("0. 취소");
							System.out.print("\n메뉴 입력 : \n");	
							inputNo = sc.nextInt();
							sc.nextLine(); System.out.println();
							
							switch(inputNo) {
							case 1 : System.out.printf("%s \n총 %d 입니다.\n",addList, sum); choice = 0; break;
							case 2 : break;
							case 3 : System.out.println("첫 화면으로 돌아갑니다."); break;
							default : System.out.println("메뉴의 번호만 입력해주세요.");
							}
							break;
						}
					}
					
					if(inputNo == 1 || inputNo == 0) return;
					
				} while(choice != 0); System.out.println("\n취소하셨습니다.");
				
				
			}
		} catch (Exception e) {
			System.out.println("!! 논커피 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
		
	}
	
	private void selectDesert() {
		System.out.println("\n<디저트 메뉴>\n");
		int choice=0;
		int sum=0;
		int input = -1;
		int inputNo=-1;
		try {
			List<Kiosk> kioList = service.desertMenu();
			List<Kiosk> addList = new ArrayList<>();
			if(kioList.isEmpty()) System.out.println("디저트 메뉴 없음");
			
			else {
				do {
					for(Kiosk k : kioList) {
						System.out.printf("%d |  %-1s   %d원\n", k.getDesertNo(), k.getMenuName(), k.getMenuPrice());
						}
					System.out.println("0 | 디저트 메뉴 취소");
					System.out.print("\n디저트 메뉴 선택 : ");
					choice = sc.nextInt();
					sc.nextLine();
					for(Kiosk k : kioList) {

						if(choice != 0) {
							System.out.printf("%d. %s\n", choice, kioList.get(choice-1));
							System.out.println();
							
							sum += kioList.get(choice-1).getMenuPrice();
							addList.add(kioList.get(choice-1));
							
							System.out.println("1. 결제");
							System.out.println("2. 메뉴 추가");
							System.out.println("0. 취소");
							System.out.print("메뉴 입력 : ");	
							inputNo = sc.nextInt();
							sc.nextLine(); System.out.println();
							
							switch(inputNo) {
							case 1 : System.out.printf("%s \n총 %d 입니다.\n", addList, sum); choice = 0; break;
							case 2 : break;
							case 3 : System.out.println("첫 화면으로 돌아갑니다."); break;
							default : System.out.println("메뉴의 번호만 입력해주세요.");
							}

							break;
						}
					}
					
					if(inputNo == 1 || inputNo == 0) return;
					
				} while(choice != 0); System.out.println("\n취소하셨습니다.");
				
				
			}
		} catch (Exception e) {
			System.out.println("!! 디저트 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
	}
					
	
	private void selectEct() {
		System.out.println("\n<기타 메뉴>\n");
		int choice=0;
		int sum=0;
		int input = -1;
		int inputNo=-1;
		try {
			List<Kiosk> kioList = service.ectMenu();
			List<Kiosk> addList = new ArrayList<>();
			if(kioList.isEmpty()) System.out.println("기타 메뉴 없음");
			
			else {
				do {
					for(Kiosk k : kioList) {
						System.out.printf("%d |  %-1s   %d원\n", k.getEctNo(), k.getMenuName(), k.getMenuPrice());
						}
					System.out.println("0 | 기타 메뉴 취소");
					System.out.print("\n기타 메뉴 선택 : ");
					choice = sc.nextInt();
					sc.nextLine();
					for(Kiosk k : kioList) {

						if(choice != 0) {
							System.out.printf("%d. %s\n", choice, kioList.get(choice-1));
							System.out.println();
							
							sum += kioList.get(choice-1).getMenuPrice();
							addList.add(kioList.get(choice-1));
							
							System.out.println("1. 결제");
							System.out.println("2. 메뉴 추가");
							System.out.println("0. 취소");
							System.out.print("메뉴 입력 : ");	
							inputNo = sc.nextInt(); 
							sc.nextLine();System.out.println();
							
							switch(inputNo) {
							case 1 : System.out.printf("%s \n총 %d 입니다.\n",addList,sum); choice = 0; break;
							case 2 : break;
							case 3 : System.out.println("첫 화면으로 돌아갑니다."); break;
							default : System.out.println("메뉴의 번호만 입력해주세요.");
							}

							break;
						}
					}
					
					if(inputNo == 1 || inputNo == 0) return;
					
				} while(choice != 0); System.out.println("\n취소하셨습니다.");
				
				
			}
		} catch (Exception e) {
			System.out.println("!! 기타 메뉴 조회 중 오류 발생 !!");
			e.printStackTrace();
		}
	}
					
	
	/**
	 * 랜덤 메뉴 추천
	 */
	private void selectRandom() {
		System.out.println("\n<<랜덤 메뉴 추천>>\n");
		
		try {
			List<Kiosk> kioList = service.allMenu();
			
			int ran = (int)(Math.random()*kioList.size());
			
			System.out.println(kioList.get(ran));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	private void managerMenu() {
		System.out.println("\n<<관리자 메뉴>>\n");
		
		System.out.print("아이디 : ");
		String id = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		int input = -1;
		try {
			if(id.equals("id12") && pw.equals("pw12")) {
				
				do {
				
					System.out.println("\n<<관리자 메뉴에 접속하셨습니다.>>\n");
					
					System.out.println("1. 메뉴 추가");
					System.out.println("2. 메뉴 수정");
					System.out.println("3. 메뉴 삭제");
					System.out.println("0. 로그아웃");
					
					System.out.print("번호 입력 : ");
					input = sc.nextInt();
					sc.nextLine();
					
					switch(input) {
					case 1 : insertMenu(); break;
					case 2 : updateMenu(); break;
					case 3 : deleteMenu(); break;
					case 0 : System.out.println("관리자 메뉴에서 나갑니다."); break;
					default : System.out.println("\n메뉴의 번호만 입력해주세요.\n");
					} 
				
			} while(input != 0);
				
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
					
					if(result > 0) System.out.println("\n메뉴가 추가 되었습니다.");
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
				
				System.out.print("\n수정할 항목 입력 : ");	
				input = sc.nextInt();
				sc.nextLine();
				System.out.println();
				
				
				switch(input) {
				case 1 : case 2 : case 3 : case 4 : updatePrint(input); break;
				case 0 : System.out.println("\n수정을 취소합니다"); break;
				default : System.out.println("\n잘못 입력하셨습니다.");
				}
				
			}while(input != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	
	private void updatePrint(int input) {
		try {
			
			if(input == 1) coffeePrint();
			else if(input == 2) nocoffeePrint();
			else if(input == 3) desertPrint();
			else ectPrint();
			
			System.out.print("\n수정할 메뉴 번호 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			System.out.print("수정할 메뉴 이름 : ");
			String updateName = sc.nextLine();
			
			
			System.out.print("\n수정할 메뉴 금액 : ");
			int updatePrice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			Kiosk kio = new Kiosk();
			if(input == 1) kio.setCoffeeNo(choice);
			else if(input == 2) kio.setNocoffeeNo(choice);
			else if(input == 3) kio.setDesertNo(choice);
			else kio.setEctNo(choice);
			kio.setMenuName(updateName);
			kio.setMenuPrice(updatePrice);
		
			int result = service.updateMenu(input, kio);
			
			if(result > 0) System.out.println("메뉴가 수정 되었습니다.\n");
			else 			System.out.println("메뉴 수정에 실패했습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void coffeePrint() {
		try {
			List<Kiosk> kioList = service.coffeeMenu();
			
			if(kioList.isEmpty()) System.out.println("커피 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getCoffeeNo(), k.getMenuName(), k.getMenuPrice());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void nocoffeePrint() {
		try {
			List<Kiosk> kioList = service.nocoffeeMenu();
			
			if(kioList.isEmpty()) System.out.println("논커피 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getNocoffeeNo(), k.getMenuName(), k.getMenuPrice());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void desertPrint() {
		try {
			List<Kiosk> kioList = service.desertMenu();
			
			if(kioList.isEmpty()) System.out.println("디저트 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getDesertNo(), k.getMenuName(), k.getMenuPrice());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ectPrint() {
		try {
			List<Kiosk> kioList = service.ectMenu();
			
			if(kioList.isEmpty()) System.out.println("기타 메뉴 없음");
			
			else {
				for(Kiosk k : kioList) {
					System.out.printf("%d |  %-1s   %d원\n", k.getEctNo(), k.getMenuName(), k.getMenuPrice());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 관리자 메뉴 삭제
	 */
	private void deleteMenu() {
try {
			
			System.out.println("\n<<관리자 메뉴 삭제>>\n");
			int input = -1;
			
			do {
				System.out.println("1. 커피 삭제");
				System.out.println("2. 논커피 삭제");
				System.out.println("3. 디저트 삭제");
				System.out.println("4. 기타 삭제");
				System.out.println("0. 취소");
				
				System.out.print("\n삭제할 항목 입력 : ");	
				input = sc.nextInt();
				sc.nextLine();
				
				
				switch(input) {
				case 1 :deletePrint(input); break;
				case 2 : deletePrint(input); break;
				case 3 : deletePrint(input); break;
				case 4 : deletePrint(input); break;
				case 0 : System.out.println("\n삭제를 취소합니다\n"); break;
				default : System.out.println("\n잘못 입력하셨습니다.");
				}
				
			}while(input != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deletePrint(int input) {
		try {
			
			if(input == 1) coffeePrint();
			else if(input == 2) nocoffeePrint();
			else if(input == 3) desertPrint();
			else ectPrint();
			
			System.out.print("\n삭제할 메뉴 번호 : \n");
			int choice = sc.nextInt();
			sc.nextLine();

			
			Kiosk kio = new Kiosk();
			if(input == 1) kio.setCoffeeNo(choice);
			else if(input == 2) kio.setNocoffeeNo(choice);
			else if(input == 3) kio.setDesertNo(choice);
			else kio.setEctNo(choice);

		
			int result = service.deleteMenu(input, kio);
			
			if(result > 0) System.out.println("메뉴가 삭제 되었습니다.\n");
			else 			System.out.println("메뉴 삭제에 실패했습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
