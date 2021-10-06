package models;

import java.util.ArrayList;

public class User {
	private String id;
	private String pw;
	private ArrayList<Cart> carts = new ArrayList<Cart>();

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

	public ArrayList<Cart> getCart() {
		return carts;
	}

	public void printCart() {
		int idx = 0;
		for (Cart cart : this.carts) {
			System.out.print("[" + idx + "]");
			cart.printCart();
			idx++;
		}
	}

	public int getCartSize() {
		return this.carts.size();
	}

	public void delCart(Cart cart) {
		int delIdx = 0;
		for (Cart c : this.carts) {
			if (c.equals(cart)) {
				break;
			}
			delIdx++;
		}
		this.carts.remove(delIdx);
	}

	public void allRemoveJang() {
		this.carts = null;
		this.carts = new ArrayList<Cart>();
	}
	public void addCart(Cart cart) {
		this.carts.add(cart);
	}
}
