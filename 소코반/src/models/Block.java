package models;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import controller.Board;
import controller.ResourceLoader;

public class Block {
	private final int GROUND = 1;
	private final int WALL = 2;
	private final int PLAYER = 3;
	private final int BOX = 4;
	private final int GOAL = 5;
	private final int OKBOX = 6;
	
	private int x, y, width, height;
	private String fileName;
	private ImageIcon image;
	
	private int state; // 1땅 2벽 3사람 4박스 5아이템 6fix박스
	
	private boolean goal; // 원래 자리 골?
	
	public boolean getGoal() {
		return goal;
	}
	
//	public void setGoal(boolean goal) {
//		this.goal = goal;
//	}
	
	
	public Block(int state, int x,int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.state = state;
		
		// 원래
//		this.fileName = String.format("image/tile%d.png", state);
//		this.image = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		
		// new File로 일단 해보기 -> 그 후 리소스 리더..
		this.fileName = String.format("image/tile%d.png", this.state);
//		this.fileName = String.format("res/image/tile%d.png", state);
//		this.image = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
//		this.image = new ImageIcon(new File(this.fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

		
		//		this.image = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		try {
//			BufferedImage gg = ImageIO.read(new File(fileName));
			BufferedImage gg = ImageIO.read(ResourceLoader.load(fileName));
			this.image = new ImageIcon(gg.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public ImageIcon getImage() {
		return image;
	}

//	public void setImage(ImageIcon image) {
//		this.image = image;
//	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		if(state == this.GOAL) {
			this.goal = true;
		}
		if(state == this.BOX && this.goal) {
			this.state = this.OKBOX;
		}
//		this.fileName = String.format("image/tile%d.png", this.state);
//		this.image = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		
		// new File로 일단 해보기 -> 그 후 리소스 리더..
		this.fileName = String.format("image/tile%d.png", this.state);
//		this.fileName = String.format("res/image/tile%d.png", state);
//		this.image = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
//		this.image = new ImageIcon(new File(this.fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

		//		this.image = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		try {
//			BufferedImage gg = ImageIO.read(new File(fileName));
			BufferedImage gg = ImageIO.read(ResourceLoader.load(fileName));
			this.image = new ImageIcon(gg.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
