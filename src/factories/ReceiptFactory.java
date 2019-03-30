package factories;

import receiptsystem.BasicReceipt;
import java.util.Date;

import receiptsystem.PurchasedItems;
import receiptsystem.StoreHeader;
import interfaces.Receipt;

public class ReceiptFactory {
	StoreHeader store_header; // contains street_addr, zip_code, state_code, phone num, store num private
								// TaxComputationMethod[] taxComputationsObjs; // tax computation objs (for each
								// state) private AddOn[] addOns; // secondary heading, rebate and coupon
								// add-ons (hardcoded here)

	public ReceiptFactory() { // constructor
// 1. Populates array of TaxComputationMethod objects and array of AddOn objects (as if downloaded from the BestBuy web site).
// 2. Reads config file to create and save StoreHeader object (store_num, street_addr, etc.) to be used on all receipts.
// 3. Based on the state code (e.g., “MD”) creates and stores appropriate StateComputation object to be used on all receipts.
	}

	public Receipt getReceipt(PurchasedItems items, Date date) {
// 1. Sets the current date of the BasicReceipt.
// 2. Sets StoreHeader object of the BasicReceipt (by call to SetStoreHeader of BasicReceipt)
// 3. Sets the TaxComputationMethod object of the BasicReceipt (by call to the setTaxComputationMethod of BasicReceipt).
// 4. Traverses over all AddOn objects, calling the applies method of each. If an AddOn object applies, then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon.
// If of type SecondaryHeader, then creates a PreDecorator for othe AddOn. If of type Rebate or Coupon, then creates a PostDecorator.
// 5. Links in the decorator object based on the Decorator design pattern.
// 6. Returns decorated BasicReceipt object as type Receipt.
		BasicReceipt r = new BasicReceipt(items, date);
		return (Receipt) r;
	}
}
