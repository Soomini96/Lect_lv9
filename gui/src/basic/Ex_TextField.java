package basic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex_TextField extends JFrame implements KeyListener{
	
	JLabel dataField = new JLabel(String.format("<html>%s<br>%d</html>","test",123));
	
	JTextField text = new JTextField();
	JTextArea text2 = new JTextArea();

	public Ex_TextField() {
		setLayout(null);
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 텍스트 박스의 처리
		// JTextField : 한줄짜리 간단한 텍스트
		this.text.setBounds(20, 40, 300, 50);
		this.text.addKeyListener(this);
		add(this.text);
		
		// JTextArea : 게시판의 많은 글 쓰는 용
		this.text2.setBounds(20, 100, 300, 50);
		add(this.text2);
		
		this.dataField.setBounds(0, 0, 100, 100);
		add(this.dataField);
		
		setFocusable(true);
		addKeyListener(this);
		
		setVisible(true);
		revalidate();
		
	}

	public static void main(String[] args) {
		new Ex_TextField();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("press");
		if(e.getKeyCode() == e.VK_ENTER) {
			System.out.println(this.text.getText());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
