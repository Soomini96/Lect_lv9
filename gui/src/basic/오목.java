//package basic;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//class Map extends JPanel implements ActionListener {
//
//	private final int SIZE = 10;
//	private JButton[][] map = new JButton[SIZE][SIZE];
//	private int[][] mark = new int[SIZE][SIZE];
//	private final int BUTTON = 56;
//
//	private int turn = 1;
//	private boolean isRun = true;
//	private int win = 0;
//
//	private JButton reset = new JButton();
//
//	public Map() {
//		setLayout(null);
//		setBounds(0, 0, OmokGame.WIDTH, OmokGame.HEIGHT);
//		setBackground(new Color(244, 164, 66));
//		
//		setTitle();
//		setMap();
//		setResetButton();
//	}
//
//	private void setTitle() {
//		JLabel head = new JLabel(" 오목 게임 ");
//		head.setBounds(0, 0, OmokGame.WIDTH,200);
//		head.setFont(new Font("",Font.BOLD, 40));
//		head.setHorizontalAlignment(JLabel.CENTER);
//		head.setVerticalAlignment(JLabel.CENTER);
//		add(head);
//	}
//	private void setMap() {
//		
//		int x = OmokGame.WIDTH/2 - this.BUTTON * this.SIZE / 2;
//		int y = OmokGame.HEIGHT/2 - this.BUTTON * this.SIZE/2;
//		
//		for(int i=0; i<this.SIZE; i++) {
//			for(int j=0; j<this.SIZE; j++) {
//				this.map[i][j] = new JButton();
//				this.map[i][j].setBounds(x, y, this.BUTTON, this.BUTTON);
//				this.map[i][j].setText("•");
//				
//				this.map[i][j].setOpaque(true);
//				this.map[i][j].setBorderPainted(false);
//				
//				this.map[i][j].setBackground(new Color(244, 164, 66));
//				this.map[i][j].setFont(new Font("",Font.BOLD,10));
//				
//				this.map[i][j].addActionListener(this);
//				add(this.map[i][j]);
//				x += this.BUTTON +3;
//			}
//			x = OmokGame.WIDTH/2 - this.BUTTON * this.SIZE / 2;
//			y += this.BUTTON + 3;
//		}
//	}
//	
//	private void setResetButton() {
//		this.reset.setBounds(OmokGame.WIDTH / 2 - 150, OmokGame.HEIGHT - 140,  300, 50);
//		this.reset.setText("RESET");
//		this.reset.setForeground(Color.white);
//		
//		this.reset.setOpaque(true);
//		this.reset.setBorderPainted(false);
//		this.reset.setBackground(Color.black);
//		
//		this.reset.addActionListener(this);
//		add(this.reset);
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton target = (JButton) e.getSource();
//		if(target == reset) {
//			
//		}else {
//			for(int i=0; i<this.SIZE; i++) {
//				for(int j=0; j<this.SIZE; j++) {
//					if(target == this.map[i][j] && this.mark[i][j] == 0 && this.isRun) {
//						this.mark[i][j] = this.turn;
//						if(this.turn == 1) {
//							this.map[i][j].setText("X");
//						}else if(this.turn == 2) {
//							this.map[i][j].setText("O︎");
//						}
//						this.mark[i][j] = turn;
//						this.map[i][j].setFont(new Font("",Font.BOLD, 15));
//						
//						checkWin();
//						this.turn = this.turn == 1? 2: 1;
//					}
//				}
//			}
//		}
//	}
//
//	private void checkWin() {
//		this.win = this.win == 0? checkHori(): this.win;
//		this.win = this.win == 0? checkVerti(): this.win;
//		this.win = this.win == 0? checkDia(): this.win;
//		this.win = this.win == 0? checkReverse(): this.win;
//		
//		if(this.win != 0 && this.isRun) {
//			this.isRun = false;
//			new AlertFrame(String.format("Player%d WIN!!", this.win));
//		}
//	}
//
//	private int checkHori() {
//		for(int i=0; i<this.SIZE; i++) {
//			int check = 0;
//			for(int j=0; j<this.SIZE; j++) {
//				if(this.mark[i][j] == this.turn) {
//					check ++;
//				}else {
//					check = 0;
//				}
//			}
//			if(check == 5) {
//				return this.turn;
//			}
//		}
//		return 0;
//	}
//
//	private int checkVerti() {
//		for(int i=0; i<this.SIZE; i++) {
//			int check = 0;
//			for(int j=0; j<this.SIZE; j++) {
//				if(this.mark[j][i] == this.turn) {
//					check ++;
//				}else {
//					check = 0;
//				}
//			}
//			if(check == 5) {
//				return this.turn;
//			}
//		}
//		return 0;
//	}
//
//	private int checkDia() {
//		for(int i=0; i<=this.SIZE-5; i++) {
//			for(int j=0; j<=this.SIZE-5; j++) {
//				if(this.mark[i][j] == this.turn) {
//					int check = 0;
//					for(int k=0; k<5; k++) {
//						if(this.mark[i+k][j+k] == this.turn) {
//							check ++;
//						}
//					}
//					if(check == 5) {
//						return this.turn;
//					}
//				}
//			}
//		}
//		return 0;
//	}
//
//	private int checkReverse() {
//		for(int i=0; i<=this.SIZE-5; i++) {
//			for(int j=5 - 1; j< this.SIZE; j++) {
//				if(this.mark[i][j] == this.turn) {
//					int check = 0;
//					for(int k=0; k<5; k++) {
//						if(this.mark[i-k][j-k] == this.turn) {
//							check ++;
//						}
//					}
//					if(check == 5) {
//						return this.turn;
//					}
//				}
//			}
//		}
//		return 0;
//	}
//}
//
//class AlertFrame extends JFrame{
//	JLabel text = new JLabel();
//	
//	public AlertFrame(String text) {
//		setLayout(null);
//		setBounds(OmokGame.W/2 - 200/2, OmokGame.H/2 - 200 / 2, 200, 200);
//		setVisible(true);
//		
//		this.text.setBounds(0, 0, 200, 200);
//		this.text.setText(text);
//		this.text.setHorizontalAlignment(JLabel.CENTER);
//		this.text.setVerticalAlignment(JLabel.CENTER);
//		this.text.setVisible(true);
//		add(this.text);
//	}
//}
//
//class OmokGame extends JFrame {
//	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
//	public static final int W = dm.width;
//	public static final int H = dm.height;
//
//	public static final int WIDTH = 900;
//	public static final int HEIGHT = 900;
//
//	private Map map = new Map();
//
//	public OmokGame() {
//		super("Omok Game");
//		setLayout(null);
//		setBounds(W / 2 - this.WIDTH / 2, H / 2 - this.HEIGHT / 2, WIDTH, HEIGHT);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//		revalidate();
//
//		add(map);
//	}
//}
//
//public class 오목 {
//
//	public static void main(String[] args) {
//
//		OmokGame omok = new OmokGame();
//
//	}
//
//}
