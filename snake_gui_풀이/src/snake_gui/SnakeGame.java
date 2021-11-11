package snake_gui;

import java.awt.*; // dimension 쓰기 위해서!
import javax.swing.JFrame;

class SnakeGame extends JFrame{
	
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int WIDTH = dm.width;
	public static int HEIGHT = dm.height;
	
	public static final int SIZE = 700;
	
	public SnakeGame() {
		super("Snake Game");
		setLayout(null);
		setBounds(WIDTH/2-SIZE/2, HEIGHT/2 - SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Game());
		
		setVisible(true);
		revalidate();
	}
}
