package controller;

public class StageCover implements Stage {
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update() {
		System.out.println("<<< TEXT RPG >>>");
		System.out.println("[시작]: 게임 시작 / [종료]: 프로그램 종료");
		System.out.print(": ");
		String input = GameManager.scan.next();
		if(input.equals("시작")) {
			GameManager.nextStage = "LOBBY";
			return false;
		}else if(input.equals("종료")) {
			GameManager.nextStage = "";
			return false;
		}
		return true;
	}
}
