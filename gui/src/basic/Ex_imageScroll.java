package basic;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex_imageScroll extends JFrame {
	
	JScrollPane js = null;
	
	JTable table = new JTable();
	JLabel image = new JLabel();
//	ExPanel panel = new ExPanel();
	
	public Ex_imageScroll() {
		setLayout(null);
		setBounds(100, 100, 500, 525);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setScrollPane();
		
		setVisible(true);
		revalidate();
	}
	
	private void setScrollPane() {
		// JScrollPane은 스크롤 기능이 있는 레이어라고 보면 됨
		
		// 스크롤페인에 얹을 컴포넌트를 준비 >>
		ImageIcon image = new ImageIcon(new ImageIcon("images/루피.jpg").getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH));
		this.image = new JLabel(image);
		this.image.setBounds(0, 0, 800, 800);
		this.image.setVisible(true);
		
		// 스크롤패인의 설정
		this.js = new JScrollPane(this.image); // 생성자에서 스크롤패인에 담을 컴포넌트를 인자로 넘김
		
//		this.js = new JScrollPane(table);
//		this.js = new JScrollPane(panel);
		
		this.js.setBounds(0, 0, 500, 500);
		this.js.setAutoscrolls(true);
		add(this.js);
	}

	public static void main(String[] args) {
		new Ex_imageScroll();
	}
}