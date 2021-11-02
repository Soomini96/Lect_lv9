package snake_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class AlertFrame extends JFrame {
	JLabel text = new JLabel();

	public AlertFrame(String text) {
		setLayout(null);
		setBounds(300, 300, 200, 200);
		setVisible(true);

		this.text.setBounds(0, 0, 200, 100);
		this.text.setText(text);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		this.text.setVerticalAlignment(JLabel.BOTTOM);
		this.text.setVisible(true);
		add(this.text);
	}
}

class SnakePanel extends MyUtil {

	private final int SIZE = 10;
	private Rect[][] map;

	private int size; // 뱀 꼬리 길이
	private Rect[] snake;
	private int xx;
	private int yy;
	private boolean die;

	private final Color body = Color.ORANGE;
	private final Color head = Color.PINK;
	private final Color ITEM = Color.RED;

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

		// key Listener
		setFocusable(true);
		addKeyListener(this);
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

		for (int i = 0; i < this.SIZE; i++) {
			for (int j = 0; j < this.SIZE; j++) {
				this.map[i][j] = new Rect(x, y, 50, 50);
				this.map[i][j].setColor(Color.black);
				x += 50;
			}
			x = 50;
			y += 50;
		}

	}

	private void setSnake() { // 초기 설정
		for (int i = 0; i < this.SIZE; i++) {
			for (int j = 0; j < this.SIZE; j++) {
				this.map[i][j].setColor(Color.black);
			}
		}

		this.xx = 5;
		this.yy = 5;

		int xx = this.xx;
		int yy = this.yy;

		this.size = 4;
		this.snake = new Rect[this.size];
		
		for (int i = 0; i < this.size; i++) {
			this.snake[i] = this.map[yy][xx];
			xx--;
			this.snake[i].setColor(this.body);
		}
		this.snake[0].setColor(this.head);
		this.die = false;
	}

	private void setButton() {
		String buttons[] = { "◀︎", "▼", "▶︎", "▲" };
		int x = 600;
		int y = 500;

		for (int i = 0; i < this.controller.length; i++) {
			this.controller[i] = new JButton();
			this.controller[i].setBounds(x, y, 50, 50);
			this.controller[i].setText(buttons[i]);

			this.controller[i].addActionListener(this);
			add(this.controller[i]);
			x += 50;
			if (i == 2) {
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
				} else {
					g.fillRect(this.map[i][j].getX(), this.map[i][j].getY(), this.map[i][j].getWidth(),
							this.map[i][j].getHeight());

				}
			}
		}
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		// check
//		for (int i = 0; i < this.size; i++) {
//			System.out.println(i + "번째 주소: " + this.snake[i]);
//			System.out.println(this.snake[i].getColor());
//		}
		System.out.println("버튼");

		JButton target = (JButton) e.getSource();
		if (target == this.resetButton) {
			System.out.println("!!RESET!!");
			this.setSnake();
		} else {
			int go = 0; // 1 2 3 4
			if (target == this.controller[0]) { // 좌
				go = 1;
			} else if (target == this.controller[1]) { // 하
				go = 2;
			} else if (target == this.controller[2]) { // 우
				go = 3;
			} else if (target == this.controller[3]) { // 상
				go = 4;
			}
			moveSnake(go);
		}
	}

	private void moveSnake(int go) {
		int x = this.xx;
		int y = this.yy;

		Rect[] temp = this.snake;

		if (go == 1) { // 좌
			x--;
		} else if (go == 2) { // 하
			y++;
		} else if (go == 3) { // 우
			x++;
		} else if (go == 4) { // 상
			y--;
		}

		if (!this.die && x >= 0 && x < this.SIZE && y >= 0 && y < this.SIZE) {
			this.xx = x;
			this.yy = y;

			temp[temp.length - 1].setColor(Color.black);

			Rect nextRect = this.map[this.yy][this.xx];
			// 자기 몸 물면 die && 꼬리는 괜찮음
			if (nextRect.getColor() != Color.black && nextRect.getColor() != ITEM
					&& nextRect != temp[temp.length - 1]) {
				this.die = true;
			}

			// TODO: 아이템?
			if (nextRect.getColor() == ITEM) {
				this.size++;
				temp[temp.length - 1].setColor(body);
			}

			this.snake = new Rect[this.size];

			for (int i = 0; i < this.size; i++) {
				if (i == 0) {
					this.snake[0] = nextRect;
				} else {
					this.snake[i] = temp[i - 1];
				}
				this.snake[i].setColor(body);
			}
			this.snake[0].setColor(head);
			randomItem();
		} else {
			this.die = true;
//				JOptionPane.showMessageDialog(null, String.format("You Die!"));
			new AlertFrame(String.format("You Die!"));
		}
	}

	private void randomItem() {
		boolean itemExist = false;
		for (int i = 0; i < this.SIZE; i++) {
			for (int j = 0; j < this.SIZE; j++) {
				if (this.map[i][j].getColor() == this.ITEM) {
					itemExist = true;
				}
			}
		}
		if (!itemExist) {
			Random rn = new Random();
			while (true) {
				int itemX = rn.nextInt(this.SIZE);
				int itemY = rn.nextInt(this.SIZE);

				if (this.map[itemY][itemX].getColor() == Color.black) {
					this.map[itemY][itemX].setColor(ITEM);
					break;
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed");

		int go = 0; // 1 2 3 4
		if (e.getKeyCode() == e.VK_LEFT || e.getKeyCode() == e.VK_A) { // 좌
			go = 1;
		} else if (e.getKeyCode() == e.VK_DOWN || e.getKeyCode() == e.VK_S) { // 하
			go = 2;
		} else if (e.getKeyCode() == e.VK_RIGHT || e.getKeyCode() == e.VK_D) { // 우
			go = 3;
		} else if (e.getKeyCode() == e.VK_UP || e.getKeyCode() == e.VK_W) { // 상
			go = 4;
		}
		moveSnake(go);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped");
//		super.keyTyped(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased");
//		super.keyReleased(e);
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
