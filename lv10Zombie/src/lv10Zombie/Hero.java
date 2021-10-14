package lv10Zombie;

public class Hero extends Unit {
	private int healPotion = 3;
	private final int heal = 100;

	public Hero(String name, int hp, int attack, int defense, int location) {
		super(name, hp, attack, defense, location);
	}

	public int getHealPotion() {
		return this.healPotion;
	}

	public void setHealPotion(int num) {
		this.healPotion = num;
	}

	public void drinking() {
		if (this.healPotion > 0) {
			System.out.println("회복약을 마십니다.");
			System.out.printf("체력이 %d 회복되었습니다.\n", heal);
			super.setHp(super.getHp() + this.heal);
			this.healPotion--;
		} else {
			System.out.println("포션이 없습니다 ㅠㅠ");
		}
	}
}
