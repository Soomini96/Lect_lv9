package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import units.Archer;
import units.Swordman;
import units.Wizard;
import units.Wolf;
import units.Bat;
import units.Orc;

public class UnitManager {
	private static UnitManager instance = new UnitManager();
	
	public static UnitManager getInstance() {
		return UnitManager.instance;
	}
	
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	private Map<String, Player> playerMap = new HashMap<>(); // (V)
	private Map<String, Monster> monsterMap = new HashMap<>();
	
	private Random rn = new Random();
	
	public UnitManager() {
		Player swordman = new Swordman("검사",100,10);
		this.playerMap.put("검사", swordman);
		this.playerList.add(swordman);
		
		Player wizard = new Wizard("마법사",90,15);
		this.playerMap.put("마법사", wizard);
		this.playerList.add(wizard);
		
		Player archer = new Archer("궁수",120,9);
		this.playerMap.put("검사", archer);
		this.playerList.add(archer);
		
		Monster bat = new Bat("박쥐",30,5);
		this.monsterMap.put("박쥐", bat);
//		this.monsterList.add(bat);
		
		Monster orc = new Orc("오크",50,10);
		this.monsterMap.put("오크", orc);
//		this.monsterList.add(orc);
		
		Monster wolf = new Wolf("늑대",40,13);
		this.monsterMap.put("늑대", wolf);
//		this.monsterList.add(wolf);
	}
	
	public void setMonsterListClear() {
		this.monsterList.clear();
	}
	
	public ArrayList<Player> getPlayerList() {
		return this.playerList;
	}
	
	public ArrayList<Monster> getMonsterList() {
		return this.monsterList;
	}
	
	public void monsterRnSet(int size) {
		String monsterName[] = {"박쥐","오크","늑대"};
		for(int i=0; i<size; i++) {
			int rMonster = rn.nextInt(this.monsterMap.size());
			Monster temp = (Monster)this.monsterMap.get(monsterName[rMonster]);
			this.monsterList.add(temp);
		}
		System.out.println("-----------");
		for(int i=0; i<this.monsterList.size(); i++) {
			System.out.println(this.monsterList.get(i).getName());
		}
		System.out.println("-----------");
	}
	
}
