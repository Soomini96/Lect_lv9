package controller;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import 경마.Horse;
import 경마.HorseGame;
import 경마.MyUtil;

public class Board extends MyUtil implements Runnable{
	
	private Random random = new Random();
	
	private int ms;
	private boolean isRun;
	private JLabel timer = new JLabel("ready");
	
	private JButton reset = new JButton("start");
	
	private final int SIZE = 5;
	private Horse[] horses = new Horse[SIZE];
	
	private int rank;
	
	public Board() {
		setLayout(null);
		setBounds(0, 0, HorseGame.WIDTH, HorseGame.HEIGHT);
		
		setTimer();
		setButton();
		setGame();
	}
	
	private void setGame() {
		this.rank = 1;
		this.ms = 0;
		this.timer.setText("ready");
		
		int x = 30;
		int y = 100;
		
		for(int i=0; i<this.SIZE; i++) {
			this.horses[i] = new Horse(i+1,x,y,120, 90);
			y+= 100;
		}
	}


	private void setTimer() {
		this.timer.setBounds(135, 30, 100, 50);
		add(this.timer);
	}
	
	private void setButton() {
		this.reset.setBounds(30, 30, 100, 50);
		this.reset.addActionListener(this);
		add(this.reset);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.reset) {
//				this.isRun = this.isRun ? false : true ; // 삼항연산자
				this.isRun = !this.isRun;
				this.reset.setText(this.isRun ? "reset" : "start");
				
//				this.ms = this.ms != 0? 0: ms;
//				
//				for(int i=0; i<this.SIZE; i++) {
//					this.horses[i].setX(30);
//					this.horses[i].setState(horses[i].RUN);
//				}
				
				if(!this.isRun) {
					setGame();
				}
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// horses
		g.drawLine(30, 90,HorseGame.WIDTH-30, 90);
		
		for(int i=0; i<this.SIZE; i++) {
			Horse h = this.horses[i];
			g.drawImage(h.getImage().getImage(),h.getX(),h.getY(),null);
			g.drawLine(30, h.getY() + h.getH(), HorseGame.WIDTH - 30, h.getY() + h.getH());
			
			// rank
			if(h.getState() == h.GOAL) {
				g.setFont(new Font("",Font.PLAIN, 10));
				g.drawString(h.getRecord(), HorseGame.WIDTH-200, h.getY() + h.getH()/2);
				g.setFont(new Font("",Font.BOLD, 20));
				g.drawString(h.getRank() + "등", HorseGame.WIDTH-200, h.getY() + h.getH()/2 - 20);
			}
			
		}
		
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
		update();
		
		repaint();
	}
	
	private void update() {
		
		// 동시도착 예외처리
		boolean goal = false;
		
		if(this.isRun) {
			// run
			for(int i=0; i<this.SIZE; i++) {
				Horse h = this.horses[i];
				
				int jump = this.random.nextInt(30) *2 + 3;
				int tempX = h.getX() + jump;
				
				if(h.getState() == h.RUN) {
					
					// goal
					if(tempX>= HorseGame.WIDTH-30 - h.getW() && !goal) {
						h.setState(h.GOAL);
						h.setRecord(String.format("%4d.%03d", this.ms/1000, this.ms%1000));
						h.setRank(this.rank);
						this.rank ++;
						goal = !goal;
					}
					else if(tempX>= HorseGame.WIDTH-30 - h.getW()) {
						i--;
						
						// 되돌아가는 말이 발생할 경우 -> ms 홀딩하는 변수를 활용(isRun말구!) // 취소
//						break;
						continue;
					}
					
					h.setX(tempX);
				}
			}
		}
	}

	@Override // implements Runnable
	public void run() {
		while(true) {
			if(this.isRun) {
				this.ms ++;
				this.timer.setText(String.format("%3d.%3d", this.ms/1000, this.ms%1000));
			}
			
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
