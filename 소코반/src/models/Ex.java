package models;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ResourceLoader;

class Wow extends JFrame{
	public Wow() {
		setLayout(null);
		setBounds(100, 100, 500, 500);
		Scanner s = new Scanner(ResourceLoader.load(String.format("image/tile%d.png", 1)));
		
		setVisible(true);
		revalidate();
	}
}
public class Ex {

	public static void main(String[] args) {
		Wow wow = new Wow();
	}

}
