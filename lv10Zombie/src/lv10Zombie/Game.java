package lv10Zombie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private Game instance = new Game();
	private Game() {}
	public Game getInstance() {
		return this.instance;
	}
	
	public static Scanner sc = new Scanner(System.in);
	public static Random rn = new Random();
	
	private Hero player;
	private ArrayList<Unit> zombies = new ArrayList<Unit>();
	
	private void firstSetting() {
		this.player = new Hero("플레이어", 100, 5, 2, 1);
	}
}
