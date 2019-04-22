package receiptsystem;

import interfaces.SecondaryHeading;

public class HolidayGreeting implements SecondaryHeading {

	@Override
	public boolean applies(PurchasedItems items) {
		return true; // SecondaryHeading decorators always applied
	}

	@Override
	public String getLines() {
		return "\t * Happy Holidays from Best Buy *";
	}

}
