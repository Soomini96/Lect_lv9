package units;

import controller.Monster;
import controller.Player;

public class Bat extends Monster { 
	public Bat(String name, int hp, int power) {
		super(name, hp, power);
	}
	@Override
	public void attack(Player player) {
		player.setHp(player.getHp()-super.getPower());
		System.out.printf("[%s]이 [%s]에게 [%s]만큼의 데미지를 입힙니다.\n",super.getName(),player.getName(),super.getPower());
		if(player.getHp()<=0) {
			System.out.printf("[%s]을 처치했습니다.\n",player.getName());
			player.setHp(0);
		}		
	}
	@Override
	public void skill(Player player) {
		
	}
}
