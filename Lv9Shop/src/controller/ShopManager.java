package controller;

import models.Shop;

public class ShopManager {
	
	private UserManager um = UserManager.instance;
	private ItemManager it = ItemManager.instance;
	String shopName;
	
	public ShopManager(String name) {
		this.shopName = name;
	}
	
	public void run() {
		boolean isRun = true;
		while(isRun) {
			if(Shop.log.equals(null)) {
				isRun = userMenu();
			}else {
				shoppingMenu(Shop.log);
			}
		}
	}
	
	public boolean userMenu() {
		System.out.println("------------");
		System.out.println("[1]로그인");
		System.out.println("[2]회원가입");
		System.out.println("------------");
		System.out.println("[0]종료");
		System.out.println("[100]관리자");
		System.out.println("------------");
		System.out.print(": ");
		String input = Shop.sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			if(sel == 1) {
				this.um.logIn();
			}else if(sel == 2) {
				this.um.signIn();
			}else if(sel == 100) {
				boolean isRun = true;
				while(isRun) {
					isRun = managerMode();
				}
			
			}else if(sel == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean managerMode() {
//		System.out.println("------------");
//		System.out.println("[1]로그인");
//		System.out.println("[2]회원가입");
//		System.out.println("------------");
//		System.out.println("[0]종료");
//		System.out.println("[100]관리자");
//		System.out.println("------------");
//		System.out.print(": ");
//		String input = Shop.sc.next();
//		
//		try {
//			int sel = Integer.parseInt(input);
//			if(sel == 1) {
//				this.um.logIn();
//			}else if(sel == 2) {
//				this.um.signIn();
//			}else if(sel == 100) {
//				boolean isRun = true;
//				while(isRun) {
//					isRun = managerMode();
//				}
//				
//			}else if(sel == 0) {
//				return false;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
		return true;
	}
	
	public void shoppingMenu(String log) {
		System.out.println("------------");
		System.out.println(Shop.log + " is log in _");
		System.out.println("------------");
		System.out.println("[1]쇼핑하기");
		System.out.println("[2]장바구니");
		System.out.println("------------");
		System.out.println("[0]로그아웃");
		System.out.println("------------");
		System.out.print(": ");
		String input = Shop.sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			if(sel == 1) {
				this.it.shopping(log); // 카테고리 보여줌 -> 고르기
			}else if(sel == 2) {
				this.um.signIn(); // 
			}else if(sel == 0) {
				Shop.log = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
