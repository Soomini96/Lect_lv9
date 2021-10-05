package models;

import java.util.Scanner;

public class Shop {
	String shopName = "Green Mart";
	
	public static Scanner sc = new Scanner(System.in);
	
	public static String log = null;
	
	public String getShopName() {
		return this.shopName;
	}
}
