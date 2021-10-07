package controller;

import java.util.ArrayList;

import models.Item;

public class Shop {
	private ArrayList<Item> items = new ArrayList<>();
	public Shop() {
		Item newItem = new Item("", Item., 0, 0);
		this.items.add(newItem);
	}
	public void shopMenu(){
		while(true) {
			System.out.println("==== [Shop] ====");
			System.out.println("[1]무기");
			System.out.println("[2]방어구");
			System.out.println("[3]반지");
			System.out.println("----------------");
			System.out.println("[0]뒤로가기");
			System.out.println("================");
			System.out.print("메뉴를 입력하세요_ ");
			String input = Player.scan.next();
			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
				} else if (sel == 2) {
				} else if (sel == 3) {
				} else if (sel == 0) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
