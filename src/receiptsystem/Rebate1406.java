package receiptsystem;

import interfaces.Rebate;

public class Rebate1406 implements Rebate {

	@Override
	public boolean applies(PurchasedItems items) {
		return items.containsItem("1406");
	}

	@Override
	public String getLines() {
		return "$10 REBATE  Item #1406  Ducky Mechanical Keyboard\n\n" +
				"Mail ORIGINAL receipt and Proof of Purchase to:\n\n" +
				"BEST BUY/DUCKY KEYBOARD Rebates,\n" +
				"P.O. Box 1400,\n" + 
				"Orlando, FL 32789\n\n" +
				"Please allow 3-4 weeks for processing\n\n" + 
				"\n===================================================\n";
	}
}
