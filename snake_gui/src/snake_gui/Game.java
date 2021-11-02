package snake_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class SnakePanel extends MyUtil {
	
	private final int SIZE = 10; 
	private Rect[][] map;
	
	private int size; // 뱀 꼬리 길이
	private Rect[] snake;
	
	private JLabel title;
	private JButton controller[] = new JButton[4];
	private JButton resetButton;
	
	public SnakePanel() {
		setLayout(null);
		setBounds(0, 0, 800, 700);
		setBackground(Color.white);
		
		setTitle();
		setMap();
		setButton();
	}

	private void setTitle() {
		String name = "SNAKE GAME";
		
		this.title = new JLabel(name);
		this.title.setBounds(0, 0, 300, 100);
		this.title.setFont(new Font("Arial", Font.BOLD, 30));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.BOTTOM);
		
		add(this.title);
	}
	
	private void setMap() {
		this.map = new Rect[this.SIZE][this.SIZE];
		
		int x = 50;
		int y = 115;
		
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				this.map[i][j] = new Rect(x,y,50,50);
				this.map[i][j].setColor(Color.black);
				x+= 50;
			}
			x = 50;
			y += 50;
		}
	}
	
	private void setButton() {
		
		String buttons[] = {"◀︎","▼","▶︎","▲"};
		int x = 600;
		int y = 500;
		
		for(int i=0; i<this.controller.length; i++) {
			this.controller[i] = new JButton();
			this.controller[i].setBounds(x, y, 50, 50);
			this.controller[i].setText(buttons[i]);
			
			add(this.controller[i]);
			x+= 50;
			if(i == 2) {
				x = 650;
				y -= 50;
			}
		}
		
		this.resetButton = new JButton();
		this.resetButton.setBounds(600, 560, 150, 50);
		this.resetButton.setText("RESET");
		add(this.resetButton);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				g.drawRect(this.map[i][j].getX(), this.map[i][j].getY(), this.map[i][j].getWidth(), this.map[i][j].getHeight());
				g.setColor(this.map[i][j].getColor());
			}
		}
//		repaint();
	}
}

public class Game extends JFrame {
	
	private SnakePanel panel = new SnakePanel();
	
	public Game() {
		super("Snake Game");
		setLayout(null);
		setBounds(100, 50, 800, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		
		setVisible(true);
		revalidate();
	}
}
