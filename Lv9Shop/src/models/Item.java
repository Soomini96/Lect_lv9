package models;

public class Item {
	String category;
	String itemName;
	int price;

	public Item(String category, String itemName, int price) {
		this.category = category;
		this.itemName = itemName;
		this.price = price;
	}

	public String getCategory() {
		return this.category;
	}

	public void printItem(int num) {
		System.out.printf("[%d]%s|%s : %s원\n", num, this.category, this.itemName, this.price);
	}

	public String getItemName() {
		return this.itemName;
	}
}
