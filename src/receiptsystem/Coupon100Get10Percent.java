package receiptsystem;

import interfaces.Rebate;

public class Coupon100Get10Percent implements Rebate{

	@Override
	public boolean applies(PurchasedItems items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLines() {
		// TODO Auto-generated method stub
		return null;
	}

}
