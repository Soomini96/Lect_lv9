//package basic;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//class Tic{
//	int turn = 1; // 1 or 2
//	
//	int map[] = new int[9];
//	
//}
//
//class HeadTitle extends JLabel {
//	String title = "TicTacToe";
//
//	public HeadTitle() {
//		setBounds(0, 0, 600, 100);
//		setText(title);
//		setFont(new Font(title, Font.BOLD, 30));
//		setHorizontalAlignment(CENTER);
//		setVisible(true);
//	}
//}
//
//class StartButton extends JButton {
//	
//	JButton bt = new JButton("Start");
//	
//	public StartButton() {
//		setLayout(null);
//		setBounds(0,0,600,800);
//		setVisible(true);
//		
//		this.bt.setBounds(0,0,50,50);
////		this.bt.setBounds(400, 600, 100, 50);
//		this.bt.setVisible(true);
//		add(this.bt);
//	}
//}
//
//class MyPanel extends JButton implements ActionListener {
////class MyPanel extends JPanel {
////	JButton bt = new JButton();
//
////	public MyPanel() {
////		setLayout(null);
////		setBounds(0,0,400,400);
////		setVisible(true);
////		
////		this.bt.setBounds(50, 50, 50, 50);
////		this.bt.setVisible(true);
////		add(this.bt);
////	}
//	final int SIZE = 50;
//	JButton map[] = new JButton[9];
//
//	Tic t = new Tic();
//	
//	public MyPanel() {
//		int garo = 250;
//		int sero = 250;
//		for (int i = 0; i < this.map.length; i++) {
//			this.map[i] = new JButton();
//			setLayout(null);
//			setBounds(0, 0, 600, 800);
//			setVisible(true);
//			
//			this.map[i].setBounds(garo, sero, SIZE, SIZE);
//			
//			// mac os
//			this.map[i].setOpaque(true);
//			this.map[i].setBorderPainted(false);
//			this.map[i].addActionListener(this);
//			
//			this.map[i].setVisible(true);
//			add(this.map[i]);
//			
//
//			if (i % 3 == 2) {
//				garo = 250;
//				sero += SIZE + 1;
//			} else {
//				garo += SIZE + 1;
//			}
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton temp = (JButton) e.getSource();
//		for (int i = 0; i < this.map.length; i++) {
//			if (this.map[i] == temp) {
//				if(t.turn == 1) {
//					temp.setBackground(Color.BLACK);
//					t.turn = 2;
//				}
//				else if(t.turn == 2) {
//					temp.setBackground(Color.ORANGE);
//					t.turn = 1;
//				}
//			}
//		}
//	}
//}
//
//class MyBackground extends JPanel {
//	public MyBackground() {
//		setLayout(null);
//		setBounds(0, 0, 600, 800);
//		setBackground(Color.gray);
//	}
//}
//
//class MyFrame extends JFrame {
//	private Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
//	int width = dm.width;
//	int height = dm.height;
//
//	private final int W = 600;
//	private final int H = 800;
//
//	public MyFrame() {
//		super("TicTacToe");
//		setLayout(null);
//		setBounds(this.width / 2 - W / 2, this.height / 2 - H / 2, W, H);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//
//		add(new HeadTitle());
//		add(new MyBackground());
//		add(new MyPanel());
//		add(new StartButton());
//	}
//
//	public int getWidth() {
//		return this.width;
//	}
//
//	public int getHeight() {
//		return this.height;
//	}
//}
//
//public class TicTacToe {
//
//	public static void main(String[] args) {
//		MyFrame frame = new MyFrame();
//	}
//}
