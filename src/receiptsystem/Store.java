package receiptsystem;

import java.util.ArrayList;

// Ask about doing this 
public class Store {
    
    ArrayList<StoreItem> itemsList;
    
    public Store(){
    	itemsList = new ArrayList<StoreItem>();
        populateStoreItems();
    }
    
    // Used to fetch item based on the itemcode entered
    public StoreItem getItem(String itemCode) {
    	for (StoreItem item : itemsList) {
			if(item.getItemCode().equals(itemCode))
				return item;
		}
    	return null;
    }
    
    private void populateStoreItems(){
        itemsList.add(new StoreItem("1406", "Ducky Mechanical Keyboard, TKL", "112.50"));
        itemsList.add(new StoreItem("6002", "USB 19GB Thumbdrive, silver", "12.80"));
        itemsList.add(new StoreItem("1303", "Dell Optiplex 3020, Intel i7", "852.90"));
        itemsList.add(new StoreItem("1704", "Logitech Bluetooth Mouse, gray", "32.98"));
        itemsList.add(new StoreItem("1065", "Logitech USB Keyboard, gray", "22.45"));
        itemsList.add(new StoreItem("1366", "InCase 13\" Laptop Case, green", "48.25"));
        itemsList.add(new StoreItem("2467", "Samsung J7 Cell Phone, black", "285.50"));
        itemsList.add(new StoreItem("5658", "Apple 13\" Macbook Pro, 1TB HD", "1390.65"));
        itemsList.add(new StoreItem("3489", "Seagate 500GB SSD hard drive", "192.50"));
        itemsList.add(new StoreItem("1010", "USB 8GB Thumbdrive, blue", "7.50"));
    }
}

