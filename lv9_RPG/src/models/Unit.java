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

	private int alphaAtt;
	private int alphaDef;

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
	public String getData() {
		String data = this.name + "/";
		data += this.level + "/";
		data += this.maxHp + "/";
		data += this.att + "/";
		data += this.def + "/";
		data += this.exp + "/";
		data += this.party + "\n";
		if(this.weapon != null) {
			data += this.weapon.getName() + "/";
		}else {
			data += "null/";
		}
		if(this.armor != null) {
			data += this.armor.getName() + "/";
		}else {
			data += "null/";
		}
		if(this.ring != null) {
			data += this.ring.getName();
		}else {
			data += "null";
		}
		return data;
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

	public String getName() {
		return this.name;
	}

	public int getAttack() {
		int attack = this.att;
		attack += this.alphaAtt;
		return attack;
	}

	private void unitInfoString() {
		System.out.printf("%s|Lv.%d|HP %d/%d|공격력 %d", this.name, this.level, this.hp, this.maxHp, this.att);
		if (this.alphaAtt > 0) {
			System.out.printf("(+%d)", this.alphaAtt);
		} else if (this.alphaAtt < 0) {
			System.out.printf("(%d)", this.alphaAtt);
		}
		System.out.printf("|방어력 %d", this.def);
		if (this.alphaDef > 0) {
			System.out.printf("(+%d)", this.alphaDef);
		}
		if (this.alphaDef < 0) {
			System.out.printf("(%d)", this.alphaDef);
		}
		System.out.printf("|파티 %b\n", this.party);
	}

	public void printUnit(int num) {
		System.out.printf("[%d번]", num);
		this.unitInfoString();
	}

	public void printUnitWithInventory(int num) {
		System.out.printf("[%d번]", num);
		this.unitInfoString();
		String str = "      무기:";
		if (this.weapon == null) {
			str += "NULL 방어구:";
		} else {
			str += this.weapon.getName() + " 방어구:";
		}
		if (this.armor == null) {
			str += "NULL 반지:";
		} else {
			str += this.armor.getName() + " 반지:";
		}
		if (this.ring == null) {
			str += "NULL";
		} else {
			str += this.ring.getName();
		}
		System.out.println(str);
	}

	public void printUnit() {
		this.unitInfoString();
		if (this.alphaAtt > 0) {
			System.out.printf("(+%d)", this.alphaAtt);
		}
		System.out.printf("|방어력 %d", this.def);
		if (this.alphaDef > 0) {
			System.out.printf("(+%d)", this.alphaDef);
		}
		System.out.printf("파티 %b\n", this.party);
//		System.out.printf("%s|Lv.%d|HP %d/%d|공격력 %d|방어력 %d|파티 %b\n",this.name, this.level, this.hp, this.maxHp, this.att, this.def, this.party);
	}

	public void getItem(Item item) {
		int itemKind = item.getKind();
		if (itemKind == Item.WEAPON && this.weapon != null) {
			this.weapon.setUse(false);
		} else if (itemKind == Item.ARMOR && this.armor != null) {
			this.armor.setUse(false);
		} else if (itemKind == Item.RING && this.ring != null) {
			this.ring.setUse(false);
		}
		if (itemKind == Item.WEAPON) {
			this.weapon = item;
		} else if (itemKind == Item.ARMOR) {
			this.armor = item;
		} else if (itemKind == Item.RING) {
			this.ring = item;
		}
	}

	public void delItem(int sel) {
		if (sel == Item.WEAPON) {
			this.weapon.setUse(false);
			this.weapon = null;
		} else if (sel == Item.ARMOR) {
			this.armor.setUse(false);
			this.armor = null;
		} else if (sel == Item.RING) {
			this.ring.setUse(false);
			this.ring = null;
		}
	}

	public void delAllItem() {
		if (this.weapon != null) {
			this.weapon.setUse(false);
			this.weapon = null;
		}
		if (this.armor != null) {
			this.armor.setUse(false);
			this.armor = null;
		}
		if (this.ring != null) {
			this.ring.setUse(false);
			this.ring = null;
		}
	}

	public void setAlpha() {
		this.alphaAtt = 0;
		this.alphaDef = 0;
		if (this.weapon != null) {
			this.alphaAtt += this.weapon.getAttack();
			this.alphaDef += this.weapon.getDefense();
		}
		if (this.armor != null) {
			this.alphaAtt += this.armor.getAttack();
			this.alphaDef += this.armor.getDefense();
		}
		if (this.ring != null) {
			this.alphaAtt += this.ring.getAttack();
			this.alphaDef += this.ring.getDefense();
		}
	}
}
