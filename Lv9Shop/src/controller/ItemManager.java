package controller;

import java.util.ArrayList;

import models.Cart;
import models.Item;
import models.Shop;
import models.User;

public class ItemManager {
	public static ItemManager instance = new ItemManager();

	private UserManager um = UserManager.instance;
	private ArrayList<String> categorys = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Cart> carts = new ArrayList<>();

	public ItemManager() {
		this.categorys.add("과일/채소");
		this.categorys.add("정육/계란");
		this.categorys.add("수산/건어물");
		this.categorys.add("음료/생수/커피");

		Item newItem = new Item(this.categorys.get(0), "포도", 2000);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(0), "사과", 1500);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(1), "소고기", 7000);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(1), "돼지고기", 5000);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(1), "계란", 4500);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(2), "고등어", 3000);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(2), "갈치", 5000);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(3), "생수", 3500);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(3), "커피", 2000);
		this.items.add(newItem);
		newItem = new Item(this.categorys.get(3), "포카리스웨트", 2000);
		this.items.add(newItem);
	}

	public void shopping(String log) {
		if (this.categorys.size() > 0) {
			System.out.println("------------------------");
			int idx = 0;
			for (String cat : this.categorys) {
				System.out.printf("[%d]%s\n", idx, cat);
				idx++;
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
					if (item.getCategory().equals(this.categorys.get(selCategory))) {
						
						item.printItem(idx);
						idx++;
						
						temp.add(item);
					}
				}
				System.out.println("------------------------");

				if (idx != 0) {
					System.out.print("Item Index: ");
					int selItem = Shop.sc.nextInt();
					if (selItem >= 0 && selItem < temp.size()) {
						Cart newCart = new Cart(temp.get(selItem), log);
						// 카트 리스트에 저장
						this.carts.add(newCart);

						// 유저 -> 카트 리스트에도 저장!
						this.um.getUser(log).addCart(newCart);
						System.out.println("[" + temp.get(selItem).getItemName() + "(을)를 담았습니다.]");

					}
				} else {
					System.out.println("[Empty Data]");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("[Empty Data]");
		}
	}

	public void deleteJang(String log) {
		int size = this.um.getUser(log).getCartSize();
		if (size > 0) {
			System.out.print("삭제할 장바구니 Number: ");
			String input = Shop.sc.next();
			try {
				int sel = Integer.parseInt(input);

				if (sel >= 0 && sel < size) {
					Cart delCart = this.um.getUser(log).getCart().get(sel);

					int delIdx = 0;
					for (Cart cart : this.carts) {
						if (cart.equals(delCart)) {
							break;
						}
						delIdx ++;
					}
					this.carts.remove(delIdx);
					this.um.getUser(log).delCart(delCart);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("[Empty Data]");
		}
	}

	public void payJang(String log) {
		int size = this.um.getUser(log).getCartSize();
		if (size > 0) {
			System.out.println("결제하시겠습니까?");
			System.out.print("[1]Yes [2]No: ");
			String input = Shop.sc.next();
			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					System.out.print("카드 번호 입력: ");
					int CardNum = Shop.sc.nextInt();
					System.out.println("[결제 완료]");

					while(true) {
						int delIdx = 0;
						for (Cart cart : this.carts) {
							if (cart.getId().equals(log)) {
								break;
							}
							delIdx ++;
						}
						if(delIdx == this.carts.size()) {
							break;
						}
						this.carts.remove(delIdx);
					}

					this.um.getUser(log).allRemoveJang();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			System.out.println("[Empty Data]");
		}
	}

	public void showAllItem() {
		int n = 0;
		for (Item item : this.items) {
			item.printItem(n);
			n++;
		}
	}

	public void showAllCategory() {
		int n = 0;
		for (String cat : this.categorys) {
			System.out.printf("[%d]%s\n", n, cat);
			n++;
		}
	}

	public void addItem() {
		System.out.print("아이템 이름: ");
		String name = Shop.sc.next();
		System.out.print("아이템 가격: ");
		int price = Shop.sc.nextInt();
		showAllCategory();
		System.out.print("카테고리 index: ");
		int idx = Shop.sc.nextInt();
		Item newItem = new Item(this.categorys.get(idx), name, price);
		this.items.add(newItem);
	}

	public void delItem() {
		try {
			System.out.print("삭제할 아이템 index: ");
			int idx = Shop.sc.nextInt();
			this.items.remove(idx);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addCategory() {
		System.out.print("추가할 카테고리: ");
		String category = Shop.sc.next();
		this.categorys.add(category);
	}

	public void delCategory() {
		try {
			System.out.print("삭제할 카테고리 index: ");
			int idx = Shop.sc.nextInt();
			this.categorys.remove(idx);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void showAllJang() {
		int n = 0;
		for (Cart cart : this.carts) {
			cart.printCart(n);
			n++;
		}
	}

	public void delJang() {
		try {
			System.out.print("삭제할 장바구니 index: ");
			int idx = Shop.sc.nextInt();

			Cart delCart = this.carts.get(idx);
			String log = delCart.getId();

			this.carts.remove(idx);
			this.um.delCart(log, delCart);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void delUserCart(String log) {
		int delIdx = 0;
		for (Cart c : this.carts) {
			if (c.getId().equals(log)) {
				break;
			}
			delIdx++;
		}
		this.carts.remove(delIdx);
	}
}
