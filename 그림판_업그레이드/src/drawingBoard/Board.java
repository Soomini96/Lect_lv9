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
	private int shape; // 1네모 2세모 3동그라미 4직선
	
	private ArrayList<Integer> xx = new ArrayList<>();
	private ArrayList<Integer> yy = new ArrayList<>();

	public Rect(int x, int y, int width, int height, int shape) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shape = shape;
	}
	public void drawLine(int x, int y) {
		this.xx.add(x);
		this.yy.add(y);
	}

	public ArrayList<Integer> getXX(){
		return this.xx;
	}
	public ArrayList<Integer> getYY(){
		return this.yy;
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

	private ArrayList<Rect> rects = new ArrayList<>();
	private boolean square = false; // 정*각형
	private int shape = 1; // 1네모 2세모 3동그라미

	private int startX, startY;
	private int pointX, pointY;

	public JButton close = new JButton();
	public JButton reset = new JButton();
	private JLabel shift = new JLabel();

	private JButton[] shapes = new JButton[4];

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
		if(target == this.reset) {
			System.out.println("RESET!!");
			this.rects = new ArrayList<>();
			this.shape = 1;
		} else {
			for (int i = 0; i < this.shapes.length; i++) {
				if (target == this.shapes[i]) {
					this.shape = i + 1;
					System.out.println("모양이 " + (i + 1) + "로 변경됨.");
				}
			}
		}
	}

	private void setShiftLabel() {
		this.shift.setBounds(DrawingBoard.SIZE - 100, DrawingBoard.SIZE - 200, 100, 50);
		this.shift.setText("SHIFT KEY");

		add(this.shift);
	}

	private void setButton() {
		// close 버튼
		this.close.setBounds(DrawingBoard.SIZE - 100, DrawingBoard.SIZE - 100, 70, 50);
		this.close.setText("CLOSE");
		this.close.addActionListener(this);
		
		// reset 버튼
		this.reset.setBounds(DrawingBoard.SIZE - 170, DrawingBoard.SIZE - 100, 70, 50);
		this.reset.setText("RESET");
		this.reset.addActionListener(this);

		add(this.close);
		add(this.reset);

		// 그리기 버튼
		int x = 10;
		int y = 10;

		String shape[] = { "◼︎", "▲", "●" ,"✎"};

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
			int shape = this.rects.get(i).getShape();

			// 네모 그리기
			if ( shape == 1) {
				g.drawRect(this.rects.get(i).getX(), this.rects.get(i).getY(), this.rects.get(i).getWidth(),
						this.rects.get(i).getHeight());
			}

			// 세모 그리기
			else if (shape == 2) {
				
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
			else if (shape == 3) {
				g.drawRoundRect(this.rects.get(i).getX(), this.rects.get(i).getY(), this.rects.get(i).getWidth(),
						this.rects.get(i).getHeight(), this.rects.get(i).getWidth(), this.rects.get(i).getHeight());
			}
			
			// 선 그리기
			else if(shape == 4) {
				ArrayList<Integer> xx = this.rects.get(i).getXX();
				ArrayList<Integer> yy = this.rects.get(i).getYY();
				
				int[] x = new int[xx.size()];
				int[] y = new int[yy.size()];
				
				for(int j=0; j<xx.size(); j++) {
					x[j] = xx.get(j);
					y[j] = yy.get(j);
				}
				
				g.drawPolyline(x, y, x.length);
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
		System.out.println("DRAG");

		int lastShapeIdx = this.rects.size()-1;
		int shape = this.rects.get(lastShapeIdx).getShape();
		
		// 직선일때 예외 처리
		if (shape == 4) {
			this.rects.get(lastShapeIdx).drawLine(e.getX(), e.getY());
		}
		// 삼각형일때 예외 처리
		else if (shape == 2) {
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
					this.rects.get(lastShapeIdx).setHeight(garo);
				} else {
					this.rects.get(lastShapeIdx).setWidth(sero);
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
		this.shift.setText("");
	}
}
