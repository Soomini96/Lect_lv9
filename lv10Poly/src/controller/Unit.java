package controller;

public abstract class Unit {
	int hp;
	int maxHp;
	int power;
	String name;
	String state = "노말";
	private boolean frozen = false;
	
	public Unit() {}
	public Unit(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
	}
	public void init(int max, int power) {
		this.maxHp = max;
		this.hp = max;
		this.power = power;
	}
	void printData() {
		System.out.printf("[%s] [%d/%d] [%d]\n",this.name, this.hp, this.maxHp, this.power);
	}
	void attack(Unit target) {
		target.hp -= this.power;
		System.out.printf("[%s]이 [%s]에게 [%d]만큼의 데미지를 입힙니다.\n", this.name, target.name, this.power);
		if(target.hp<=0) {
			System.out.printf("[%s]을 처치했습니다.\n",target.name);
			target.hp = 0;
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public boolean getFrozen() {
		return this.frozen;
	}
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
	
	public abstract void skill(Unit target);
}
