package receiptsystem;

import java.util.Date;

import abstractClasses.TaxComputationMethod;

public class MDTaxComputation extends TaxComputationMethod {
	public double computeTax(PurchasedItems items, Date date) {
		// calls private method taxHoliday as part of this computation
		return 0.0; //tmp
	}

	public boolean taxHoliday(Date date) {
		// returns true if date of receipt within the state’s tax free holiday, // else
		// returns false. Supporting method of method computeTax.
		return false; //tmp
	}

	
}
// tax computation objects for other states are similar