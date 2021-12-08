package basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Nemo {
	boolean click1;
	boolean click2;
	int id;
	int x, y, width, height;

	public Nemo(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

class AlertEnd extends JFrame {

	private JLabel text = new JLabel();

	public AlertEnd(int win) {
		super("GAME CLEAR!");

		setLayout(null);
		setBounds(700 / 2 - 150, 800 / 2 - 100, 300, 200);
		setVisible(true);

		this.text.setBounds(0, 0, 300, 200);
		this.text.setText(String.format("Player%d WIN!!", win));
		this.text.setVerticalAlignment(JLabel.CENTER);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
	}
}

class Board extends JPanel implements MouseListener, ActionListener {

	private final int SIZE = 10;
	private Nemo[][] map = new Nemo[SIZE][SIZE];

	private JButton reset = new JButton();
	private int turn = 1;
	private int win = 0;

//	int xx = 0;

	public Board() {
		setLayout(null);
		setBounds(0, 0, 700, 800);
		setBackground(new Color(244, 164, 66));

		addMouseListener(this); // 패널에 마우스 리스너를 달았음
		setTitle();
		setMap();
		setResetButton();
	}

	private void setTitle() {
		JLabel head = new JLabel(" 오목 게임 ");
		head.setBounds(0, 0, 700, 100);
		head.setFont(new Font("", Font.BOLD, 20));
		head.setHorizontalAlignment(JLabel.CENTER);
		head.setVerticalAlignment(JLabel.CENTER);
		add(head);
	}

	private void setMap() {

		// 그릴 사각형에 대한 정보만 Nemo 배열을 활용해서 세팅
		int x = 700 / 2 - 50 * 10 / 2;
		int y = 700 / 2 - 50 * 10 / 2;

		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				this.map[i][j] = new Nemo(x, y, 50, 50);
				x += 50;
			}
			x = 700 / 2 - 50 * 10 / 2;
			y += 50;
		}
	}

	private void setResetButton() {
		this.reset.setBounds(350 - 150, 650, 300, 50);
		this.reset.setText("RESET");
		this.reset.setForeground(Color.white);

		this.reset.setOpaque(true);
		this.reset.setBorderPainted(false);
		this.reset.setBackground(Color.black);

		this.reset.addActionListener(this);
		add(this.reset);
	}

	@Override
	protected void paintComponent(Graphics g) { // 스레드(혼자 돌고 있음)
		super.paintComponent(g); // 전체 그려진 컴포넌트를 지우는 역할

		// 네모 그리기
		// paintComponent() 메소드가 가진 인자 Graphics를 활용
		// drawRect(x,y,width,heigth) 메소드를 사용
//		g.drawRect(100, 100, 100, 100);

//		// map 그리기
//		for(int i=0; i<this.map.length; i++) {
//			for(int j=0; j<this.map[i].length; j++) {
//				Nemo nemo = this.map[i][j];
//				g.setColor(Color.pink);
//				g.drawRect(nemo.x, nemo.y, nemo.width, nemo.height);
////				g.fillRect(nemo.x, nemo.y, nemo.width, nemo.height);
//			}
//		}
//		for(int i=0; i<this.map.length-1; i++) {
//			for(int j=0; j<this.map[i].length-1; j++) {
//				Nemo nemo = this.map[i][j];
//				g.setColor(Color.black);
//				g.drawRect(nemo.x+25, nemo.y+25, nemo.width, nemo.height);
//				
//				if(i == 3 && j == 4) {
//					g.setColor(Color.black);
////					g.drawRoundRect(nemo.x, nemo.y, nemo.width-20, nemo.height-20,nemo.width, nemo.height);
//					g.fillRoundRect(nemo.x+5, nemo.y+5, nemo.width-10, nemo.height-10,nemo.width, nemo.height);
//				}
//			}
//		}

		// 스레드인지 실험 -> 네모가 움직인다! (repaint();)
//		g.setColor(Color.red);
//		g.drawRect(this.xx, 10, 100, 100);
//		this.xx ++;

		// map line
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				Nemo nemo = this.map[i][j];
				Nemo temp = new Nemo(nemo.x - nemo.width / 2, nemo.y - nemo.height / 2, nemo.width, nemo.height);
				g.setColor(Color.black);
				g.drawRect(temp.x, temp.y, temp.width, temp.height);

				if (i == this.map.length - 1) {
					g.drawRect(temp.x, temp.y + temp.height, temp.width, temp.height);
				}
				if (j == this.map.length - 1) {
					g.drawRect(temp.x + temp.width, temp.y, temp.width, temp.height);
				}
				if (i == this.map.length - 1 && j == this.map.length - 1) {
					g.drawRect(temp.x + temp.width, temp.y + temp.height, temp.width, temp.height);
				}
			}
		}

		// stone
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {

				// 가이드라인
				Nemo nemo = this.map[i][j];
//				g.setColor(Color.pink);
//				g.drawRect(nemo.x, nemo.y, nemo.width, nemo.height);

				// stone
				if (nemo.click1) {
					g.setColor(Color.black);
//					g.drawRoundRect(nemo.x, nemo.y, nemo.width-20, nemo.height-20,nemo.width, nemo.height);
					g.fillRoundRect(nemo.x + 10, nemo.y + 10, nemo.width - 20, nemo.height - 20, nemo.width - 20,
							nemo.height - 20);
				} else if (nemo.click2) {
					g.setColor(Color.white);
//					g.drawRoundRect(nemo.x, nemo.y, nemo.width-20, nemo.height-20,nemo.width, nemo.height);
					g.fillRoundRect(nemo.x + 10, nemo.y + 10, nemo.width - 20, nemo.height - 20, nemo.width - 20,
							nemo.height - 20);
				}
			}
		}
		repaint();
	}

	private void winCheck() {
		System.out.println("winCheck");
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;

		if (this.win != 0) {
			new AlertEnd(this.win);
//			this.map = new Nemo[10][10];
//			this.setMap();
		}
	}

	private int checkHori() {
		System.out.println("가로검사>>");
		for (int i = 0; i < this.SIZE; i++) {
			int check = 0;
			for (int j = 0; j < this.SIZE; j++) {
				if (this.turn == 1) {
					if (this.map[i][j].click1) {
						check++;
					} else {
						check = 0;
					}
				} else if (this.turn == 2) {
					if (this.map[i][j].click2) {
						check++;
					} else {
						check = 0;
					}
				}
				if (check == 5) {
					break;
				}
			}
			if (check == 5) {
				return this.turn;
			}
		}
		return 0;
	}

	private int checkVerti() {
		for (int i = 0; i < this.SIZE; i++) {
			int check = 0;
			for (int j = 0; j < this.SIZE; j++) {
				if (this.turn == 1) {
					if (this.map[j][i].click1) {
						check++;
					} else {
						check = 0;
					}
				} else if (this.turn == 2) {
					if (this.map[j][i].click2) {
						check++;
					} else {
						check = 0;
					}
				}
				if (check == 5) {
					break;
				}
			}
			if (check == 5) {
				return this.turn;
			}
		}
		return 0;
	}

	private int checkDia() {
		for (int i = 0; i <= this.SIZE - 5; i++) {
			for (int j = 0; j <= this.SIZE - 5; j++) {
				if (this.turn == 1) {
					if (this.map[i][j].click1) {
						int check = 0;
						for (int k = 0; k < 5; k++) {
							if (this.map[i + k][j + k].click1) {
								check++;
							}
						}
						if (check == 5) {
							return this.turn;
						}
					}
				} else if (this.turn == 2) {
					if (this.map[i][j].click2) {
						int check = 0;
						for (int k = 0; k < 5; k++) {
							if (this.map[i + k][j + k].click2) {
								check++;
							}
						}
						if (check == 5) {
							return this.turn;
						}
					}

				}
			}
		}
		return 0;
	}

	private int checkReverse() {
		for (int i = 0; i <= this.SIZE - 5; i++) {
			for (int j = 5 - 1; j < this.SIZE; j++) {
				System.out.println(i + "," + j);
				if (this.turn == 1) {
					if (this.map[i][j].click1) {
						int check = 0;
						for (int k = 0; k < 5; k++) {
							if (this.map[i + k][j - k].click1) {
								check++;
							} else {
								check = 0;
							}
						}
						if (check == 5) {
							return this.turn;
						}
					}
				} else if (this.turn == 2) {
					int check = 0;
					for (int k = 0; k < 5; k++) {
						if (this.map[i + k][j - k].click2) {
							check++;
						} else {
							check = 0;
						}
					}
					if (check == 5) {
						return this.turn;
					}
				}
			}
		}
		return 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) { // 클릭 발생 시
		System.out.println("아야!!");

		// 클릭이 발생한 지점의 좌표정보를 얻어옴
		int x = e.getX();
		int y = e.getY();

		// check
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				Nemo stone = this.map[i][j];
				if (this.win == 0 && !stone.click1 && !stone.click2 && x >= stone.x && x < stone.x + stone.width
						&& y >= stone.y && y < stone.y + stone.height) {
					if (this.turn == 1) {
						stone.click1 = true;
					} else if (this.turn == 2) {
						stone.click2 = true;
					}
					winCheck();
					this.turn = this.turn == 1 ? 2 : 1;
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) { // 클-(누르고)
		System.out.println("클-");
	}

	@Override
	public void mouseReleased(MouseEvent e) { // 릭-(떼고)
		System.out.println("릭!");
	}

	@Override
	public void mouseEntered(MouseEvent e) { // listener가 add된 범위 안으로 마우스가 나가는 순간
		System.out.println("hello");
	}

	@Override
	public void mouseExited(MouseEvent e) { // listener가 add된 범위 밖으로 마우스가 나가는 순간
		System.out.println("bye");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		if (target == reset) {
			this.map = new Nemo[10][10];
			this.setMap();
			this.win = 0;
		} else {
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
		}
	}
}

class OmokGame extends JFrame {

	private Board board = new Board();

	public OmokGame() {
		super("Omok Game");
		setBounds(50, 50, 700, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(board);
		setVisible(true);
		revalidate();
	}
}

public class 풀이_오목 {

	public static void main(String[] args) {

		OmokGame og = new OmokGame();

	}

}
