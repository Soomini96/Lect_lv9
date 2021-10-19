import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager UnitManager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monList = null;
	private Random rn = new Random();
	
	int monsterCount = 0;
	int playerCount = 0;
	
	@Override
	public void init() {
		

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
		System.out.println("[%s] [1.공격][2.스킬]");
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
			// TODO : 어택!
		}
	}
	private void monster_attack(int idx) {
		Unit m = this.monList.get(idx);
		if(m.hp<=0) {
			return;
		}
		while(true) {
			int rnIdx = rn.nextInt(this.playerList.size());
			if(this.playerList.get(rnIdx).hp > 0) {
				m.attack(this.playerList.get(rnIdx));
				break;
			}
		}
	}
	private void check_live() {
		
		
	}
}
