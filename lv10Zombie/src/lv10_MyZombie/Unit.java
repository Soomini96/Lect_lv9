package lv10_MyZombie;

abstract public class Unit {
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

	public void fight(Unit target) {
		int attack = Game.rn.nextInt(3) + this.attack - 3;
		int defense = Game.rn.nextInt(target.getDefense()) + 1;
		int total = attack - defense;
		if (total < 0) {
			total = 0;
		}
		target.setHp(target.getHp() - total);
		System.out.println("<<" + this.name + "의 공격!!>>");
		System.out.println(attack + "의 데미지..!!");
		System.out.println(target.getName() + "가 " + defense + "만큼 방어함");
		System.out.printf("[%s]의 남은 체력 : %d\n", target.getName(), target.getHp());
	}
	
	abstract void birth();
}
