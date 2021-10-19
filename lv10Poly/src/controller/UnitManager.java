package controller;
import java.util.Random;
import java.util.Vector;

public class UnitManager {
	Vector<Player> player_list = new Vector<Player>();
	Vector<Unit> mon_list = new Vector<Unit>();
	
	private Random rn = new Random();
	String mons[] = {"UnitWolf","UnitBat","UnitOrc"};
	String path = "units.";
	
	public UnitManager() {
		this.player_list.add(new Player("검사", 1000, 45));
		this.player_list.add(new Player("마법사", 1000, 50));
		this.player_list.add(new Player("궁수", 1000, 35));
	}
	public void monster_rnSet(int size) {
		for(int i=0; i<size; i++) {
			int num = rn.nextInt(this.mons.length);
			try {
				// 제네릭을 활용한 객체 생성
				Class<?> c = Class.forName(this.path + this.mons[num]);
				// ㄴ 파리미터로 클래스의 풀 이름을 입력으로 받아서 클래스를 찾으면 그 클래스의 Class객체를 리턴하고 못 찾으면 예외를 발생시키는 메소드입니다.
				Object object = c.newInstance();
				Unit temp = (Unit)object;
				
				int hp = rn.nextInt(100) + 100;
				int power = rn.nextInt(10) + 10;
				temp.init(hp, power);
				this.mon_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
