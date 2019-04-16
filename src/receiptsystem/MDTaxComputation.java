package receiptsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		} else {
			return TAX_RATE;
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
		Calendar receiptDate = Calendar.getInstance();
		receiptDate.setTime(date);
		int YEAR = receiptDate.get(Calendar.YEAR);

		// MD Tax holiday is August 14-20. Setting to get inclusive start and end date
		final String HOLIDAY_START_DATE = "08-13-" + YEAR;
		final String HOLIDAY_END_DATE = "08-21-" + YEAR;
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		try {
			start.setTime(df.parse(HOLIDAY_START_DATE));
			end.setTime(df.parse(HOLIDAY_END_DATE));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (receiptDate.after(start) && receiptDate.before(end))
			return true;
		else
			return false;
	}
}