package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

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

	public int getHeight() {
		return height;
	}
}

class ExPanel extends MyUtil {

	private Rect rect = new Rect(100, 100, 100, 100);
	private int gapX, gapY;

	public ExPanel() {
		setBounds(0, 0, 500, 500);
		setBackground(Color.orange);

		addMouseMotionListener(this);
		addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.gapX = e.getX() - this.rect.getX();
		this.gapY = e.getY() - this.rect.getY();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(e.getX() + " : " + e.getY());
		
		int x = e.getX();
		int y = e.getY();
		
		int xx = e.getX() - gapX;
		int yy = e.getY() - gapY;
		
		if(x>=this.rect.getX() && x< this.rect.getX() + this.rect.getWidth() && y>=this.rect.getY() && y< this.rect.getY() + this.rect.getHeight()) {
			this.rect.setX(xx);
			this.rect.setY(yy);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(this.rect.getX(), this.rect.getY(), this.rect.getWidth(), this.rect.getHeight());

		repaint();
	}
}

class ExFrame extends JFrame {
	public ExFrame() {
		super("drag");
		setLayout(null);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new ExPanel());

		setVisible(true);
		revalidate();
	}
}

public class Ex_드래그 {

	public static void main(String[] args) {
		ExFrame frame = new ExFrame();
	}

}
