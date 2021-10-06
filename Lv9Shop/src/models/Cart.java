package models;

public class Cart {
	Item item;
	String id;
	
	public Cart(Item item, String id) {
		this.item = item;
		this.id = id;
	}
	public void printCart() {
		System.out.println(this.item.itemName + " : " + this.item.price + "원");
	}
	public String getId() {
		return this.id;
	}
}