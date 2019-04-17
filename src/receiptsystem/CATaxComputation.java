package receiptsystem;

import java.util.Date;

import abstractClasses.TaxComputationMethod;

public class CATaxComputation extends TaxComputationMethod{
	public final double TAX_RATE = 0.06; // Ok in the subclass?
	
	@Override
	public double computeTax(PurchasedItems items, Date date) {
		return TAX_RATE;
	}

	@Override
	protected boolean taxHoliday(Date date) {
		// CA does not have tax holidays
		throw new UnsupportedOperationException();
	}

}
