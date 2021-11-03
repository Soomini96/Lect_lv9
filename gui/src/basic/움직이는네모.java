//package basic;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//class Nemo1 {
//	int x = 200;
//	int y = 100;
//	final int SIZE = 100;
//}
//
//class Nemo2 {
//	int x = 310;
//	int y = 210;
//	final int SIZE = 100;
//}
//
//class Map extends JPanel implements ActionListener , KeyListener{
//
//	private Nemo1 nemo1 = new Nemo1();
//	private Nemo2 nemo2 = new Nemo2();
//
//	private JButton up = new JButton();
//	private JButton down = new JButton();
//	private JButton left = new JButton();
//	private JButton right = new JButton();
//	
//	private final int MOVE = 13;
//
//	public Map() {
//		setLayout(null);
//		setBounds(0, 0, MovingSquare.W, MovingSquare.H);
//		setBackground(Color.pink);
//
//		setController();
//		
//		// key 리스너 add
//		setFocusable(true);
//		addKeyListener(this);
//	}
//
//	private void setController() {
//		this.up.setBounds(900, 600, 60, 60);
//		this.up.setText("▲");
//		this.up.addActionListener(this);
//		add(this.up);
//
//		this.down.setBounds(900, 660, 60, 60);
//		this.down.setText("▼");
//		this.down.addActionListener(this);
//		add(this.down);
//
//		this.right.setBounds(960, 660, 60, 60);
//		this.right.setText("▶︎");
//		this.right.addActionListener(this);
//		add(this.right);
//
//		this.left.setBounds(840, 660, 60, 60);
//		this.left.setText("◀︎︎");
//		this.left.addActionListener(this);
//		add(this.left);
//	}
//
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g); // 전체 그려진 컴포넌트를 지움
//
//		g.drawRect(nemo1.x, nemo1.y, nemo1.SIZE, nemo1.SIZE);
//		g.setColor(Color.white);
//		g.drawRect(nemo2.x, nemo2.y, nemo2.SIZE, nemo2.SIZE);
//
//		repaint();
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton target = (JButton) e.getSource();
//		if (target == up) {
//			int temp = this.nemo1.y - 100; // 222
//			this.nemo1.y -= this.MOVE; // 219
//			if (this.nemo2.y <= temp && this.nemo2.y >= this.nemo1.y - 100 && this.nemo2.x > this.nemo1.x - 100
//					&& this.nemo2.x < this.nemo1.x + 100) {
//				this.nemo2.y = this.nemo1.y - 100;
//			}
//		} else if (target == down) {
//			int temp = this.nemo1.y + 100;
//			this.nemo1.y += this.MOVE;
//			if (this.nemo2.y >= temp && this.nemo2.y <= this.nemo1.y + 100 && this.nemo2.x > this.nemo1.x - 100
//					&& this.nemo2.x < this.nemo1.x + 100) {
//				this.nemo2.y = this.nemo1.y + 100;
//			}
//		} else if (target == right) {
//			int temp = this.nemo1.x + 100; // 309
//			this.nemo1.x += this.MOVE; // 312
//			if (this.nemo2.x >= temp && this.nemo2.x <= this.nemo1.x + 100 && this.nemo2.y > this.nemo1.y - 100
//					&& this.nemo2.y < this.nemo1.y + 100) {
//				this.nemo2.x = this.nemo1.x + 100;
//			}
//		} else if (target == left) {
//			int temp = this.nemo1.x - 100; // 310
//			this.nemo1.x -= this.MOVE; // 307
//			if (this.nemo2.x <= temp && this.nemo2.x >= this.nemo1.x - 100 && this.nemo2.y > this.nemo1.y - 100
//					&& this.nemo2.y < this.nemo1.y + 100) {
//				this.nemo2.x = this.nemo1.x - 100;
//			}
//		}
//		System.out.printf("네모1 [%d,%d] 네모2 [%d,%d]\n", this.nemo1.x, this.nemo1.y, this.nemo2.x, this.nemo2.y);
//	}
//
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("Char:"+e.getKeyChar());
//		System.out.println("Code:"+e.getKeyCode());
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//}
//
//class MovingSquare extends JFrame {
//
//	private Map map = new Map();
//
//	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
//	public static final int W = dm.width;
//	public static final int H = dm.height;
//
//	public MovingSquare() {
//		super("Moving Square");
//		setBounds(0, 0, MovingSquare.W, MovingSquare.H);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//		add(map);
//
//		setVisible(true);
//		revalidate();
//	}
//}
//
//public class 움직이는네모 {
//
//	public static void main(String[] args) {
//		MovingSquare ms = new MovingSquare();
//	}
//
//}
