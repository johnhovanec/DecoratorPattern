package abstractClasses;

import java.util.Date;

import receiptsystem.PurchasedItems;

public abstract class TaxComputationMethod {
//	public abstract double computeTax(PurchasedItems items, ReceiptDate date);
//
//	private abstract boolean taxHoliday();
	
	public abstract double computeTax(PurchasedItems items, Date date);

	protected abstract boolean taxHoliday(Date date);  // guessing it has a param
}
