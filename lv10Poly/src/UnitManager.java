import java.util.Vector;

public class UnitManager {
	Vector<Player> player_list = new Vector<Player>();
	Vector<Unit> mon_list = new Vector<Unit>();
	
	public UnitManager() {
		this.player_list.add(new Player("검사", 1000, 45));
		this.player_list.add(new Player("마법사", 1000, 50));
		this.player_list.add(new Player("궁수", 1000, 35));
	}
	
	
}
