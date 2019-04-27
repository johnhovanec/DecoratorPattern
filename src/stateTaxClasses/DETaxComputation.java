package stateTaxClasses;

import java.util.Date;
import abstractClasses.TaxComputationMethod;
import receiptsystem.PurchasedItems;

public class DETaxComputation extends TaxComputationMethod {
	
	public double computeTax(PurchasedItems items, Date date) {
		// DE has no sales tax
		throw new UnsupportedOperationException();
	}

	protected boolean taxHoliday(Date date) {
		// DE has no tax holidays
		throw new UnsupportedOperationException();
	}
}