package basic;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ExPanel extends MyUtil{
	
	private JLabel label = new JLabel();
	private JLabel image = new JLabel();
	
	public ExPanel() {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		label.setBounds(0, 0, 500, 500);
		label.setText("test");
		add(label); // 컨테이너 위에 add()메소드를 통해 -> 컴포넌트 추가 : 인덱스가 붙음 (추가하는 순서대로)
		
		image.setBounds(0, 0, 500, 500);
		image.setIcon(new ImageIcon("images/루피.jpg"));
		image.setVisible(true);
		add(image); // 0 <- 인덱스의 우선순위 변경하기
	}
}
class ExFrame extends JFrame{
	public ExFrame() {
		super("경마");
		setLayout(null);
		setBounds(100, 100, 500, 500);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new ExPanel());
		
		setVisible(true);
		revalidate();
	}
}
public class Ex_그림붙이기 {

	public static void main(String[] args) {
		ExFrame ef = new ExFrame();
	}

}
