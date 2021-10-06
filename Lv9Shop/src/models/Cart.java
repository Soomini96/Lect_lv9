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

	public void printCart(int num) {
		System.out.println("[" + num + "]" + this.id + " ⮕ " + this.item.getCategory() + "|" + this.item.getItemName());
	}

	public String getId() {
		return this.id;
	}
}