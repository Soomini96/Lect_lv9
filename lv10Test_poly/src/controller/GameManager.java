package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {

	private static GameManager instance = new GameManager();

	public static GameManager getInstance() {
		return GameManager.instance;
	}

	public static String nextStage = "";
	private String nowStage = "";

	public static Scanner scan = new Scanner(System.in);

	private Map<String, Stage> map = new HashMap<String, Stage>();

	private GameManager() {
		this.map.put("COVER", new StageCover());
		this.map.put("LOBBY", new StageLobby());
		this.map.put("BATTLE", new StageBattle());
	}

	public void gameStart() {
		GameManager.nextStage = "COVER";

		while (true) {
			System.out.println("next: " + nextStage);
			System.out.println("now: " + this.nowStage);
			if (GameManager.nextStage == "") {
				break;
			} else if (GameManager.nextStage.equals(nowStage)) {
			} else {
				this.nowStage = GameManager.nextStage;

				Stage stage = this.map.get(nowStage);
				stage.init();

				boolean run = true;
				while (run) {
					run = stage.update();
				}
			}
		}
		System.out.println("Program close..");
	}

}
