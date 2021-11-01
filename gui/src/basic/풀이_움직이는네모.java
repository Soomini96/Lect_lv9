package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyUtil extends JPanel implements ActionListener, MouseListener, KeyListener, MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

class Rect {
	private int x, y, widht, height;

	public Rect(int x, int y, int widht, int height) {
		this.x = x;
		this.y = y;
		this.widht = widht;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidht() {
		return widht;
	}

	public int getHeight() {
		return height;
	}
}

class PushPanel extends MyUtil { // 안쓰는 유틸 지울 수 있음

	private int dir; // 0 정지 1왼 2하 3오 4상

	// 사각형이 두개
	private final int SIZE = 100;
	private Rect r1 = null;
	private Rect r2 = null;

	// 방향키
	private JButton[] btn = new JButton[4];

	public PushPanel() {
		setLayout(null);
		setBounds(0, 0, 700, 700);

		setRect();
		setBtn();
	}

	private void setRect() {
		Random rn = new Random();

		int x = rn.nextInt(700 - 100);
		int y = rn.nextInt(700 - 100);

		this.r1 = new Rect(x, y, SIZE, SIZE);

		while (true) {
			x = rn.nextInt(700 - 100 - 200) + 100;
			y = rn.nextInt(700 - 100 - 200) + 100;

			if((x>=this.r1.getX() && x<this.r1.getX() + this.SIZE && y>= this.r1.getY() && y<this.r1.getY() + this.SIZE) ||
					(x+this.SIZE >= this.r1.getX() && x + this.SIZE < this.r1.getX() + this.SIZE && y+this.SIZE >= this.r1.getY() && y + this.SIZE < this.r1.getY() + this.SIZE )) {
				continue;
			}
			
			
			break;
		}
		this.r2 = new Rect(x, y, SIZE, SIZE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		update();

		// r1, r2
		g.setColor(Color.black);
		g.drawRect(this.r1.getX(), this.r1.getY(), this.r1.getWidht(), this.r1.getHeight());
		g.setColor(Color.blue);
		g.drawRect(this.r2.getX(), this.r2.getY(), this.r2.getWidht(), this.r2.getHeight());

		repaint();
	}

	private void update() {
		// 왼
		if (this.dir == 1 && this.r1.getX()>0) {
			this.r1.setX(this.r1.getX() -1);
		}
		// 하
		else if (this.dir == 2 && this.r1.getY()+SIZE<700) {
			this.r1.setY(this.r1.getY() +1);
		}
		// 오
		else if (this.dir == 3 && this.r1.getX()+SIZE<700) {
			this.r1.setX(this.r1.getX() +1);
		}
		// 상
		else if (this.dir == 4 && this.r1.getY()>0) {
			this.r1.setY(this.r1.getY() -1);
		}
		
		checkAnother();
	}

	private void checkAnother() {
		if (this.dir == 1) {
			if(this.r2.getX() + SIZE == this.r1.getX()) {
				this.r2.setX(this.r2.getX()-1);
			}
		} else if (this.dir == 2) {
		} else if (this.dir == 3) {
		} else if (this.dir == 4) {
		}
	}

	private void setBtn() {
		String text[] = { "◁", "▽", "▷", "△" };

		int size = 50;
		int x = 700 - 200;
		int y = 700 - 100;
		for (int i = 0; i < this.btn.length; i++) {
			this.btn[i] = new JButton();
			this.btn[i].setBounds(x, y, size, size);
			this.btn[i].setText(text[i]);
			this.btn[i].addMouseListener(this);
			add(this.btn[i]);

			x += size;
			if (i == this.btn.length - 1 - 1) {
				x = 700 - 200 + size;
				y -= size;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == this.btn[0]) {
			System.out.println("왼");
			this.dir = 1;
		} else if (e.getSource() == this.btn[1]) {
			this.dir = 2;

		} else if (e.getSource() == this.btn[2]) {
			this.dir = 3;

		} else if (e.getSource() == this.btn[3]) {
			this.dir = 4;

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.dir = 0;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

class PushFrame extends JFrame {
	private PushPanel panel = new PushPanel();

	public PushFrame() {
		super("Push Push");
		setLayout(null);
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(this.panel);
		setVisible(true);
		revalidate();
	}
}

public class 풀이_움직이는네모 {

	public static void main(String[] args) {
		PushFrame game = new PushFrame();
	}

}
