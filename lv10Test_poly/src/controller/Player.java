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
	
	public void printPlayer() {
		System.out.printf("[%s] [%d/%d] [%d]\n",this.name, this.hp, this.maxHp, this.power);
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
	public int getStop() {
		return this.stop;
	}
	public void setStop(int stop) {
		this.stop = stop;
	}
	public int getGauge() {
		return this.skillGauge;
	}
	public void setGauge(int gauge) {
		this.skillGauge = gauge;
	}
	public int getPower() {
		return this.power;
	}
}
