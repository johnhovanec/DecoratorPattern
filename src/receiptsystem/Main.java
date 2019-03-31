package receiptsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Store store = new Store();
		Date date;
		PurchasedItems purchasedItems = new PurchasedItems();
		Scanner scanner = new Scanner(System.in);
		String readLine = "";
		
		while (!readLine.equalsIgnoreCase("X")) {
			System.out.println("\n----- Welcome to the Best Buy Receipt System -----\n");
			System.out.printf("Please choose from the following options:\n" + "1. Start New Receipt\n" + "2. Add Items\n"
					+ "3. Display Receipt\n" + "\n"
					+ "Enter the number of your selection and then press Enter. To exit, press X.");

			readLine = scanner.nextLine();
			switch (readLine) {
			case "1":
				// Start New Receipt
				System.out.println("Enter a date in the format MM-DD-YYYY for the new receipt followed by enter:");
				readLine = scanner.nextLine();
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				try {
					date = dateFormat.parse(readLine);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println("-----     Available items:     -----");
				store.itemsList.forEach((item) -> System.out.println(
						item.getItemCode() + "\t" + 
						item.getItemDescription() + "\t" +
						item.getItemPrice()));
				break;
			case "2":
				// Add Items
				
				break;
			case "3":
				// Display Receipt
				
				break;
			case "X":

				break;
			default:
				break;
			}
		}
		System.out.println("Goodbye");
		scanner.close();
		// 1. Creates a Data object (either from Java API or date entered by user)
		// 2. Creates a PurchasedItems object (selections made by user)
		// 3. Constructs a ReceiptFactory object.
		// 3. Prompts user for items to purchase, storing each in PurchasedItems.
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
