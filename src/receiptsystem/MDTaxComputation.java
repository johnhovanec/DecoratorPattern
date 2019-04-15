package receiptsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import abstractClasses.TaxComputationMethod;

//tax computation objects for other states are similar

public class MDTaxComputation extends TaxComputationMethod {
	public final double TAX_RATE = 0.06; // Ok in the subclass?

	public double computeTax(PurchasedItems items, Date date) {
		// calls private method taxHoliday as part of this computation-- ask, think it
		// has to be protected
		if (taxHoliday(date)) {
			return 0.0;
		} else {
			return TAX_RATE * items.getTotalCost();
		}
	}

	protected boolean taxHoliday(Date date) {
		// returns true if date of receipt within the state’s tax free holiday, // else
		// returns false. Supporting method of method computeTax.
		// ask about this method okay to be protected, instructions mentioned private
		// MD tax holiday is August 14–20

		// Temp
		if (checkDateRange(date))
			System.out.println("Tax Holiday!");
		else
			System.out.println("Not a tax holiday");

		return checkDateRange(date);
	}

	// Helper method, needed?
	private boolean checkDateRange(Date date) {
		final String HOLIDAY_START_DATE = "08-14-2019";
		final String HOLIDAY_END_DATE = "08-20-2019";
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = dateFormat.parse(HOLIDAY_START_DATE);
			endDate = dateFormat.parse(HOLIDAY_END_DATE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar receiptDate = Calendar.getInstance();
		receiptDate.setTime(date);
		int YEAR = receiptDate.get(Calendar.YEAR);
        
		Calendar holidayStart = Calendar.getInstance();
		holidayStart.setTime(startDate);
		Calendar holidayEnd = Calendar.getInstance();
		holidayEnd.setTime(endDate);
    	
        
		if (receiptDate.after(holidayStart) && receiptDate.before(holidayEnd))
			return true;
		else
			return false;
	}

	public String getSalesTax() {
		return String.valueOf(TAX_RATE);
	}

}