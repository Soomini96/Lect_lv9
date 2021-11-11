package controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Sokoban extends JFrame{
	
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int W = dm.width;
	public static final int H = dm.height;
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 650;
	
	private Board board = new Board();
	
	public Sokoban() {
		setLayout(null);
		setBounds((Sokoban.W-Sokoban.WIDTH)/2, (Sokoban.H - Sokoban.HEIGHT)/2, WIDTH, HEIGHT);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(this.board);
		
		setVisible(true);
		revalidate();
	}
}
