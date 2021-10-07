package controller;

import java.util.ArrayList;

import models.Unit;

public class Guild {
	private final int PARTYSIZE = 4;
	private ArrayList<Unit> units = new ArrayList<>();
	private Unit partyUnit[] = new Unit[this.PARTYSIZE];
	public Guild() {
		// 길드원 추가하기
		for(int i=0; i<10; i++) {
			this.units.add(addUnit());
		}
		// 파티원 정해서 넣기
		for(int i=0; i< this.PARTYSIZE; i++) {
			this.units.get(i).turnOnParty();;
		}
		this.partyUnitCheck();
	}
	private Unit addUnit() {
		String name1[] = {"이","김","구","박","한","전","최","한","허"};
		String name2[] = {"수","두","슬","상","세","효","유","은","승"};
		String name3[] = {"민","호","비","윤","영","주","정","선","혁"};
		String name = name1[Player.ran.nextInt(name1.length)];
		name += name2[Player.ran.nextInt(name2.length)];
		name += name3[Player.ran.nextInt(name3.length)];
		
		int num = Player.ran.nextInt(name1.length);
		int hp = num * 10;
		int att = num + 5;
		int def = num + 3;
		
		Unit newUnit = new Unit(name, hp, att, def);
		return newUnit;
	}
	private void partyUnitCheck() {
		int idx = 0;
		for(int i=0; i<this.units.size(); i++) {
			if(this.units.get(i).getParty()) {
				this.partyUnit[idx] = this.units.get(i);
				idx ++;
			}
		}
	}
}
