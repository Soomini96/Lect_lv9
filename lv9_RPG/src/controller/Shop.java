package controller;

import java.util.ArrayList;

import models.Item;

public class Shop {
	private ArrayList<Item> items = new ArrayList<>();

	public Shop() {
		Item newItem = new Item("목검", Item.WEAPON, 3, 0, 1000);
		this.items.add(newItem);
		newItem = new Item("은 검", Item.WEAPON, 5, 0, 1500);
		this.items.add(newItem);
		newItem = new Item("얼음 칼날", Item.WEAPON, 10, -1, 2500);
		this.items.add(newItem);
		newItem = new Item("마법의 검", Item.WEAPON, 20, -5, 3000);
		this.items.add(newItem);
		newItem = new Item("나무 갑옷", Item.ARMOR, 0, 3, 1000);
		this.items.add(newItem);
		newItem = new Item("칠흑나무 갑옷", Item.ARMOR, 0, 5, 1500);
		this.items.add(newItem);
		newItem = new Item("텅스텐 갑옷", Item.ARMOR, 0, 11, 2000);
		this.items.add(newItem);
		newItem = new Item("백금 갑옷", Item.ARMOR, 0, 16, 2600);
		this.items.add(newItem);
		newItem = new Item("고대의 그림자 갑옷", Item.ARMOR, 0, 19, 3300);
		this.items.add(newItem);
		newItem = new Item("금반지", Item.RING, 0, 2, 1000);
		this.items.add(newItem);
		newItem = new Item("동전반지", Item.RING, 0, 4, 1500);
		this.items.add(newItem);
		newItem = new Item("탐욕의 반지", Item.RING, 0, 7, 1700);
		this.items.add(newItem);
		newItem = new Item("발렌타인 반지", Item.RING, 0, 10, 2000);
		this.items.add(newItem);
	}

	public void shopMenu() {
		while (true) {
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
				if (sel == 0) {
					break;
				}
				while (true) {
					if (sel == Item.WEAPON) {
						System.out.println("==== [상점|무기] ====");
					} else if (sel == Item.ARMOR) {
						System.out.println("==== [상점|방어구] ====");
					} else if (sel == Item.RING) {
						System.out.println("==== [상점|반지] ====");
					}

					ArrayList<Item> temp = new ArrayList<Item>();

					int idx = 1;
					for (int i = 0; i < this.items.size(); i++) {
						if (this.items.get(i).getKind() == sel) {
							this.items.get(i).printItem(idx);
							temp.add(this.items.get(i));
							idx++;
						}
					}
					System.out.println("--------------------");
					System.out.println("Money: " + Player.money + "원");
					System.out.println("--------------------");
					System.out.println("[0번]뒤로가기");
					System.out.println("====================");
					System.out.print("번호를 골라주세요_");
					int sel2 = Player.scan.nextInt() - 1;
					if (sel2 == -1) {
						break;
					} else if (sel2 >= 0 && sel2 < temp.size()) {
						if (Player.money >= temp.get(sel2).getPrice()) {
							System.out.println("[" + temp.get(sel2).getName() + "] 구매 완료.");

							Player.money -= temp.get(sel2).getPrice();
							Player.inventory.addInventory(temp.get(sel2));
						} else {
							System.out.println("돈이 부족합니다.");
						}
					}
				}
			} catch (Exception e) {
			}
		}
	}
}
