package edu.kh.project.main.model.vo;

import java.util.List;

public class Kiosk {


	private int coffeeNo;
	private int nocoffeeNo;
	private int desertNo;
	private int ectNo;
	private String menuName;
	private int menuPrice;
	private String menuType;

	private List<Kiosk> addKioList;
	
	

	public Kiosk() { }



	
	
	public List<Kiosk> getAddKioList() {
		return addKioList;
	}
	
	public void setAddKioList(List<Kiosk> addKioList) {
		this.addKioList = addKioList;
	}
	
	

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}


	public int getCoffeeNo() {
		return coffeeNo;
	}

	public void setCoffeeNo(int coffeeNo) {
		this.coffeeNo = coffeeNo;
	}

	public int getNocoffeeNo() {
		return nocoffeeNo;
	}

	public void setNocoffeeNo(int nocoffeeNo) {
		this.nocoffeeNo = nocoffeeNo;
	}

	public int getDesertNo() {
		return desertNo;
	}

	public void setDesertNo(int desertNo) {
		this.desertNo = desertNo;
	}

	public int getEctNo() {
		return ectNo;
	}

	public void setEctNo(int ectNo) {
		this.ectNo = ectNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	@Override
	public String toString() {
		return menuName + " " + menuPrice + "원";
	}

	
	


}
