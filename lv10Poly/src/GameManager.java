import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	Random ran = new Random();
	static Scanner scan = new Scanner(System.in);
	static String nextStage = "";
	String curStage = "";
	Map<String, Stage> stageList = new HashMap<>();
	
	public GameManager() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		
		nextStage = "TITEL";
	}
	
	public boolean changeStage(){
		
		
		return false;
	}
}
