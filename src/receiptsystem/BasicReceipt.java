package receiptsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import abstractClasses.TaxComputationMethod;
import exceptions.TaxFreeHolidayException;
import interfaces.ItemsIterator;
import interfaces.Receipt;

public class BasicReceipt implements Receipt {
	private StoreHeader store_header;
	private TaxComputationMethod tc;
	private Date date;
	private PurchasedItems items;

	public BasicReceipt(PurchasedItems items, Date date) {
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
		double tax = 0.0;
		boolean taxHoliday = false;

		System.out.println("\n===================================================\n");
		System.out.printf("%n%-30s %20s %n", "BEST BUY", "STORE #" + store_header.getStoreNum());
		System.out.printf("%-18s, %-3s%-10s%14s%n", store_header.getStreetAddr(), store_header.getStateCode(),
				store_header.getZipCode(), store_header.getPhoneNum());
		System.out.printf("%n%-20s %n", formatter.format(date));
		System.out.printf("%n%-20s %n", "ITEM #");
		
		while (itr.hasNext()) {
			storeItem = itr.next();
			System.out.printf("%-10s%-30s%11s%n", storeItem.getItemCode(), storeItem.getItemDescription(),
					"$" + storeItem.getItemPrice());
		}
		
		System.out.printf("%n%-30s %20s %n", "Total Sale", " $" + String.format("%.2f", items.getTotalCost()));
		
		try {
			tax = tc.computeTax(items, date);
			System.out.printf("%n%-2s %-10s(%-3s%%) %31s %n", store_header.getStateCode(), "Sales Tax ",
					String.format("%.1f", (tax / items.getTotalCost()) * 100), " $" + String.format("%.2f", tax));
		} catch (TaxFreeHolidayException e) {
			taxHoliday = true;
			System.out.printf("%n%-2s %-10s %37s %n", store_header.getStateCode(), "Sales Tax ", "$0.00");
		} catch (UnsupportedOperationException e) {
			// If here it's a tax free state so print no tax info
		} finally {
			System.out.printf("%n%-30s %20s %n", "AMOUNT DUE",
					" $" + String.format("%.2f", (items.getTotalCost() + tax)));
			System.out.println("\n===================================================\n");
		}

		if (taxHoliday) {
			System.out.printf("%32s %n", "TAX FREE HOLIDAY!");
			System.out.println("\n===================================================\n");
		}
	}
}
