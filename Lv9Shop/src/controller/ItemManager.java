package controller;

import java.util.ArrayList;

import models.Cart;
import models.Item;
import models.Shop;

public class ItemManager {
	public static ItemManager instance = new ItemManager();
	
	private UserManager um = UserManager.instance;
	private ArrayList<String> categorys = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Cart> carts = new ArrayList<>();
	
	public void shopping(String log) {
		System.out.println("------------------------");
		int idx = 0;
		for(String cat : this.categorys) {
			System.out.printf("[%d]%s\n",idx, cat);
			idx ++;
		}
		System.out.println("------------------------");
		System.out.print("카테고리 : ");
		String input = Shop.sc.next();
		try {
			int selCategory = Integer.parseInt(input);
			
			System.out.println("------------------------");
			ArrayList<Item> temp = new ArrayList<>();
			idx = 0;
			for (Item item : this.items) {
				if(item.getCategory().equals(this.categorys.get(selCategory))) {
					item.printItem(idx);
					temp.add(item);
					idx ++;
				}
			}
			System.out.println("------------------------");
			
			System.out.print("Item Index: ");
			int selItem = Shop.sc.nextInt();
			if(selItem>=0 && selItem<temp.size()) {
				Cart newCart = new Cart(temp.get(selItem), log);
				
				// 카트 리스트에 저장
				this.carts.add(newCart);
				
				// 유저 -> 카트 리스트에도 저장!
				this.um.getUser(log)
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
