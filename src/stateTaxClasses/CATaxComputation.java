package stateTaxClasses;

import java.util.Date;

import abstractClasses.TaxComputationMethod;
import receiptsystem.PurchasedItems;

public class CATaxComputation extends TaxComputationMethod{
	public final double TAX_RATE = 0.075; // Ok in the subclass?
	
	@Override
	public double computeTax(PurchasedItems items, Date date) {
		return items.getTotalCost() * TAX_RATE;
	}

	@Override
	protected boolean taxHoliday(Date date) {
		// CA does not have tax holidays
		throw new UnsupportedOperationException();
	}

}
