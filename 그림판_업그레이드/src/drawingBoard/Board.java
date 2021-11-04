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
	private int shape; // 1네모 2세모 3동그라미

	public Rect(int x, int y, int width, int height, int shape) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shape = shape;
	}

	public int getShape() {
		return this.shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
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
//	private boolean click = false;
	private boolean square = false;
	private int shape = 1; // 1네모 2세모 3동그라미

	private int startX, startY;
	private int pointX, pointY;

	public JButton close = new JButton();
	private JLabel shift = new JLabel();

	private JButton[] shapes = new JButton[3];

	public Board() {
		setLayout(null);
		setBounds(0, 0, DrawingBoard.SIZE, DrawingBoard.SIZE);
		setBackground(Color.pink);

		setButton();

		addMouseListener(this);
		addMouseMotionListener(this);

		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < this.shapes.length; i++) {
			if (target == this.shapes[i]) {
				this.shape = i + 1;
				System.out.println("모양이 " + (i + 1) + "로 변경됨.");
			}
		}
	}

	private void setShiftLabel() {
		this.shift.setBounds(DrawingBoard.SIZE - 200, DrawingBoard.SIZE - 100, 100, 50);
		this.shift.setText("SHIFT KEY");

		add(this.shift);
	}

	private void setButton() {
		this.close.setBounds(DrawingBoard.SIZE - 100, DrawingBoard.SIZE - 130, 70, 70);
		this.close.setText("CLOSE");
		this.close.addActionListener(this);

		add(this.close);

		int x = 620;
		int y = 420;

		String shape[] = { "◼︎", "▲", "●" };

		for (int i = 0; i < this.shapes.length; i++) {
			this.shapes[i] = new JButton();
			this.shapes[i].setBounds(x, y, 50, 50);
			this.shapes[i].setText(shape[i]);
			this.shapes[i].addActionListener(this);

			add(this.shapes[i]);

			y += 50;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);

		for (int i = 0; i < this.rects.size(); i++) {

			// 네모 그리기
			if (this.rects.get(i).getShape() == 1) {
				g.drawRect(this.rects.get(i).getX(), this.rects.get(i).getY(), this.rects.get(i).getWidth(),
						this.rects.get(i).getHeight());
			}

			// 세모 그리기
			else if (this.rects.get(i).getShape() == 2) {
				// 삼각형 그리기
				// Graphics.drawPolygon(int[], int[], int)
				// ㄴ first int[] is the set of x values,
				// ㄴ the second int[] is the set of y values,
				// ㄴ and the int is the length of the array. (In a triangle's case, the int is
				// going to be 3)

				int xx = this.rects.get(i).getX();
				int yy = this.rects.get(i).getY();
				int width = this.rects.get(i).getWidth();
				int height = this.rects.get(i).getHeight();

				int[] x = new int[3];
				int[] y = new int[3];

				x[0] = xx;
				y[0] = yy;

				x[1] = xx - (width / 2);
				y[1] = yy - height;

				x[2] = xx + (width / 2);
				y[2] = yy - height;

				g.drawPolygon(x, y, 3);

			}
			// 동그라미 그리기
			else if (this.rects.get(i).getShape() == 3) {
				g.drawRoundRect(this.rects.get(i).getX(), this.rects.get(i).getY(), this.rects.get(i).getWidth(),
						this.rects.get(i).getHeight(), this.rects.get(i).getWidth(), this.rects.get(i).getHeight());
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
		Rect newRect = new Rect(this.startX, this.startY, 0, 0, this.shape);
		this.rects.add(newRect);
//		this.click = true;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for (int i = 0; i < this.rects.size(); i++) {
			if (this.rects.get(i).getShape() == 2) {
				System.out.println("x: " + this.rects.get(i).getX() + ","
						+ (this.rects.get(i).getX() + this.rects.get(i).getWidth()) + ","
						+ (this.rects.get(i).getX() - this.rects.get(i).getWidth()));
				System.out.println("y: " + this.rects.get(i).getY() + ","
						+ (this.rects.get(i).getY() + this.rects.get(i).getHeight()) + ","
						+ (this.rects.get(i).getY() - this.rects.get(i).getHeight()));
			}
		}
		System.out.println("DRAG");

		int lastShapeIdx = this.rects.size() - 1;

		// 삼각형일때 예외 처리
		if (this.rects.get(lastShapeIdx).getShape() == 2) {
			int width = this.startX - e.getX();
			int height = this.startY - e.getY();

			if (this.square) {
				height = width;
			}
			this.rects.get(lastShapeIdx).setWidth(width);
			this.rects.get(lastShapeIdx).setHeight(height);
		}

		// 나머지 도형
		else {
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

			this.rects.get(lastShapeIdx).setX(this.pointX);
			this.rects.get(lastShapeIdx).setY(this.pointY);
			this.rects.get(lastShapeIdx).setWidth(garo);
			this.rects.get(lastShapeIdx).setHeight(sero);

			if (this.square) {
				if (garo > sero) {
					this.rects.get(this.rects.size() - 1).setHeight(garo);
				} else {
					this.rects.get(this.rects.size() - 1).setWidth(sero);
				}
			}

			System.out.println(garo + ":" + sero);
		}
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
