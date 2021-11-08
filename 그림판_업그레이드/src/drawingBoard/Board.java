package drawingBoard;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

// 가독성 좋게 만들어보자!
public class Board extends MyUtil {

	private ArrayList<Rect> rects = new ArrayList<>();

	private int startX, startY;
	private int pointX, pointY;

	private boolean square = false; // 정*각형
	private int shape = 1; // 1네모 2세모 3동그라미 4붓
	private final int RECTANGLE = 1;
	private final int TRIANGLE = 2;
	private final int CIRCLE = 3;
	private final int BRUSH = 4;

	private JButton[] shapes = new JButton[4];
	public JButton close = new JButton();
	public JButton reset = new JButton();
	private JLabel shift = new JLabel();

	private Color colors[] = { new Color(213, 64, 98), new Color(255, 163, 108), new Color(235, 220, 135), new Color(121, 147, 81), new Color(98, 111, 230), new Color(109, 66, 199),
			Color.black };
	private Color tempColor = Color.black;
	private JButton colorButton[] = new JButton[colors.length];

	public Board() {
		setLayout(null);
		setBounds(0, 0, DrawingBoard.SIZE, DrawingBoard.SIZE);
//		setBackground(Color.white); 

		setButton();

		addMouseListener(this);
		addMouseMotionListener(this);

		setFocusable(true);
		addKeyListener(this);
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
		
		String shape[] = { "◼︎", "▲", "●", "✎" };
		
		for (int i = 0; i < this.shapes.length; i++) {
			this.shapes[i] = new JButton();
			this.shapes[i].setBounds(x, y, 50, 50);
			this.shapes[i].setText(shape[i]);
			this.shapes[i].addActionListener(this);
			
			add(this.shapes[i]);
			y += 50;
		}
		
		x += 5;
		for (int i = 0; i < this.colorButton.length; i++) {
			this.colorButton[i] = new JButton();
			this.colorButton[i].setBounds(x, y, 40, 40);
			
			// 배경 색 칠하기
			this.colorButton[i].setOpaque(true);
			this.colorButton[i].setBorderPainted(false);
			this.colorButton[i].setBackground(this.colors[i]);
			
			this.colorButton[i].addActionListener(this);
			add(this.colorButton[i]);
			y += 40;
		}
	}
	
	private void setShiftLabel() {
		this.shift.setBounds(DrawingBoard.SIZE - 100, DrawingBoard.SIZE - 150, 100, 50);
		this.shift.setText("SHIFT KEY");

		add(this.shift);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < this.rects.size(); i++) {
			
			// 그릴 대상
			Rect target = this.rects.get(i);
			
			int xx = target.getX();
			int yy = target.getY();
			int width = target.getWidth();
			int height = target.getHeight();
			
			int shape = target.getShape();
			
			g.setColor(target.getColor());
			
			// 네모 그리기
			if (shape == this.RECTANGLE) {
				g.drawRect(xx,yy,width, height);
			}
			
			// 세모 그리기
			else if (shape == this.TRIANGLE) {
				
				// 삼각형 그리기
				// Graphics.drawPolygon(int[], int[], int)
				// ㄴ first int[] is the set of x values,
				// ㄴ the second int[] is the set of y values,
				// ㄴ and the int is the length of the array. (In a triangle's case, the int is
				// going to be 3)
				
				// 삼각형의 세 꼭지점의 좌표
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
			else if (shape == this.CIRCLE) {
				g.drawRoundRect(xx,yy,width, height,width, height);
			}
			
			// 선 그리기
			else if (shape == this.BRUSH) {
				ArrayList<Integer> x = target.getXX();
				ArrayList<Integer> y = target.getYY();
				
				int[] xData = new int[x.size()];
				int[] yData = new int[y.size()];
				
				for (int j = 0; j < x.size(); j++) {
					xData[j] = x.get(j);
					yData[j] = y.get(j);
				}
				
				g.drawPolyline(xData, yData, xData.length);
			}
		}
		requestFocusInWindow(); // keyListener에 대한 포커스 다시 요청
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		// 리셋 버튼 눌렀을때
		if (target == this.reset) {
			System.out.println("RESET!!");
			this.rects = new ArrayList<>();
			this.shape = 1;
			this.square = false;
		}

		// 다른 버튼을 눌렀을때
		else {
			for (int i = 0; i < this.shapes.length; i++) {
				if (target == this.shapes[i]) {
					this.shape = i + 1;
					System.out.println("모양이 " + (i + 1) + "로 변경됨.");
				}
			}
			for (int i = 0; i < this.colorButton.length; i++) {
				if (target == this.colorButton[i]) {
					this.tempColor = this.colors[i];
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("PRESS");
		this.startX = e.getX();
		this.startY = e.getY();
		
		Rect newRect = new Rect(this.startX, this.startY, 0, 0, this.shape);
		this.rects.add(newRect);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("DRAG");

		int lastShapeIdx = this.rects.size() - 1;
		Rect target = this.rects.get(lastShapeIdx);
		
		int shape = target.getShape();
		target.setColor(this.tempColor);

		// 직선일때 예외 처리
		if (shape == this.BRUSH) {
			target.drawLine(e.getX(), e.getY());
		}
		// 삼각형일때 예외 처리
		else if (shape == this.TRIANGLE) {
			int width = this.startX - e.getX();
			int height = this.startY - e.getY();

			if (this.square) {
				height = width;
			}
			target.setWidth(width);
			target.setHeight(height);
		}

		// 사각형, 원
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
			
			if (this.square) {
				garo = sero;
			}

			target.setX(this.pointX);
			target.setY(this.pointY);
			target.setWidth(garo);
			target.setHeight(sero);
		}
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
