package receiptsystem;

import java.util.ArrayList;

import interfaces.ItemsIterator;

public class PurchasedItems {
	private ArrayList<StoreItem> items;

	public PurchasedItems() {
		items = new ArrayList();
	}

	public ItemsIterator createIterator() {
		return new PurchasedItemsIterator(items);
	}

	public void addItem(StoreItem item) {
		items.add(item);
	}

	public double getTotalCost() {
		double total = 0;
		for (StoreItem item : items)
			total += Double.parseDouble(item.getItemPrice());
		return total;
	}

//	public StoreItem getItem(int index) {
//		return items.get(index);
//	}

//	public int getSize() {
//		return items.size();
//	}

	// Needed???
	public StoreItem getLastItem() {
		return items.get(items.size() - 1);
	}

	public boolean containsItem(String itemCode) {
		for (StoreItem item : items) {
			if (item.getItemCode().equals(itemCode))
				return true;
		}
		return false;
	}
}
