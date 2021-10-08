import java.util.Random;
import java.util.Scanner;

import controller.FileData;
import controller.Player;
import controller.Shop;

class MainGame {
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();

//	public MainGame() {
//	}
	public void run() {
		Player player = new Player();
		Shop shop = new Shop();
		FileData fileData = new FileData();
		while (true) {
			System.out.println("==== [HOME] ====");
			System.out.println("[1]길드 관리");
			System.out.println("[2]상점");
			System.out.println("[3]인벤토리");
			System.out.println("----------------");
			System.out.println("[4]저장");
			System.out.println("[5]로드");
			System.out.println("[0]종료");
			System.out.println("================");
			System.out.print("메뉴를 입력하세요_ ");
			String input = scan.next();
			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					player.guildMenu();
				} else if (sel == 2) {
					shop.shopMenu();
				} else if (sel == 3) {
					player.inventoryMenu();
				} else if (sel == 4) {
					fileData.save();
				} else if (sel == 5) {
					
				} else if (sel == 0) {
					System.out.println("[게임 종료]");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class Main {

	public static void main(String[] args) {
		MainGame mg = new MainGame();
		mg.run();
	}

}
