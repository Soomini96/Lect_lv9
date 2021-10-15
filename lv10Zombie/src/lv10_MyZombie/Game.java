package lv10_MyZombie;

// 상속O,추상화O,인터페이스O,마크인터페이스

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
interface GameTool{
	void firstSetting();
	void run();
	int printMenu();
}
//interface ZombieCheck {
//}
public class Game implements GameTool {
	private static Game instance = new Game();

	private Game() {
	}

	public static Game getInstance() {
		return Game.instance;
	}

	public static Scanner sc = new Scanner(System.in);
	public static Random rn = new Random();

	private Hero player;
	private ArrayList<Unit> zombies = new ArrayList<>();
	
	public void firstSetting() {
		this.player = new Hero("플레이어", 100, 5, 2, 1);
		this.zombies.add(new Zombie("일반 좀비", 30, 5, 1, 3));
		this.zombies.add(new Zombie("쎈 좀비", 55, 15, 1, 6));
		this.zombies.add(new Zombie("체력 좋은 좀비", 100, 20, 3, 9));
		this.zombies.add(new ZombieKing("좀비왕", 120, 25, 5, 12));
	}

	public void run() {
		this.firstSetting();

		while (true) {
			int stair = printMenu();

			Unit fightZombie = null;

			for (Unit zombie : this.zombies) {
				if (zombie.getLocation() == stair) {
					fightZombie = zombie;
				}
			}

			if (fightZombie != null) {
				battle(fightZombie);
			} else {
				System.out.println("아무 일도 일어나지 않았다...");
			}

			if (this.player.getHp() <= 0) {
				break;
			}
			if (stair == 12) {
				System.out.println("✙⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼✙");
				System.out.println("⎸ 당신은 살았습니다  ⎸");
				System.out.println("⎸ 생존을 축하합니다  ⎸");
				System.out.println("✙⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼⎼✙");
				break;
			}
		}
	}

	public int printMenu() {
		for (int i = 0; i < 2; i++) {
			this.heroInfo();
			System.out.printf("[ 현재 층 : %d ]\n", this.player.getLocation());
			System.out.println("[1] 올라간다");
			if (i == 0) {
				System.out.println("[2] 체력을 회복!");
				System.out.println("[3] 무기를 강화!");
			}
			String input = Game.sc.next();
			try {
				int go = Integer.parseInt(input);
				if (go == 1) {
					this.player.setLocation(this.player.getLocation() + 1);
					break;
				}
				if (i == 0) {
					if (go == 2) {
						int heal = Game.rn.nextInt(30) + 20;
						this.player.setHp(this.player.getHp() + heal);
						System.out.printf("체력을 %d만큼 회복했다!\n", heal);
					} else if (go == 3) {
						int rnChoice = Game.rn.nextInt(5);
						int up = Game.rn.nextInt(3) + 2; // 2~5
						if (rnChoice == 0) { // 0
							this.player.setDefense(this.player.getDefense() + up);
							System.out.printf("방어력이 %d만큼 증가했다!\n", up);
						} else { // 1~4
							this.player.setAttack(this.player.getAttack() + up);
							System.out.printf("공격력이 %d만큼 증가했다!\n", up);
						}
					}
				} else {
					i--;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return this.player.getLocation();
	}

	private void heroInfo() {
		System.out.println("------------------------");
		System.out.printf("[이름: %s] [체력: %d]\n", this.player.getName(), this.player.getHp());
		System.out.printf("[공격력: %d] [방어력: %d]\n", this.player.getAttack(), this.player.getDefense());
		System.out.println("------------------------");
	}

	private void battle(Unit zombie) {
		System.out.printf("%s가 나타났다!!\n", zombie.getName());
		while (true) {
			System.out.println("---------- VS ----------");
			System.out.printf("[이름: %s] [체력: %d]\n", zombie.getName(), zombie.getHp());
			System.out.printf("[공격력: %d] [방어력: %d]\n", zombie.getAttack(), zombie.getDefense());
			this.heroInfo();
			System.out.printf("[1. 공격] [2. 물약(%d개)]\n", this.player.getHealPotion());
			String input = Game.sc.next();
			try {
				int go = Integer.parseInt(input);
				if (go == 1) {
					this.player.fight(zombie);
					System.out.println();
					zombie.fight(player);
				} else if (go == 2) {
					this.player.drinking();
					zombie.fight(player);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			// 누가 죽었는지 확인
			if (this.player.getHp() <= 0 || zombie.getHp() <= 0) {
				System.out.println();
				System.out.println("===Battle Over!===");
				if (this.player.getHp() <= 0) {
					System.out.println("You die...");
				} else {
					System.out.printf("%s die...\n", zombie.getName());
				}
				break;
			}
		}
	}
}
