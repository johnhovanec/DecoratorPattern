package abstractClasses;

import java.util.Date;

import exceptions.TaxFreeHolidayException;
import receiptsystem.PurchasedItems;

public abstract class TaxComputationMethod {
	
	public abstract double computeTax(PurchasedItems items, Date date)
			throws TaxFreeHolidayException, UnsupportedOperationException;

	protected abstract boolean taxHoliday(Date date);
}
