package controller;

import java.util.ArrayList;

import models.Item;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public void addInventory(Item item) {
		this.items.add(item);
	}
	public ArrayList<Item> printInventory() {
//		for(int i=0; i<this.items.size(); i++) {
//			this.items.get(i).printItem(i+1);
//		}
		int idx = 1;
		
		Player.guild.printAllGuildWithInventory();
		ArrayList<Item> temp = new ArrayList<Item>();
		for(Item item : this.items) {
			if(!item.getUse()) {
				item.printItem(idx);
				idx ++;
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
			int sel = Integer.parseInt(input)-1;
			if(sel>=0 && sel<notUse.size()) {
				Player.guild.printAllGuildWithInventory();
				System.out.print("아이템 착용할 길드원의 번호_");
				int selUnit = Player.scan.nextInt()-1;
				if(selUnit>=0 && selUnit<Player.guild.getUnitSize()) {
					Player.guild.getUnit(selUnit).getItem(notUse.get(sel));
					notUse.get(sel).setUse(true);
					System.out.println(notUse.get(sel).getName() + "!!!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void takeOffItem() {
		Player.guild.printAllGuildWithInventory();
		System.out.print("아이템 해제할 길드원의 번호_");
		int selUnit = Player.scan.nextInt()-1;
		if(selUnit>=0 && selUnit<Player.guild.getUnitSize()) {
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
			} catch (Exception e) {
			}
		}
	}
}
