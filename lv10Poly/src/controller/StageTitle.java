package controller;

public class StageTitle extends Stage {
	@Override
	public void init() {
	}
	@Override
	public boolean update() {
		System.out.println("<<< TEXT RPG >>>");
		System.out.print("[시작]을 입력하세요: ");
		String start = GameManager.scan.next();
		if(start.equals("시작")) {
			GameManager.nextStage = "LOBBY";
			return false;
		}
		return true;
	}
}
