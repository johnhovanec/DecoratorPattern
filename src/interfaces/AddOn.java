package interfaces;

import receiptsystem.PurchasedItems;

public interface AddOn { 
	public boolean applies(PurchasedItems items);

	public String getLines();
}