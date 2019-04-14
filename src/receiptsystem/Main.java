package receiptsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import factories.ReceiptFactory;
import interfaces.Receipt;

public class Main {

	public static void main(String[] args) {
		Store store = new Store();
		Date date = null;
		PurchasedItems purchasedItems = new PurchasedItems();
		Scanner scanner = new Scanner(System.in);
		String readLine = "";
		ReceiptFactory receiptFactory = new ReceiptFactory();
		Receipt receipt = null;

		while (!readLine.equalsIgnoreCase("X")) {
			System.out.println("\n----- Welcome to the Best Buy Receipt System -----\n");
			System.out.printf("Please choose from the following options:\n" + "1. Start New Receipt\n"
					+ "2. Add Items\n" + "3. Display Receipt\n" + "\n"
					+ "Enter the number of your selection and then press Enter. To exit, press X.");

			readLine = scanner.nextLine();
			switch (readLine) {
			case "1":
				// Start New Receipt
				System.out.println("Enter a date in the format MM-DD-YYYY for the new receipt followed by enter:");
				readLine = scanner.nextLine();
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
				try {
					date = dateFormat.parse(readLine);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println("New receipt started for date: " + date + "\n");

				break;
			case "2":
				// Add Items
				System.out.println("----------------     Available items     ---------------- \n"
						+ "Item Code\tDescription\t\t\t\tPrice");
				store.itemsList.forEach((item) -> System.out.println(
						item.getItemCode() + "\t\t" + item.getItemDescription() + "\t\t" + item.getItemPrice()));

				System.out.println("Enter the Item Code for the item to add to the receipt, press D when done:");
				while (!readLine.equalsIgnoreCase("D")) {
					readLine = scanner.nextLine();
					if (readLine.equalsIgnoreCase("D"))
						break;
					else {
						if (store.getItem(readLine) == null) {
							System.out.println("Invalid item code entered. Please try again.");
							continue;
						} else
							purchasedItems.addItem(store.getItem(readLine));
					}
					System.out.println("Added to receipt: " + purchasedItems.getLastItem().toString());
				}

				// Call factory to make receipt
				receipt = receiptFactory.getReceipt(purchasedItems, date);
				break;
			case "3":
				// Display Receipt
				receipt.prtReceipt();

				break;
			case "X":

				break;
			default:
				break;
			}
		}
		System.out.println("Goodbye");
		scanner.close();
		/// 1. Creates a Data (Date?) object (either from Java API or date entered by
		/// user)
		/// 2. Creates a PurchasedItems object (selections made by user)
		/// 3. Constructs a ReceiptFactory object.
		/// 3. Prompts user for items to purchase, storing each in PurchasedItems.
		// 4. Calls the getReceipt method of the factory to obtain constructed receipt.

		// // 5. Prints receipt by call to method prtReceipt.
		// get receipt date
		// (prompt user for current date)
		// display all available store items to user (to be implemented)
		// get all user selections (to be implemented)
		// ReceiptFactory factory = new ReceiptFactory(); Receipt =
		// factory.getReceipt(items, date); receipt.prtReceipt();

	}

}
