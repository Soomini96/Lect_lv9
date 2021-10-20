package controller;

public class StageLobby implements Stage {
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update() {
		System.out.println("<<< LOBBY >>>");
		System.out.println("[1] 게임 시작");
		System.out.println("[2] 초기화");
		System.out.println("[3] 뒤로가기");
		System.out.print(": ");
		String input = GameManager.scan.next();
		if (input.equals("1")) {
			GameManager.nextStage = "BATTLE";
			return false;
		} 
//		else if (input.equals("2")) {
//			GameManager.nextStage = "";
//			return false;
//		} 
		else if (input.equals("3")) {
			GameManager.nextStage = "COVER";
			return false;
		}
		return true;
	}
}
