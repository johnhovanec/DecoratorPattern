package factories;

import receiptsystem.BasicReceipt;
import receiptsystem.Coupon100Get10Percent;
import receiptsystem.HolidayGreeting;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import abstractClasses.TaxComputationMethod;
import decorators.PostDecorator;
import decorators.PreDecorator;
import receiptsystem.PurchasedItems;
import receiptsystem.Rebate1406;
import receiptsystem.StoreHeader;
import stateTaxClasses.CATaxComputation;
import stateTaxClasses.DETaxComputation;
import stateTaxClasses.MDTaxComputation;
import interfaces.AddOn;
import interfaces.Coupon;
import interfaces.Rebate;
import interfaces.Receipt;
import interfaces.SecondaryHeading;

public class ReceiptFactory {
	private String CONFIG_FILE_PATH = "./src/config.txt";
	StoreHeader store_header; 
	private TaxComputationMethod[] taxComputationsObjs; 
	private TaxComputationMethod stateTaxMethod;
	private AddOn[] addOns = new AddOn[] {new HolidayGreeting(), new Rebate1406(), new Coupon100Get10Percent()};

	public ReceiptFactory() { 
		taxComputationsObjs = new TaxComputationMethod[] { new MDTaxComputation(), new DETaxComputation(), new CATaxComputation() };
		store_header = setStoreHeader();
		stateTaxMethod = setStateTax(store_header.getStateCode());
	}

	public Receipt getReceipt(PurchasedItems items, Date date) {
		/// 	1. Sets the current date of the BasicReceipt.
		/// 	2. Sets StoreHeader object of the BasicReceipt (by call to SetStoreHeader of
		// 		BasicReceipt)
		// 		3. Sets the TaxComputationMethod object of the BasicReceipt (by call to the
		// 		setTaxComputationMethod of BasicReceipt).
		// 		4. Traverses over all AddOn objects, calling the applies method of each. If
		// 		an AddOn object applies, then determines if the AddOn is of type
		// 		SecondaryHeader, Rebate, or Coupon.
		// 		If of type SecondaryHeader, then creates a PreDecorator for other AddOn. If of
		// 		type Rebate or Coupon, then creates a PostDecorator.
		// 		5. Links in the decorator object based on the Decorator design pattern.
		// 		6. Returns decorated BasicReceipt object as type Receipt.
		Receipt receipt = new BasicReceipt(items, date);
		((BasicReceipt) receipt).setStoreHeader(store_header);
		((BasicReceipt) receipt).setTaxComputationMethod(stateTaxMethod);
		for (AddOn addOn : addOns) {
			if(addOn.applies(items)) {
				if(addOn instanceof SecondaryHeading) {
					receipt = new PreDecorator(receipt, addOn);
				}
				else if(addOn instanceof Rebate || addOn instanceof Coupon) {
					receipt = new PostDecorator(receipt, addOn);
				}
			}
		}
		return (Receipt) receipt;
	}
	
	private TaxComputationMethod setStateTax(String state) {
		for (TaxComputationMethod item : taxComputationsObjs) {
			if (item.getClass().getName().contains(state))
				return item;
		}
		return null;
	}

	// Read in the config file
	private StoreHeader setStoreHeader() {
		String contents = null;
		try {
			contents = readConfigFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String lines[] = contents.split("\\r?\\n");
		String street_addr = lines[0];
		String state_code = lines[1];
		String zip_code = lines[2];
		String store_num = lines[3];
		String phone_num = lines[4];

		return new StoreHeader(street_addr, zip_code, state_code, phone_num, store_num);
	}

	private String readConfigFile() throws FileNotFoundException, IOException {
		String config = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE_PATH));
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = reader.readLine();
			}
			config = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return config;
	}
}
