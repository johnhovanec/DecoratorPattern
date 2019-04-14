package receiptsystem;

import java.util.ArrayList;

import interfaces.ItemsIterator;

public class PurchasedItemsIterator implements ItemsIterator {
	private ArrayList<StoreItem> items;
	private int current = 0;

	public PurchasedItemsIterator(ArrayList<StoreItem> items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if (current >= items.size())
			return false;
		else
			return true;
	}

	@Override
	public StoreItem next() {
		StoreItem storeItem = items.get(current);
		current = current + 1;
		return storeItem;
	}
}
