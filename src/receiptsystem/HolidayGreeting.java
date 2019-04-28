package receiptsystem;

import interfaces.SecondaryHeading;

public class HolidayGreeting implements SecondaryHeading {

	@Override
	public boolean applies(PurchasedItems items) {
		return true; 
	}

	@Override
	public String getLines() {
		return "\t * Happy Holidays from Best Buy *";
	}
}