package drawingBoard;

import java.awt.Color;
import java.util.ArrayList;

public class Rect {
	private Color myColor;

	public Color getColor() {
		return this.myColor;
	}

	public void setColor(Color color) {
		this.myColor = color;
	}

	private int x, y, width, height;
	private int shape; // 1네모 2세모 3동그라미 4직선

	// line 을 선택했을떄
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

	public ArrayList<Integer> getXX() {
		return this.xx;
	}

	public ArrayList<Integer> getYY() {
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
