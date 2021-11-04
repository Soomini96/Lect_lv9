package drawingBoard;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class DrawingBoard extends JFrame implements ActionListener{

	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int WIDTH = dm.width;
	public static int HEIGHT = dm.height;

	public static final int SIZE = 700;
	
	private Board b = new Board();

	public DrawingBoard() {
		super("Drawing Board");
		setLayout(null);
		setBounds((WIDTH - SIZE) / 2, (HEIGHT - SIZE) / 2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		b.close.addActionListener(this);
		add(this.b);

		setVisible(true);
		revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b.close) {
			this.dispose();
		}
	}
}
