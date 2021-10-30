//package basic;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Random;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//class Contents extends JPanel implements ActionListener {
//	private JButton[][] map;
//	private int[][] front;
//	private int[][] back;
//
//	private int number = 1;
//
//	private JButton start = new JButton();
//	private boolean startgame = false;
//
//	private int min;
//	private int sec;
//	private int ms;
//	private JLabel watch = new JLabel();
//
//	public Contents() {
//		setLayout(null);
//		setBounds(0, 0, 800, 900);
//		setBackground(new Color(254, 245, 237));
//
//		putNumber();
//		setHeader();
//		setMap();
//		startButton();
//		setWatch();
//		System.out.println("??");
//	}
//	
//	public void setWatchTime(int n) {
//		this.ms = n;
//		setWatch();
//	}
//
//	public void setWatch() {
//		this.watch.setBounds(0, 0, 200, 100);
//		this.watch.setText(String.format("%2d. %2d. %3d\n", this.min, this.sec, this.ms));
//		add(this.watch);
//	}
//
//	private void startButton() {
//		this.start.setBounds(800 / 2 - 500 / 2, 680, 500, 50);
//		this.start.setText("♪♫ Game Start ♪♫");
//		this.start.addActionListener(this);
//		add(this.start);
//	}
//
//	private void setHeader() {
//		JLabel head = new JLabel("1 to 50");
//		head.setBounds(0, 0, 800, 200);
//		head.setFont(new Font("", Font.BOLD, 40));
//		head.setVerticalAlignment(JLabel.CENTER);
//		head.setHorizontalAlignment(JLabel.CENTER);
//		add(head);
//	}
//
//	private void putNumber() {
//		Random rn = new Random();
//		int num = 1;
//		this.front = new int[5][5];
//		this.back = new int[5][5];
//		for (int i = 0; i < this.front.length; i++) {
//			for (int j = 0; j < this.front[i].length; j++) {
//				this.front[i][j] = num;
//				num++;
//			}
//		}
//		for (int i = 0; i < this.front.length; i++) {
//			for (int j = 0; j < this.front[i].length; j++) {
//				this.back[i][j] = num;
//				num++;
//			}
//		}
//		for (int i = 0; i < 3000; i++) {
//			int r1X = rn.nextInt(this.front.length);
//			int r1Y = rn.nextInt(this.front.length);
//			int r2X = rn.nextInt(this.front.length);
//			int r2Y = rn.nextInt(this.front.length);
//
//			int temp = this.front[0][0];
//			this.front[0][0] = this.front[r1X][r1Y];
//			this.front[r1X][r1Y] = temp;
//
//			temp = this.back[0][0];
//			this.back[0][0] = this.back[r2X][r2Y];
//			this.back[r2X][r2Y] = temp;
//		}
//	}
//
//	private void setMap() {
//		this.map = new JButton[5][5];
//		int x = 800 / 2 - 500 / 2;
//		int y = 800 / 2 - 500 / 2;
//		for (int i = 0; i < this.map.length; i++) {
//			for (int j = 0; j < this.map[i].length; j++) {
//				this.map[i][j] = new JButton();
//				this.map[i][j].setBounds(x, y, 100, 100);
//				this.map[i][j].setBackground(new Color(211, 228, 205));
//				this.map[i][j].addActionListener(this);
//
//				this.map[i][j].setOpaque(true);
//				this.map[i][j].setBorderPainted(false);
//				add(this.map[i][j]);
//
//				x += 100 + 1;
//			}
//			x = 800 / 2 - 500 / 2;
//			y += 100 + 1;
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton target = (JButton) e.getSource();
//
//		if (target == this.start) {
//			this.start.setText("** RESET **");
//			this.startgame = true;
//			for (int i = 0; i < this.map.length; i++) {
//				for (int j = 0; j < this.map[i].length; j++) {
//					this.map[i][j].setBackground(new Color(173, 194, 169));
//					this.map[i][j].setText(String.valueOf(this.front[i][j]));
//					this.map[i][j].setFont(new Font("", Font.BOLD, 30));
////					this.map[i][j].setFont(new Font(TOOL_TIP_TEXT_KEY, Font., i));
//				}
//			}
//		} else if (this.startgame) {
//			for (int i = 0; i < this.map.length; i++) {
//				for (int j = 0; j < this.map[i].length; j++) {
//					if (target == this.map[i][j] && this.front[i][j] == this.number) {
//						this.front[i][j] = this.back[i][j];
//						this.back[i][j] = 0;
//						if (this.number <= 25) {
//							target.setBackground(new Color(153, 167, 153));
//							target.setText(String.valueOf(this.front[i][j]));
//							target.setFont(new Font("", Font.BOLD, 30));
//						} else {
//							target.setBackground(Color.gray);
//							target.setText(null);
//						}
//						this.number++;
//					}
//				}
//			}
//			if (this.number > 50) {
//				gameEnd();
//			}
//		}
//	}
//
//	private void gameEnd() {
//		JOptionPane.showMessageDialog(null, "Game Clear!");
//		this.startgame = false;
//		this.number = 1;
//		this.start.setText("♪♫ Game Start ♪♫");
//		putNumber();
//	}
//}
//
//class Game1To50 extends JFrame {
//
//	private Contents content = new Contents();
//
//	public Game1To50() {
//		super("1 To 50");
//
//		setLayout(null);
//		setBounds(300, 0, 800, 900);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//		add(this.content);
//
//		setVisible(true);
//		revalidate();
//	}
//
//	public void setWatchTime(int n) {
//		System.out.println("!!!");
//		this.content.setWatchTime(n);
//	}
//
//}
//
//public class Ex_1to50 {
//	public static void main(String[] args) {
//		Game1To50 game = new Game1To50();
//
//		int n = 0;
//		while (true) {
//			try {
//				// setter
//				Thread.sleep(100);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			game.setWatchTime(n);
//		}
//	}
//}
