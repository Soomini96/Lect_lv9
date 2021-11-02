package snake_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class SnakePanel extends MyUtil {
	
	private final int SIZE = 10; 
	private Rect[][] map;
	
	private int size; // 뱀 꼬리 길이
	private Rect[] snake;
	private int xx;
	private int yy;
	private boolean die;
	
	private Color body = Color.ORANGE;
	private Color head = Color.PINK;
	
	private JLabel title;
	private JButton controller[] = new JButton[4];
	private JButton resetButton;
	
	public SnakePanel() {
		setLayout(null);
		setBounds(0, 0, 800, 700);
		setBackground(Color.white);
		
		setTitle();
		setMap();
		setSnake();
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
	
	private void setSnake() {
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				this.map[i][j].setColor(Color.black);
			}
		}
		
		this.xx = 5;
		this.yy = 5;
		int xx = this.xx;
		int yy = this.yy;
		this.size = 4;
		this.snake = new Rect[this.size];
		for(int i=0; i<this.size; i++) {
			this.snake[i] = this.map[yy][xx];
			xx --;
			this.snake[i].setColor(this.body);
		}
		this.snake[0].setColor(this.head);
	}
	
	private void setButton() {
		String buttons[] = {"◀︎","▼","▶︎","▲"};
		int x = 600;
		int y = 500;
		
		for(int i=0; i<this.controller.length; i++) {
			this.controller[i] = new JButton();
			this.controller[i].setBounds(x, y, 50, 50);
			this.controller[i].setText(buttons[i]);
			
			this.controller[i].addActionListener(this);
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
		this.resetButton.addActionListener(this);
		add(this.resetButton);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < this.SIZE; i++) {
			for (int j = 0; j < this.SIZE; j++) {
				g.setColor(this.map[i][j].getColor());
				if (this.map[i][j].getColor() == Color.black) {
					g.drawRect(this.map[i][j].getX(), this.map[i][j].getY(), this.map[i][j].getWidth(),
							this.map[i][j].getHeight());
				}else {
					g.fillRect(this.map[i][j].getX(), this.map[i][j].getY(), this.map[i][j].getWidth(),
							this.map[i][j].getHeight());
					
				}
			}
		}
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // (5,5)
		
		// check
		for(int i=0; i<this.size; i++) {
			System.out.println(i+"번째 주소: "+this.snake[i]);
			System.out.println(this.snake[i].getColor());
		}
		
		
		JButton target = (JButton) e.getSource();
		if(target == this.resetButton) {
			System.out.println("!!RESET!!");
			this.setSnake();
		} 
//		else if(this.xx>=0 && this.xx<this.SIZE-1 && this.yy>=0 && this.yy<this.SIZE-1) {
		else {
			// TODO : 이러면 다른 곳으로 움직이는게 안됨...
			System.out.printf("(xx, yy): (%d, %d)\n",this.xx,this.yy);
			
			Rect[] temp = this.snake;
			
			if(target == this.controller[0]) { // 좌
				this.xx --;
			}
			else if(target == this.controller[1]) { // 하
				this.yy ++;
			}
			else if(target == this.controller[2]) { // 우
				this.xx ++;
			}
			else if(target == this.controller[3]) { // 상
				this.yy --;
			}
			
			
			// TODO: 아이템?
			temp[temp.length-1].setColor(Color.black);
			Rect nextRect = this.map[this.yy][this.xx];
			System.out.println("new adress : " + nextRect);
			this.snake = new Rect[this.size];
			
			for(int i=0; i<this.size; i++) {
				if(i == 0) {
					this.snake[0] = nextRect;
				}else {
					this.snake[i] = temp[i-1];
				}
				this.snake[i].setColor(body);
			}
			this.snake[0].setColor(head);
		}
//		else {
//			System.out.println("You Die!");
//		}
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
