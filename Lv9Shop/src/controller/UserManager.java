package controller;

import java.util.ArrayList;

import models.Cart;
import models.Item;
import models.Shop;
import models.User;

public class UserManager {
	public static UserManager instance = new UserManager();

//	private ItemManager im = ItemManager.instance;
	private ArrayList<User> users = new ArrayList<>();

	public UserManager() {
		User newUser = new User("1", "1");
		this.users.add(newUser);
		newUser = new User("2", "2");
		this.users.add(newUser);
	}

	public void logIn() {
		System.out.print("ID: ");
		String id = Shop.sc.next();
		System.out.print("PW: ");
		String pw = Shop.sc.next();

		boolean check = false;
		for (User user : this.users) {
			if (user.getId().equals(id) && user.getPw().equals(pw)) {
				Shop.log = id;
				check = true;
			}
		}
		if (!check) {
			System.out.println("[아이디와 비밀번호를 다시 확인하세요.]");
		}
	}

	public void signIn() {
		System.out.print("회원가입할 ID: ");
		String id = Shop.sc.next();
		System.out.print("회원가입할 PW: ");
		String pw = Shop.sc.next();

		boolean check = true;
		for (User user : this.users) {
			if (user.getId().equals(id)) {
				check = false;
			}
		}
		if (check) {
			this.users.add(new User(id, pw));
			System.out.println(id + "_Welcome!");
		} else {
			System.out.println("[중복된 아이디]");
		}
	}

	public User getUser(String log) {
		for (User user : this.users) {
			if (user.getId().equals(log)) {
				return user;
			}
		}
		return null;
	}

	public void userJangList(String log) {
		for (User user : this.users) {
			if (user.getId().equals(log)) {
				if (user.getCartSize() > 0) {
					user.printCart();
				} else {
					System.out.println("[Empty Data]");
				}
			}
		}
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public void showAllUser() {
		int n = 0;
		for (User user : this.users) {
			System.out.printf("[%d]ID: %s PW: %s\n", n, user.getId(), user.getPw());
			n++;
		}
	}

	public void addUser() {
		this.signIn();
	}

	public void delUser() {
		try {
			System.out.print("삭제할 사용자 인덱스: ");
			int idx = Shop.sc.nextInt();
			String log = this.users.get(idx).getId();

			this.users.remove(idx);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void delCart(Cart cart) {
		for (User user : this.users) {
			for (Cart c : user.getCart()) {
				if (c.equals(cart)) {
					user.getCart().remove(cart);
				}
			}
		}
	}
}
