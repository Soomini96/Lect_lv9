package controller;

public abstract class Monster {
	private String name;
	private int hp;
	private int maxHp;
	private int power;
	
	public Monster(String name, int hp, int power) {
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.power = power;
	}
	public abstract void attack(Player player);
	public abstract void skill(Player player);
	
	public void printPlayer() {
		System.out.printf("[%s] [%d/%d] [%d]\n",this.name, this.hp, this.maxHp, this.power);
	}
	
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getName() {
		return this.name;
	}
	public int getPower() {
		return this.power;
	}
}
