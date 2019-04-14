package receiptsystem;

import java.util.Calendar;
import java.util.Date;

import abstractClasses.TaxComputationMethod;

//tax computation objects for other states are similar

public class MDTaxComputation extends TaxComputationMethod {
	public final double TAX_RATE = 0.06; // Ok in the subclass?
	
	public double computeTax(PurchasedItems items, Date date) {
		// calls private method taxHoliday as part of this computation-- ask, think it
		// has to be protected
		if (taxHoliday(date)) {
			return 0.0;
		}
		else {
			return TAX_RATE * items.getTotalCost();
		}	
	}

	protected boolean taxHoliday(Date date) {
		// returns true if date of receipt within the state’s tax free holiday, // else
		// returns false. Supporting method of method computeTax.
		// ask about this method okay to be protected, instructions mentioned private
		// MD tax holiday is August 14–20
		
	    if(checkDateRange())
	      System.out.println("Tax Holiday!");
	    else
	      System.out.println("Not a tax holiday");
	    
		return checkDateRange(); 
	}
	
	// Helper method, needed?
	private boolean checkDateRange() {
		final int HOLIDAY_MONTH = Calendar.AUGUST;  // this is a static int
		final int START_DATE = 14;
		final int END_DATE = 20;
	    int current_month = Calendar.getInstance().get(Calendar.MONTH);
	    int current_date = Calendar.getInstance().get(Calendar.DATE);
	    
		if (HOLIDAY_MONTH == current_month && START_DATE <= current_date && current_date <= END_DATE) 
			return true;
		else
			return false;
	}

	public String getSalesTax() {
		return String.valueOf(TAX_RATE);
	}

}