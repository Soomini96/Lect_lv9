package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// 최상위 컨테이너 : JFrame
// 컨테이너 : JPanel
// 컴포넌트 : JButton, JLabel, JtextField...
// 리스너 : 컴포넌트에 리스너를 add 하면, 이벤트(반응) 발생시 -> 캐치 -> 처리

// TicTacToe
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
		this.add(this.text);
	}
}

class Content extends JPanel implements ActionListener {

	private JButton[] map;
	private int[] mark;

	private int turn = 1;
	private int win;
	private boolean printWinner;

	private int cnt = 1;

	private JButton reset = new JButton();

	public Content() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
//		setBackground(Color.black);

		setHeader();
		setMap();
		addResetButton();
	}

	private void addResetButton() {
		this.reset.setBounds(800 / 2 - 300 / 2, 600, 300, 50);
		this.reset.setText("START");
		this.reset.addActionListener(this);
		add(this.reset);
	}

	private void setHeader() {
		JLabel head = new JLabel("TIC TAC TOE");
		head.setBounds(0, 0, 800, 200);
		head.setFont(new Font("", Font.BOLD, 40));
		head.setHorizontalAlignment(JLabel.CENTER);
		head.setVerticalAlignment(JLabel.BOTTOM);
		add(head);
	}

	private void setMap() {
		this.map = new JButton[9];
		this.mark = new int[9];

		int x = 800 / 2 - 300 / 2;
		int y = 800 / 2 - 300 / 2;
		for (int i = 0; i < this.map.length; i++) {
			this.map[i] = new JButton();
			this.map[i].setBounds(x, y, 100, 100);
			this.map[i].setBackground(Color.LIGHT_GRAY);
			this.map[i].addActionListener(this);

			// on Mac
			this.map[i].setOpaque(true);
			this.map[i].setBorderPainted(false);

			add(this.map[i]);
			x += 100 + 1;
			if (i % 3 == 2) {
				x = 800 / 2 - 300 / 2;
				y += 100 + 1;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();

		if (target == this.reset) {
			resetMap();
		} else {
			this.reset.setText("RESET");
			for (int i = 0; i < this.map.length; i++) {
				if (target == this.map[i] && this.mark[i] == 0) {
					if (this.turn == 1) {
						target.setBackground(Color.black);
					} else {
						target.setBackground(Color.orange);
					}
					this.mark[i] = this.turn;
					checkWin();

					this.turn = turn == 1 ? 2 : 1;
				}
			}
		}
	}

	private void resetMap() {
		for (int i = 0; i < this.map.length; i++) {
			this.map[i].setBackground(Color.LIGHT_GRAY);
			this.mark = new int[9];
			this.turn = 1;
			this.win = 0;
			this.reset.setText("START");
			this.printWinner = false;
		}
	}

	private void checkWin() {
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;

		if (this.win != 0 && !this.printWinner) {
			System.out.printf("%d번째 게임 : p%d의 승!\n", this.cnt, this.win);
			this.printWinner = true;
			this.cnt++;
			
			new AlertFrame(String.format("%d번째 게임 : p%d의 승!\n", this.cnt, this.win));
//			alert.text.setText();
//			add(alert); // 안써도 됨
			
			// 간단한 alert
//			JOptionPane.showMessageDialog(null, String.format("%d번째 게임 : p%d의 승!\n", this.cnt, this.win));
			// 내용물의 컴포넌트 구성이 불가능함
		}
	}

	private int checkHori() {
		for (int i = 0; i < this.mark.length; i += 3) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (this.mark[i + j] == this.turn) {
					cnt++;
				}
			}
			if (cnt == 3) {
				return this.turn;
			}
		}
		return 0;
	}

	private int checkVerti() {
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (this.mark[i + j * 3] == this.turn) {
					cnt++;
				}
			}
			if (cnt == 3) {
				return this.turn;
			}
		}
		return 0;
	}

	private int checkDia() {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			if (this.mark[i * 4] == this.turn) {
				cnt++;
			}
		}
		if (cnt == 3) {
			return this.turn;
		}
		return 0;
	}

	private int checkReverse() {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			if (this.mark[(i + 1) * 2] == this.turn) {
				cnt++;
			}
		}
		if (cnt == 3) {
			return this.turn;
		}
		return 0;
	}
}

class Tictactoe extends JFrame {

	private Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public final int W = dm.width;
	public final int H = dm.height;
	public int getW() { // 어떻게 가져가는 거지..?
		return this.W;
	}

	public Tictactoe() { // 기본적인 암기사항
		super("TIC TAC TOE");

		setLayout(null);
		setBounds(W / 2 - 800 / 2, H / 2 - 800 / 2, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setBackground(Color.pink);

		add(new Content());

		setVisible(true);
		revalidate(); // 갱신
	}
}

public class 풀이_틱택토 {
	public static void main(String[] args) {
		Tictactoe ttt = new Tictactoe();
	}
}
