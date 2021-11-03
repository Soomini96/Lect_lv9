//package basic;
//
//class PlayGame extends Thread {
//
//	boolean play = true;
//
//	@Override
//	public void run() {
////		super.run();
//		while (play) {
//			System.out.println("신나게 게임을 하는중 >>");
//			try {
//				sleep(300);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//}
//
//class PlayMusic implements Runnable { // 인터페이스이기 때문에 다중 상속 안되는 문제 우회 가능
//
//	boolean play = true;
//
//	@Override
//	public void run() {
////		super.run();
//		while (play) {
//			System.out.println("음악이 흐르고...");
//			try {
//				Thread.sleep(300);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//
//}
//
//public class 스레드 {
//	public static void main(String[] args) {
//
//		// 스레드 Thread
//		// .sleep()
//		// ㄴ ms 단위로 실행에 딜레이를 줄 수 있음
//
////		PlayGame game = new PlayGame();
////		game.start();
////
////		for (int i = 0; i < 10; i++) {
////			System.out.printf("<%d>\n", i);
////			try {
////				Thread.sleep(1000);
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
////			if (i == 8) {
////				System.out.println("앗, 엄마가 나타났다!");
//////				game.stop();
////				game.play = false;
////			}
////		}
//
////		PlayMusic music = new PlayMusic();
////		music.run();
//		// for문으로 멈춰지지가 않음
//
//		Runnable music = new PlayMusic();
//		Thread t = new Thread(music);
//		t.start();
//
//		for (int i = 0; i < 10; i++) {
//			System.out.printf("<%d>\n", i);
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			if (i == 8) {
//				System.out.println("앗, 엄마가 나타났다!");
//				
////				music.play = false; // 플레이 멤버에 접근이 불가능!
////				t.stop();
//				
//				PlayMusic temp = (PlayMusic) music;
//				temp.play = false;
//			}
//		}
//
//	}
//}
