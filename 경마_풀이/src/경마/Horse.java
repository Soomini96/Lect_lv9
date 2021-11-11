package 경마;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horse {
	public final int RUN = 0;
	public final int GOAL = 1;
	
	private int num;
	private int x, y, w, h;
	private int state; // 0run 1goal
	
	private String fileName;
	private ImageIcon image;
	
	private int rank;
	private String record;
	
	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public Horse(int num, int x, int y, int w, int h) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("image/horse%d.png", num);
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getFilename() {
		return fileName;
	}

	public void setFilename(String filename) {
		this.fileName = filename;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}