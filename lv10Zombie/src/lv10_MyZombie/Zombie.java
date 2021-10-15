package lv10_MyZombie;

public class Zombie extends Unit {
	private String name;
	
	public Zombie(String name, int hp, int attack, int defense, int location) {
		super(name, hp, attack, defense, location);
		this.name = name;
		this.birth();
	}
	@Override
	void birth() {
		System.out.printf("%s의 탄생!!\n", this.name);
	}
}
