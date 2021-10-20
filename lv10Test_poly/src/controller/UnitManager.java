package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import units.Archer;
import units.Swordman;
import units.Wizard;

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
		this.playerMap.put("검사", new Swordman("검사",100,10));
		this.playerMap.put("마법사", new Wizard("마법사",90,15));
		this.playerMap.put("검사", new Archer("궁수",120,9));
	}
	
	public void setMonsterListClear() {
		this.monsterList.clear();
	}
	
	public void monsterRnSet(int size) {
		for(int i=0; i<size; i++) {
			int num = rn.nextInt(this.monsterList.size());
			Monster temp = (Monster)this.monsterMap.get(num);
		}
	}
	
}
