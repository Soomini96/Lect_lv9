package snake_gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnakePanel extends MyUtil {
	
	private Rect[][] map;
	
	private int size;
	private Rect[] snake;
	
	public SnakePanel() {
		// TODO Auto-generated constructor stub
	}
}

public class Game extends JFrame {
	
	private SnakePanel panel = new SnakePanel();
	
	public Game() {
		super("Snake Game");
		setLayout(null);
		setBounds(100, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		
		setVisible(true);
		revalidate();
	}
}
