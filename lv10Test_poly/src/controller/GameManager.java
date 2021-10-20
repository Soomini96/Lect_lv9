package controller;

import java.util.Scanner;

public class GameManager {
	private GameManager() {
	}

	private static GameManager instance = new GameManager();

	public static GameManager getInstance() {
		return GameManager.instance;
	}
	
	private String nextStage;
	private String nowStage;
	
	private Scanner scan = new Scanner(System.in);
	
//	public void 
	
}
