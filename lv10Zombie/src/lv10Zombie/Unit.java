package lv10Zombie;

public class Unit {
	private String name;
	private int hp;
	private int attack;
	private int defense;
	private int location;
	
	public Unit(String name, int hp, int attack, int defense, int location) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.location = location;
	}
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return this.attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getLocation() {
		return this.location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
}
