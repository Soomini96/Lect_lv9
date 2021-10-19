package controller;

public class Player extends Unit {
	private String name;
	private int power;
	
	
	public Player(String name, int maxHp, int power) {
		super(name, maxHp, power);
		this.name = name;
		this.power = power;
	}
	
	@Override
	public void skill(Unit target) {
		if(this.name.equals("검사")) {
			System.out.println("[바람의 검]스킬 발동!");
		}else if(this.name.equals("마법사")) {
			System.out.println("[파이어 볼]스킬 발동!");
		}else if(this.name.equals("궁수")) {
			System.out.println("[독수리의 눈]스킬 발동!");
		}
		target.hp -= this.power * 2;
		System.out.printf("[%s]이 [%s]에게 [%d]만큼의 데미지를 입힙니다.\n", this.name, target.name, this.power);
		if(target.hp<=0) {
			System.out.printf("[%s]을 처치했습니다.\n",target.name);
			target.hp = 0;
		}
	}
	public String getName() {
		return this.name;
	}
	
}
