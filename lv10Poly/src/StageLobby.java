
public class StageLobby extends Stage {
	@Override
	public void intit() {
		System.out.println("-----[LOBBY]-----");
		System.out.println("[1]전투 [2]종료");
		int sel = GameManager.scan.nextInt();
		if(sel == 1) {
			
		}else if(sel == 2) {
			
		}else {
			
		}
	}

	@Override
	public boolean update() {
		return false;
	}
}
