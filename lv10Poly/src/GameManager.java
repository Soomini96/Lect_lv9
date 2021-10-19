import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	Random ran = new Random();
	static Scanner scan = new Scanner(System.in);
	static String nextStage = "";
//	String nextStage = "";
	String curStage = "";
	Map<String, Stage> stageList = new HashMap<>();
	
	public GameManager() {
		stageList.put("TITLE", new StageTitle());
//		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		
		nextStage = "TITLE";
	}
	
	public boolean changeStage(){ // 중요!!
		
		if(nextStage.equals("")) { // 다시 돌아왔을때 이거인지?
			return false;
		}
		else if(this.curStage.equals(nextStage)) {
			return true;
		}
		else {
			this.curStage = nextStage;
			
			Stage stage = this.stageList.get(this.curStage); // 키값이 Curstage
			stage.init(); // 각 단계 초기 세팅
			
			boolean run = true;
			while(run) { // 각 단계의 반복
				run = stage.update();
			}
			return true;
		}
	}
}
