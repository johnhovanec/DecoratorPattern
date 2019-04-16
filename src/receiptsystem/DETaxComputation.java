package receiptsystem;

import java.util.Date;
import abstractClasses.TaxComputationMethod;

public class DETaxComputation extends TaxComputationMethod {
	private final double TAX_RATE = 0.0;
	
	public double computeTax(PurchasedItems items, Date date) {
		// calls private method taxHoliday as part of this computation-- ask, think it
		// has to be protected

		// DE has no sales tax, always return 0.0
		return TAX_RATE;
	}

	protected boolean taxHoliday(Date date) {
		// returns true if date of receipt within the state’s tax free holiday, // else
		// returns false. Supporting method of method computeTax.
		// ask about this method okay to be protected, instructions mentioned private

		// DE has no sales tax, OK?
		throw new UnsupportedOperationException();
	}
}