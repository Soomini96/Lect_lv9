package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import models.Block;
import models.MyUtil;

class Alert extends JFrame {
	private int width = 200;
	private int height = 150;

	private JLabel gameClear = new JLabel("GAME CLEAR!");

	public Alert() {
		setLayout(null);
		setBounds((Sokoban.W - this.width) / 2, (Sokoban.H - this.height) / 2, this.width, this.height);
		this.gameClear.setBounds(20, 15, 200, 100);
		this.gameClear.setForeground(Color.gray);
		this.gameClear.setFont(new Font("Arial Black", Font.BOLD, 20));
		add(this.gameClear);

		setVisible(true);
	}
}

public class Board extends MyUtil {

	private JLabel title = new JLabel("SOKOBAN");
	private JButton reset = new JButton("RESET");
	private JLabel leftItem = new JLabel();

	private final int SIZE = 8;
	private Block b[][] = new Block[SIZE + 1][SIZE];

	private final int GROUND = 1;
	private final int WALL = 2;
	private final int PLAYER = 3;
	private final int BOX = 4;
	private final int GOAL = 5;
	private final int OKBOX = 6;

	private int x = 2;
	private int y = 2;

	public Board() {
		setLayout(null);
		setBackground(Color.gray);
		setBounds(0, 0, Sokoban.WIDTH, Sokoban.HEIGHT);

		setMap();

		setFocusable(true);
		addKeyListener(this);
	}

	private void setMap() {
		setLabel();
		setButton();

		setBlock();
	}

	private void setBlock() {
		this.b = new Block[SIZE + 1][SIZE];
		this.x = 2;
		this.y = 2;

		// 랜덤? 그림대로?
		int xx = 100;
		int yy = 100;

		for (int i = 0; i < this.b.length; i++) {
			for (int j = 0; j < this.b[i].length; j++) {
				this.b[i][j] = new Block(this.GROUND, xx, yy, 50, 50);
				xx += 50;
			}
			xx = 100;
			yy += 50;
		}
		for (int i = 0; i < 5; i++) {
			b[0][i + 2].setState(this.WALL);
			b[i + 1][6].setState(this.WALL);
			if (i < 2) {
				b[1][i + 1].setState(this.WALL);
			}
			if (i < 3) {
				b[i + 5][7].setState(this.WALL);
			}
		}
		for (int i = 0; i < this.b[8].length; i++) {
			b[8][i].setState(this.WALL);
		}
		for (int i = 1; i < this.b.length; i++) {
			b[i][0].setState(this.WALL);
		}
		b[3][1].setState(this.WALL);
		b[3][2].setState(this.WALL);
		b[4][2].setState(this.WALL);
		b[4][3].setState(this.WALL);
		b[5][2].setState(this.WALL);

		// goal
		b[2][1].setState(this.GOAL);
		b[3][5].setState(this.GOAL);
		b[4][1].setState(this.GOAL);
		b[5][4].setState(this.GOAL);
		b[6][6].setState(this.GOAL);
		b[7][4].setState(this.GOAL);
		b[6][3].setState(this.GOAL);

		// box
		b[2][3].setState(this.BOX);
		b[3][4].setState(this.BOX);
		b[4][4].setState(this.BOX);
		b[6][1].setState(this.BOX);
		b[6][4].setState(this.BOX);
		b[6][5].setState(this.BOX);
		b[6][3].setState(this.BOX);

		// player
		b[this.y][this.x].setState(this.PLAYER);
	}

	private void setButton() {
		this.reset.setBounds((Sokoban.WIDTH - 60) / 2, Sokoban.HEIGHT - 85, 60, 40);
		this.reset.addActionListener(this);
		add(this.reset);
	}

	private void setLabel() {
		this.title.setFont(new Font("", Font.BOLD, 30));
		this.title.setBounds(0, 0, Sokoban.WIDTH, 100);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.CENTER);
		add(this.title);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < this.b.length; i++) {
			for (int j = 0; j < this.b[i].length; j++) {
				Block b = this.b[i][j];
				g.drawImage(b.getImage().getImage(), b.getX(), b.getY(), null);
			}
		}

		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		if (target == this.reset) {
			setMap();
		}
	}

	// keyPressed와 keyTyped의 차이는 무엇일까?
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		System.out.println("keyPress:" + e.getKeyChar());

		int xx = this.x;
		int yy = this.y;
		int bx = this.x;
		int by = this.y;

		if (e.getKeyCode() == e.VK_UP || e.getKeyCode() == e.VK_W) {
			yy--;
			by -= 2;
		} else if (e.getKeyCode() == e.VK_DOWN || e.getKeyCode() == e.VK_S) {
			yy++;
			by += 2;
		} else if (e.getKeyCode() == e.VK_LEFT || e.getKeyCode() == e.VK_A) {
			xx--;
			bx -= 2;
		} else if (e.getKeyCode() == e.VK_RIGHT || e.getKeyCode() == e.VK_D) {
			xx++;
			bx += 2;
		}

		if (this.b[yy][xx].getState() == this.GROUND || this.b[yy][xx].getState() == this.GOAL) {
			if (this.b[y][x].getGoal()) {
				this.b[y][x].setState(this.GOAL);
			} else {
				this.b[y][x].setState(this.GROUND);
			}
			this.x = xx;
			this.y = yy;
			this.b[y][x].setState(this.PLAYER);
		} else if (this.b[yy][xx].getState() == this.BOX || this.b[yy][xx].getState() == this.OKBOX) {
			if (this.b[by][bx].getState() == this.GROUND || this.b[by][bx].getState() == this.GOAL) {
				if (this.b[y][x].getGoal()) { // 원래 자리 goal?
					this.b[y][x].setState(this.GOAL);
				} else {
					this.b[y][x].setState(this.GROUND);
				}
				this.x = xx;
				this.y = yy;
				this.b[y][x].setState(this.PLAYER);
				this.b[by][bx].setState(this.BOX);
			}
		}
		winCheck();
	}

	private void winCheck() {
		int check = 0;
		for (int i = 0; i < this.b.length; i++) {
			for (int j = 0; j < this.b[i].length; j++) {
				if (this.b[i][j].getState() == this.BOX) {
					check++;
				}
			}
		}
		if (check == 0) {
			System.out.println("Game Clear!");
			new Alert();
		}
	}
}
