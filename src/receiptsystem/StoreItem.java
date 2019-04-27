package receiptsystem;

public class StoreItem {
	private String itemCode; 
	private String itemDescription; 
	private String itemPrice;

	public StoreItem(String code, String description, String price) {
		itemCode = code;
		itemDescription = description;
		itemPrice = price;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
	
	public String getItemPrice() {
		return itemPrice;
	}
	
	public String toString() {
		return itemCode + "\t" + itemDescription + "\t" + itemPrice;
	}
	
}
