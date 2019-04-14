package receiptsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import abstractClasses.TaxComputationMethod;
import interfaces.ItemsIterator;
import interfaces.Receipt;

public class BasicReceipt implements Receipt {
	private StoreHeader store_header; // street address, state code, phone number, store number
	private TaxComputationMethod tc;
	private Date date; // may also be a String type
	private PurchasedItems items;

	public BasicReceipt(PurchasedItems items, Date date) { // Date may also be a String type
		this.items = items;
		this.date = date;
	}

	public void setStoreHeader(StoreHeader h) {
		store_header = h;
	}

	public void setTaxComputationMethod(TaxComputationMethod tc) {
		this.tc = tc;
	}

	public void prtReceipt() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		ItemsIterator itr = items.createIterator();
		StoreItem storeItem;
		System.out.println("\n===================================================\n");
		System.out.printf("%n%-30s %20s %n", "BEST BUY", "STORE #" + store_header.getStoreNum());
		System.out.printf("%-30s %20s %n", store_header.getStreetAddr(), store_header.getPhoneNum());
		System.out.printf("%n%-20s %n", formatter.format(date));
		System.out.printf("%n%-20s %n", "ITEM #");
		while (itr.hasNext()) {
			storeItem = itr.next();
			System.out.printf("%-10s%-30s%11s%n", storeItem.getItemCode(), storeItem.getItemDescription(), storeItem.getItemPrice());
		}
		System.out.printf("%n%-30s %20s %n", "Total Sale", " $" + getTotalSale());

	}
	
	private double getTotalSale() {
		ItemsIterator itr = items.createIterator();
		StoreItem storeItem;
		double total = 0.0;

		while (itr.hasNext()) {
			storeItem = itr.next();
			total += Double.parseDouble(storeItem.getItemPrice());
		}
		return total;
	}
}
