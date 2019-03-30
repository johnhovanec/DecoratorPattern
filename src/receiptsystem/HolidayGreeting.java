package receiptsystem;

import interfaces.SecondaryHeading;

public class HolidayGreeting implements SecondaryHeading {

	@Override
	public boolean applies(PurchasedItems items) {
		// TODO Auto-generated method stub
		return true; // SecondaryHeading decorators always applied
	}

	@Override
	public String getLines() {
		// TODO Auto-generated method stub
		return "* Happy Holidays from Best Buy *";
	}

}
