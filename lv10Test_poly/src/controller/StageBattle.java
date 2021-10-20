package controller;

import java.util.ArrayList;
import java.util.Random;

import units.Archer;
import units.Bat;
import units.Orc;
import units.Swordman;
import units.Wizard;
import units.Wolf;

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
		this.um.monsterRnSet(4);
		
		this.players = null;
		this.monsters = null;
		
		this.players = this.um.getPlayerList();
		this.monsters = this.um.getMonsterList();
		
		this.playerCount = this.players.size();
		this.monsterCount = this.monsters.size();
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
			if(this.monsterCount<=0 || this.playerCount<=0) {
				break;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
	
	private void printUnits() {
		System.out.println("====== BATTLE =======");
		System.out.println("*PLAYER*");
		for(int i=0; i<this.players.size(); i++) {
			this.players.get(i).printPlayer();
		}
		System.out.println("*MONSTERS*");
		for(int i=0; i<this.monsters.size(); i++) {
			
		}
	}
	
	private void playerAttack(int pIdx) {
		Player p = this.players.get(pIdx);
		if(p.getHp()<0) {
			return;
		}
		else if(p.getStop()>0) {
			System.out.println(p.getName() + "은 이번턴을 쉬어야 한다.");
			p.setStop(p.getStop()-1);
			return;
		}
		
		System.out.printf("[%s] 1.공격 2.스킬(%d/5)\n",p.getName(),p.getGauge());
		String input = GameManager.scan.next();
		if(input.equals("1")) {
			while(true) {
				int rIdx = rn.nextInt(this.monsters.size());
				if(this.monsters.get(rIdx).getHp()>0) {
					try {
						if(p instanceof Swordman) {
							Swordman temp = (Swordman) p;
							temp.attack(this.monsters.get(rIdx));
						}
						else if(p instanceof Wizard) {
							Wizard temp = (Wizard) p;
							temp.attack(this.monsters.get(rIdx));
						}
						else if(p instanceof Archer) {
							Archer temp = (Archer) p;
							temp.attack(this.monsters.get(rIdx));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					p.setGauge(p.getGauge()+1);
					break;
				}
			}
		}else if(input.equals("2")) {
			if(p.getGauge()>=5) {
				while(true) {
					int rIdx = rn.nextInt(this.monsters.size());
					if(this.monsters.get(rIdx).getHp()>0) {
						try {
							if(p instanceof Swordman) {
								Swordman temp = (Swordman) p;
								temp.skill(this.monsters.get(rIdx));
							}
							else if(p instanceof Wizard) {
								Wizard temp = (Wizard) p;
								temp.skill(this.monsters.get(rIdx));
							}
							else if(p instanceof Archer) {
								Archer temp = (Archer) p;
								temp.skill(this.monsters.get(rIdx));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						p.setGauge(p.getGauge()-5);
						break;
					}
				}
				
			}else {
				System.out.println("아직 스킬을 사용 할 수 없다!");
			}
		}
		
	}

	private void monsterAttack(int mIdx) {
		Monster m = this.monsters.get(mIdx);
		if(m.getHp()>0) {
			return;
		}
		while(true) {
			int rIdx = rn.nextInt(this.players.size());
			if(this.players.get(rIdx).getHp()>0) {
				int skillGo = rn.nextInt(6);
				if(skillGo == 0) {
					try {
						if(m instanceof Bat) {
							Bat temp = (Bat) m;
							temp.attack(this.players.get(rIdx));
						}
						else if(m instanceof Orc) {
							Orc temp = (Orc) m;
							temp.attack(this.players.get(rIdx));
						}
						else if(m instanceof Wolf) {
							Wolf temp = (Wolf) m;
							temp.attack(this.players.get(rIdx));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						if(m instanceof Bat) {
							Bat temp = (Bat) m;
							temp.skill(this.players.get(rIdx));
						}
						else if(m instanceof Orc) {
							Orc temp = (Orc) m;
							temp.skill(this.players.get(rIdx));
						}
						else if(m instanceof Wolf) {
							Wolf temp = (Wolf) m;
							temp.skill(this.players.get(rIdx));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			}
		}
	}

	private void checkUnitCount() {
		int cnt = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.players.get(i).getHp()>0) {
				cnt ++;
			}
		}
		this.playerCount = cnt;
		
		cnt = 0;
		for(int i=0; i<this.monsters.size(); i++) {
			if(this.monsters.get(i).getHp()>0) {
				cnt ++;
			}
		}
		this.monsterCount = cnt;
	}

}
