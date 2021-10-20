package controller;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle implements Stage {
	UnitManager um = UnitManager.getInstance();
	
	ArrayList<Player> players = null;
	ArrayList<Monster> monsters = null;
	
	private int playerCount = 0;
	private int monsterCount = 0;
	
	private Random rn = new Random();
	
	@Override
	public void init() {
		this.um.setMonsterListClear();
		
		
	}

	@Override
	public boolean update() {
		boolean run = true;
		boolean turn = true; // true: player / false: monster
		int pIdx = 0;
		int mIdx = 0;
		
		while(run) {
			if(turn) {
				printUnits();
				if(pIdx<this.players.size()) {
					playerAttack(pIdx);
					pIdx++;
				}else {
					pIdx = 0;
					turn = !turn;
				}
			} else if(!turn) {
				if(mIdx<this.monsters.size()) {
					monsterAttack(mIdx);
					mIdx++;
				}else {
					mIdx = 0;
					turn = !turn;
				}
			}
			checkUnitCount();
		}
		return false;
	}
	
	private void printUnits() {
		System.out.println("====== BATTLE =======");
		System.out.println("*PLAYER*");
		for(int i=0; i<this.players.size(); i++) {
			
		}
		System.out.println("*MONSTERS*");
		for(int i=0; i<this.monsters.size(); i++) {
			
		}
	}
	
	private void playerAttack(int pIdx) {
		// TODO Auto-generated method stub
		
	}

	private void monsterAttack(int mIdx) {
		// TODO Auto-generated method stub
		
	}

	private void checkUnitCount() {
		// TODO Auto-generated method stub
		
	}

}
