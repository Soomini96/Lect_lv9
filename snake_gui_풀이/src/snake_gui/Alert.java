package snake_gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Alert extends JFrame {
	
	private JLabel text = new JLabel();
	
	// 300 * 200
	public Alert() {
		super("Game Clear");
		setBounds(SnakeGame.WIDTH/2-150, SnakeGame.HEIGHT/2-100, 300,200);
		
		text.setBounds(0, 0, 300, 200);
		text.setText("!!!몸에 부딪혀 사망!!!");
		text.setFont(new Font("",Font.BOLD,20));
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		setVisible(true);
		revalidate();
	}
}
