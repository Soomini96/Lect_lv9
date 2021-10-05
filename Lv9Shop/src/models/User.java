package models;

import java.util.ArrayList;

public class User {
	private String id;
	private String pw;
	private ArrayList<Cart> cart = new ArrayList<Cart>();
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public ArrayList<Cart> getCart(){
		return cart;
	}
}
