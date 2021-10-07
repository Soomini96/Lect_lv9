package models;

public class Unit {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att; // 공격력
	private int def; // 방어력
	private int exp;
	private boolean party; // 따로
	private Item weapon;
	private Item armor;
	private Item ring;
	
	public Unit(String name, int hp, int att, int def) {
		this.name = name;
		this.level = 1;
		this.hp = hp;
		this.maxHp = hp;
		this.att = att;
		this.def = def;
		this.exp = 0;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	public void turnOnParty() {
		this.party = true;
	}
	public void turnOffParty() {
		this.party = false;
	}
	public boolean getParty() {
		return this.party;
	}
	public void printUnit(int num) {
		System.out.printf("[%d번] %s | Lv.%d | HP %d/%d | 공격력 %d | 방어력 %d | 파티 %b\n",num, this.name, this.level, this.hp, this.maxHp, this.att, this.def, this.party);
	}
	public void printUnit() {
		System.out.printf("%s | Lv.%d | HP %d/%d | 공격력 %d | 방어력 %d | 파티 %b\n",this.name, this.level, this.hp, this.maxHp, this.att, this.def, this.party);
	}
}
