package stateTaxClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import abstractClasses.TaxComputationMethod;
import exceptions.TaxFreeHolidayException;
import receiptsystem.PurchasedItems;

public class MDTaxComputation extends TaxComputationMethod {
	private final double TAX_RATE = 0.06;

	public double computeTax(PurchasedItems items, Date date) throws TaxFreeHolidayException {
		if (taxHoliday(date))
			throw new TaxFreeHolidayException();
		else
			return items.getTotalCost() * TAX_RATE;
	}

	protected boolean taxHoliday(Date date) {
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