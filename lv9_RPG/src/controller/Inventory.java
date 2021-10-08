package controller;

import java.util.ArrayList;

import models.Item;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<Item>();

	public void addInventory(Item item) {
		this.items.add(item);
	}

	public ArrayList<Item> printInventory() {
		int idx = 1;

		ArrayList<Item> temp = new ArrayList<Item>();
		for (Item item : this.items) {
			if (!item.getUse()) {
				item.printItem(idx);
				idx++;
				temp.add(item);
			}
		}
		return temp;
	}

	public void putOnItem() {
		ArrayList<Item> notUse = this.printInventory();
		System.out.print("착용할 아이템 번호_");
		String input = Player.scan.next();
		try {
			int sel = Integer.parseInt(input) - 1;
			if (sel >= 0 && sel < notUse.size()) {
				Player.guild.printAllGuildWithInventory();
				System.out.print("아이템 착용할 길드원의 번호_");
				int selUnit = Player.scan.nextInt() - 1;
				if (selUnit >= 0 && selUnit < Player.guild.getUnitSize()) {
					Player.guild.getUnit(selUnit).getItem(notUse.get(sel));
					notUse.get(sel).setUse(true);
					System.out.println(notUse.get(sel).getName() + " 착용 완료!!");
					Player.guild.getUnit(selUnit).setAlpha();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void takeOffItem() {
		Player.guild.printAllGuildWithInventory();
		System.out.print("아이템 해제할 길드원의 번호_");
		int selUnit = Player.scan.nextInt() - 1;
		if (selUnit >= 0 && selUnit < Player.guild.getUnitSize()) {
			System.out.println("- 해제할 아이템 -");
			System.out.println("[1] 무기");
			System.out.println("[2] 갑옷");
			System.out.println("[3] 반지");
			System.out.println("-------------");
			System.out.println("[0] 뒤로가기");
			System.out.println("-------------");
			System.out.print(": ");
			String input = Player.scan.next();
			try {
				int sel = Integer.parseInt(input);
				Player.guild.getUnit(selUnit).delItem(sel);
				Player.guild.getUnit(selUnit).setAlpha();
			} catch (Exception e) {
			}
		}
	}

	public void selItem() {
		ArrayList<Item> notUse = this.printInventory();
		System.out.print("판매할 아이템 번호_");
		String input = Player.scan.next();
		try {
			int sel = Integer.parseInt(input) - 1;
			if (sel >= 0 && sel < notUse.size()) {
				Item selItem = notUse.get(sel);
				double price = selItem.getPrice();
				System.out.print("[원가]" + price + "원⮕[판매가]" + price * (0.7) + "원에 판매됩니다. 판매하시겠습니까?\n");
				System.out.print("[1]Yes [2]No: ");
				int sel2 = Player.scan.nextInt();
				if (sel2 == 1) {
					int delIdx = 0;
					for (Item item : this.items) {
						if (item.equals(selItem))
							break;
						delIdx++;
					}
					Player.money += price * (0.7);
					this.items.remove(delIdx);
					System.out.printf("판매완료! [Money:%d원]\n", Player.money);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
