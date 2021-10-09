package models;

public class Item {
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	private int kind;
	private String name;
	private int attack;
	private int defense;
	private int price;
	private boolean use = false;

	public Item(String name, int kind, int attack, int defense, int price) {
		this.name = name;
		this.kind = kind;
		this.attack = attack;
		this.defense = defense;
		this.price = price;
	}
	public int getKind() {
		return this.kind;
	}

	public void printItem(int num) {
		System.out.printf("[%d번 %s][공격/방어력:%d/%d][가격:%d]\n", num, this.name, this.attack, this.defense, this.price);
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public boolean getUse() {
		return this.use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	public int getAttack() {
		return this.attack;
	}

	public int getDefense() {
		return this.defense;
	}
}
