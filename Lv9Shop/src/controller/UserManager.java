package controller;

import java.util.ArrayList;

import models.Cart;
import models.Item;
import models.Shop;
import models.User;

public class UserManager {
	public static UserManager instance = new UserManager();
	
	private ArrayList<User> users = new ArrayList<>();
	
	public void logIn() {
		System.out.print("ID: ");
		String id = Shop.sc.next();
		System.out.print("PW: ");
		String pw = Shop.sc.next();
		
		boolean check = true;
		for(User user : this.users) {
			if(user.getId().equals(id) && user.getPw().equals(pw)) {
				Shop.log = id;
			}
		}
		if(check) {
			this.users.add(new User(id, pw));
			System.out.println(id + "_Welcome!");
		} else {
			System.out.println("[중복된 아이디]");
		}
		
	}
	
	public void signIn() {
		System.out.print("회원가입할 ID: ");
		String id = Shop.sc.next();
		System.out.print("회원가입할 PW: ");
		String pw = Shop.sc.next();
		
		boolean check = true;
		for(User user : this.users) {
			if(user.getId().equals(id)) {
				check = false;
			}
		}
		if(check) {
			this.users.add(new User(id, pw));
			System.out.println(id + "_Welcome!");
		} else {
			System.out.println("[중복된 아이디]");
		}
	}
	public void getUser(String log) {
		for(User user : this.users) {
			
		}
	}
}
