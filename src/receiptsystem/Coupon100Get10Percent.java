package receiptsystem;

import interfaces.Rebate;

public class Coupon100Get10Percent implements Rebate{

	@Override
	public boolean applies(PurchasedItems items) {
		if(items.getTotalCost() >= 100)
			return true;
		else
			return false;
	}

	@Override
	public String getLines() {
		return null;
	}

}
