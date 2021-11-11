package 경마;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.Board;

public class HorseGame extends JFrame{
	
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int W = dm.width;
	public static final int H = dm.height;
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;
	
	private Board board = new Board();
	
	public HorseGame() {
		super("경마");
		setLayout(null);
		setBounds(W/2 - WIDTH/2,H/2 - HEIGHT/2, WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.board);
		
		setVisible(true);
		revalidate();
		
		board.run();
	}


}
