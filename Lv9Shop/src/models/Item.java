package models;

public class Item {
	String category;
	String itemName;
	int price;
	public Item() {
	}
	
	public String getCategory() {
		return this.category;
	}
	public void printItem(int num) {
		System.out.printf("[%d]%s : %s원\n",num,this.itemName,this.price);
	}
}
