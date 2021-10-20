package controller;

public abstract class Player {
	
	private String name;
	private int hp;
	private int maxHp;
	private int power;
	private int stop = 0;
	private int skillGauge = 0;
	
	public Player(String name, int hp, int power) {
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.power = power;
	}
	public abstract void attack(Monster monster);
	public abstract void skill(Monster monster);
}
