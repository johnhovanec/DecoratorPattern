package receiptsystem;

import java.text.SimpleDateFormat;
import java.util.Date;

import abstractClasses.TaxComputationMethod;
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
		System.out.printf( "%n %-20s %20s %n", "BEST BUY", "STORE #" +store_header.getStoreNum());
		System.out.printf( "%-20s %20s %n", store_header.getStreetAddr(), store_header.getPhoneNum());
		System.out.printf( "%n %-20s %n", formatter.format(date));
		
	}
}
