package models;

public class Item {
	static final int WEAPON = 1;
	static final int ARMOR = 2;
	static final int RING = 3;
	private int kind;
	private String name;
	private int attack;
	private int price;
	
	public Item(String name, int kind, int attack, int price) {
		this.name = name;
		this.kind = kind;
		this.attack = attack;
		this.price = price;
	}
}
