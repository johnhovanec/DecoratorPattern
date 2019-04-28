package receiptsystem;

import interfaces.Coupon;

public class Coupon100Get10Percent implements Coupon{

	@Override
	public boolean applies(PurchasedItems items) {
		if(items.getTotalCost() >= 100)
			return true;
		else
			return false;
	}

	@Override
	public String getLines() {
		return "\n10% OFF COUPON FOR SPENDING OVER $100\n\n" +
				"Present this coupon at your next purchase\n" +
				"and receive 10% off your purchase!\n\n" +
				"Restrictions apply, see store for details\n\n" + 
				"\n===================================================\n";
	}

}
