package receiptsystem;

import interfaces.Rebate;

public class Rebate1406 implements Rebate{

	@Override
	public boolean applies(PurchasedItems items) {
		// TODO Auto-generated method stub
			return items.containsItem("1406"); 
	}

	@Override
	public String getLines() {
		// TODO Auto-generated method stub
		return "Mail-in Rebate for Item #1406\n "
				+  "Name:\n Address:\n\n Mail to: Best Buy Rebates, P.O. Box 1400, Orlando, FL";
	}

}
