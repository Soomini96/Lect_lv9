package controller;
import java.util.Random;
import java.util.Vector;

import units.UnitBat;

public class StageBattle extends Stage {
	UnitManager unitManager = new UnitManager();
	
//	Vector<Player> playerList = new Vector<>();
//	Vector<Unit> monList = new Vector<>();
	Vector<Player> playerList = null;
	Vector<Unit> monList = null;
	
	private Random rn = new Random();
	
	int monsterCount = 0;
	int playerCount = 0;
	
	@Override
	public void init() {
		this.unitManager.mon_list.clear();
		this.unitManager.monster_rnSet(4);
		
//		this.playerList.clear();
//		this.monList.clear(); // X
		this.playerList = null;
		this.monList = null;
		
		this.playerList = this.unitManager.player_list;
		this.monList = this.unitManager.mon_list;
		
		this.monsterCount = this.monList.size();
		this.playerCount = this.playerList.size();
	}

	@Override
	public boolean update() {
		boolean run = true;
		boolean turn = true;
		int p_idx = 0;
		int m_idx = 0;
		
		while(true) {
			if(turn) {
				print_character();
				if(p_idx < this.playerList.size()) {
					player_attack(p_idx);
					p_idx ++;
				}else {
					p_idx = 0;
					turn = !turn;
				}
			} else if(!turn) {
				if(m_idx<this.monList.size()) {
					monster_attack(m_idx);
					m_idx ++;
				}else {
					m_idx = 0;
					turn = !turn;
				}
			}
			check_live();
			if(this.monsterCount<=0 || this.playerCount<=0) {
				break;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
	
	private void print_character() {
		System.out.println("<< BATTLE>>");
		System.out.println("* PLAYER *");
		for(int i=0; i<this.playerList.size(); i++) {
			this.playerList.get(i).printData();
		}
		System.out.println("* MONSTER *");
		for(int i=0; i<this.monList.size(); i++) {
			this.monList.get(i).printData();
		}
	}
	private void player_attack(int idx) {
		Player p = this.playerList.get(idx);
		if(p.hp<0) {
			return;
		}
		else if(p.getFrozen()) {
			System.out.println(p.getName() + "은 이번 턴을 쉬어야 한다.");
			p.setFrozen(false);
			return;
		}
		System.out.printf("<%s> [1.공격][2.스킬]\n",p.getName());
		int sel = GameManager.scan.nextInt();
		if(sel == 1) {
			while(true) {
				int rnIdx = rn.nextInt(this.monList.size());
				if(this.monList.get(rnIdx).hp>0) {
					p.attack(this.monList.get(rnIdx));
					break;
				}
			}
		}else if(sel == 2) {
			while(true) {
				int rnIdx = rn.nextInt(this.monList.size());
				if(this.monList.get(rnIdx).hp>0) {
					p.skill(this.monList.get(rnIdx));
					break;
				}
			}
		}
	}
	private void monster_attack(int idx) {
		Unit m = this.monList.get(idx);
		if(m.hp<=0) {
			return;
		}
		else if(m.getFrozen()) {
			System.out.println(m.getName() + "은 이번 턴을 쉬어야 한다.");
			m.setFrozen(false);
			return;
		}
		while(true) {
			int rnIdx = rn.nextInt(this.playerList.size());
			if(this.playerList.get(rnIdx).hp > 0) {
				int skillGo = rn.nextInt(1);
				if (skillGo == 0) {
					try {
						if(m instanceof UnitBat) {
							UnitBat temp = (UnitBat) m;
							temp.skill(this.playerList.get(rnIdx));
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					// 어떻게 하면 UnitBat 안으로 들어갈까?
//					if(m.getName().equals("박쥐")) {
//						
//					}
					
				} else {
					m.attack(this.playerList.get(rnIdx));
				}
				break;
			}
		}
	}
	private void check_live() {
		int num = 0;
		for(int i=0; i<this.playerList.size(); i++) {
			if(this.playerList.get(i).hp>0) {
				num ++;
			}
		}
		this.playerCount = num;
		
		num = 0;
		for(int i=0; i<this.monList.size(); i++) {
			if(this.monList.get(i).hp>0) {
				num ++;
			}
		}
		this.monsterCount = num;
	}
}
