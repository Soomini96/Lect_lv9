package lv10_MyZombie;

//interface ZombieCheck {
//}

public class ZombieKing extends Unit implements ZombieCheck {
	private String name;
	public ZombieKing(String name, int hp, int attack, int defense, int location) {
		super(name, hp, attack, defense, location);
		this.name = name;
		this.birth();
	}
	@Override
	void birth() {
		System.out.printf("%sė íė!!\n", this.name);
	}
}
