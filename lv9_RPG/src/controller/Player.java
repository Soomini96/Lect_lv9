package controller;

import java.util.Random;
import java.util.Scanner;

public class Player {
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();

	static int money;
	public static Guild guild = new Guild();
	public static Inventory inventory = new Inventory();

	public Player() {
		money = 100000;
	}

	public void guildMenu() {
		while (true) {
			System.out.println("==== [Guild] ====");
			System.out.println("[1]길드 목록");
			System.out.println("[2]길드원 추가");
			System.out.println("[3]길드원 삭제");
			System.out.println("[4]길드원 정렬");
			System.out.println("----------------");
			System.out.println("[5]파티원 목록");
			System.out.println("[6]파티원 교체");
			System.out.println("----------------");
			System.out.println("[0]뒤로가기");
			System.out.println("================");
			System.out.print("메뉴를 입력하세요_ ");
			String input = scan.next();
			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					guild.printAllGuild();
				} else if (sel == 2) {
					guild.addGuild();
				} else if (sel == 3) {
					guild.deleteGuild();
				} else if (sel == 4) {
					guild.sortGuild();
				} else if (sel == 5) {
					guild.printAllParty();
				} else if (sel == 6) {
					guild.changeParty();
				} else if (sel == 0) {
					break;
				}
			} catch (Exception e) {
			}
		}
	}

	public void inventoryMenu() {
		while (true) {
			System.out.println("== [Inventory] ==");
			System.out.println("[1]인벤토리 목록");
			System.out.println("[2]아이템 착용하기");
			System.out.println("[3]아이템 해제하기");
			System.out.println("[4]아이템 판매");
			System.out.println("----------------");
			System.out.println("[0]뒤로가기");
			System.out.println("================");
			System.out.print("메뉴를 입력하세요_ ");
			String input = scan.next();
			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					guild.printAllGuildWithInventory();
					inventory.printInventory();
				} else if (sel == 2) {
					inventory.putOnItem();
				} else if (sel == 3) {
					inventory.takeOffItem();
				} else if (sel == 4) {
					inventory.selItem();
				} else if (sel == 0) {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
}
