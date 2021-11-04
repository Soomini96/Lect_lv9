package drawingBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

class Rect {
	private int x, y, width, height;

	public Rect(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}

public class Board extends MyUtil {

//	private Rect rect;
	private ArrayList<Rect> rects = new ArrayList<>();
	private boolean click = false;
	private boolean square = false;

	private int startX, startY;
	private int pointX, pointY;

	public JButton close = new JButton();
	private JLabel shift = new JLabel();

	public Board() {
		setLayout(null);
		setBounds(0, 0, DrawingBoard.SIZE, DrawingBoard.SIZE);
		setBackground(Color.pink);

		setResetButton();

		addMouseListener(this);
		addMouseMotionListener(this);

		setFocusable(true);
		addKeyListener(this);
	}

	private void setShiftLabel() {
		this.shift.setBounds(DrawingBoard.SIZE - 100, DrawingBoard.SIZE - 180, 100, 50);
		this.shift.setText("SHIFT KEY");

		add(this.shift);
	}

	private void setResetButton() {
		this.close.setBounds(DrawingBoard.SIZE - 100, DrawingBoard.SIZE - 130, 70, 70);
		this.close.setText("CLOSE");
		this.close.addActionListener(this);

		add(this.close);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);

		if (this.click) {
			for(int i=0; i<this.rects.size(); i++) {
				g.drawRect(this.rects.get(i).getX(), this.rects.get(i).getY(), this.rects.get(i).getWidth(), this.rects.get(i).getHeight());
			}
		}
		requestFocusInWindow(); // keyListener에 대한 포커스 다시 요청
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("PRESS");
		this.startX = e.getX();
		this.startY = e.getY();
		Rect newRect = new Rect(this.startX, this.startY, 0, 0);
		this.rects.add(newRect);
		this.click = true;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("DRAG");

		int garo = e.getX() - this.startX;
		int sero = e.getY() - this.startY;

		if (garo > 0 && sero > 0) {
			this.pointX = this.startX;
			this.pointY = this.startY;
		} else if (garo > 0 && sero < 0) {
			sero = sero * (-1);
			this.pointX = this.startX;
			this.pointY = this.startY - sero;
		} else if (garo < 0 && sero > 0) {
			garo = garo * (-1);
			this.pointX = this.startX - garo;
			this.pointY = this.startY;
		} else if (garo < 0 && sero < 0) {
			garo = garo * (-1);
			sero = sero * (-1);
			this.pointX = e.getX();
			this.pointY = e.getY();
		}

		this.rects.get(this.rects.size()-1).setX(this.pointX);
		this.rects.get(this.rects.size()-1).setY(this.pointY);
		this.rects.get(this.rects.size()-1).setWidth(garo);
		this.rects.get(this.rects.size()-1).setHeight(sero);

		if (this.square) {
			if (garo > sero) {
				this.rects.get(this.rects.size()-1).setHeight(garo);
			} else {
				this.rects.get(this.rects.size()-1).setWidth(sero);
			}
		}

		System.out.println(garo + ":" + sero);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("마우스를 떼었다");
//		this.click = false; // 그린 뒤 바로 사라지게 됨
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		if (e.isShiftDown() == true) {
			System.out.println("SHIFT!!");
			this.square = true;
			setShiftLabel();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.square = false;
		delShiftLabel();
	}

	private void delShiftLabel() {
		this.shift.setText("");
	}
}
