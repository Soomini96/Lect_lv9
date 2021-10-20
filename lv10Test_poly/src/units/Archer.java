package units;

import controller.Monster;
import controller.Player;

public class Archer extends Player {
	
	public Archer(String name, int hp, int power) {
		super(name,hp,power);
	}
	
	@Override
	public void attack(Monster monster) {
		monster.setHp(monster.getHp()-super.getPower());
		System.out.printf("[%s]이 [%s]에게 [%s]만큼의 데미지를 입힙니다.\n",super.getName(),monster.getName(),super.getPower());
		if(monster.getHp()<=0) {
			System.out.printf("[%s]을 처치했습니다.\n",monster.getName());
			monster.setHp(0);
		}
	}
	@Override
	public void skill(Monster monster) {
		// TODO Auto-generated method stub
		
	}
}
