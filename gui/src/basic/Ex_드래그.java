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
	private boolean ok = false;

	public ExPanel() {
		setBounds(0, 0, 500, 500);
		setBackground(Color.orange);

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		super.mouseClicked(e);
		if (e.getX() >= this.rect.getX() && e.getX() <= this.rect.getX() + this.rect.getWidth()
				&& e.getY() >= this.rect.getY() && e.getY() <= this.rect.getY() + this.rect.getHeight()) {
			this.ok = true;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (ok) {
//		super.mouseDragged(e);
			System.out.println(e.getX() + " : " + e.getY());
			this.rect.setX(e.getX());
			this.rect.setY(e.getY());
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
//		super.mouseMoved(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		super.mouseReleased(e);
		this.ok = false;
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
