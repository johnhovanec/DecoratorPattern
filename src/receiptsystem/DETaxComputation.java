package receiptsystem;

import java.util.Date;
import abstractClasses.TaxComputationMethod;

public class DETaxComputation extends TaxComputationMethod {
	private final double TAX_RATE = 0.0;
	
	public double computeTax(PurchasedItems items, Date date) {
		// calls private method taxHoliday as part of this computation-- ask, think it
		// has to be protected

		// DE has no sales tax, always return 0.0, instructions mention returning null?
		return TAX_RATE;
		//throw new UnsupportedOperationException();
	}

	protected boolean taxHoliday(Date date) {
		// OK to through UnsupportedOperationException?
		// ask about this method okay to be protected, instructions mentioned private

		// DE has no sales tax and therefore no tax holidays
		throw new UnsupportedOperationException();
	}
}