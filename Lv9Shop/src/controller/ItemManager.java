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
				this.um.getUser(log).getCart().add(newCart);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteJang(String log) {
		System.out.print("삭제할 장바구니 Number: ");
		String input = Shop.sc.next();
		try {
			int sel = Integer.parseInt(input);
			
			int size = this.um.getUser(log).getCartSize();
			
			if(sel>=0 && sel<size) {
				Cart delCart = this.um.getUser(log).getCart().get(sel);
				
				for(Cart cart : this.carts) {
					if(cart.equals(delCart)) {
						this.carts.remove(cart);
					}
				}
				this.um.getUser(log).delCart(delCart);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void payJang(String log) {
		System.out.print("결제하시겠습니까? [1]Yes [2]No: ");
		String input = Shop.sc.next();
		try {
			int sel = Integer.parseInt(input);
			if(sel == 1) {
				System.out.print("카드 번호 입력: ");
				int CardNum = Shop.sc.nextInt();
				System.out.println("[결제 완료]");
				
				for(Cart cart : this.carts) {
					if(cart.getId().equals(log)) {
						this.carts.remove(cart);
					}
				}
				
				this.um.getUser(log).allRemoveJang();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
