import controller.ShopManager;
import models.Shop;

public class Main {
public static void main(String[] args) {
	Shop shop = new Shop();
	ShopManager shopManager = new ShopManager(shop.getShopName());
	shopManager.run();
}
}
