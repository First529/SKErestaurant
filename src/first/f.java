package first;

import java.util.Scanner;

/**
 * Main class for SKE restaurant order taking application. It displays different
 * dishes and beverages to choose from the menu. When done, it asks you to input
 * the money in order to complete the purchase.
 * 
 * @author Dechabhol Kotheeranurak
 */

public class f {

	static double total = 0.0;

	static RestaurantManager manager = new RestaurantManager();
	static Scanner sc = new Scanner(System.in);

	public static boolean choiceNum(String choice) {

		try {
			Integer.parseInt(choice);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static void printMenu() {

		System.out.println("--------- Welcome to SKE Restaurant ---------");
		for (int i = 0; i < RestaurantManager.menuItems.size(); i++) {
			System.out.printf("%d.) %s\t%.2f Baht.\n", i + 1, RestaurantManager.menuItems.get(i),
					RestaurantManager.prices.get(i));
		}
		System.out.println("");
		System.out.printf("[T] Total\t\n");
		System.out.printf("[X] Exit\t\n");
	}

	public static void printReceipt() {
		System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
		for (int i = 0; i < RestaurantManager.quantity.size(); i++) {
			if (RestaurantManager.quantity.get(i) > 0) {
				System.out.printf("| %-17s|%9d|%11.2f|\n", RestaurantManager.menuItems.get(i),
						RestaurantManager.quantity.get(i),
						RestaurantManager.quantity.get(i) * RestaurantManager.prices.get(i));
			}
		}
		total = 0.0;
		for (int j = 0; j < RestaurantManager.quantity.size(); j++) {
			total += RestaurantManager.quantity.get(j) * RestaurantManager.prices.get(j);
		}
		System.out.println("+------------------+---------+-----------+");
		System.out.printf("| Total\t\t\t     |%11.2f|\n", total);
		System.out.println("+----------------------------+-----------+");
		System.out.println("");
	}

	public static void change() {
		System.out.print("Received Amount : ");
		int amount = sc.nextInt();
		if (amount == total) {
			System.out.print("There is no more change for you. :)");
		} else if (amount > total) {
			System.out.printf("Your change is %.2f.\n", amount - total);
		} else {
			System.out.printf("Please input more money !\n");
			int aAmount = 0;
			int count = 0;
			int bAmount = 0;
			int cAmount = 0;

			do {
				if (count == 0) {
					System.out.printf("Your total is %.2f please add %.2f more.\n", total, total - amount);
					System.out.print("+ ");
					aAmount = sc.nextInt();
					if ((aAmount) == (total - amount)) {
						System.out.println("There is no more change for you. :)");
						System.out.println("");
						break;
					} else if ((aAmount) > (total - amount)) {
						System.out.printf("Your change is %.2f.\n", aAmount - (total - amount));

					}
					count++;
				} else if (count > 0) {
					double zTotal = total - amount - aAmount;
					System.out.printf("Your total is %.2f please add %.2f more.\n", total, zTotal - cAmount);
					System.out.print("+ ");
					bAmount = sc.nextInt();
					if ((bAmount) == (zTotal - cAmount)) {
						System.out.println("There is no more change for you. :)");
						System.out.println("");
						break;
					} else if ((bAmount) > (zTotal - cAmount)) {
						System.out.printf("Your change is %.2f.\n", bAmount - (zTotal - cAmount));
						break;

					} else {
						cAmount += bAmount;
					}

				}
			} while (0 < 1);
		}
		System.out.println();
		System.out.print("===== Thank you =====");
	}

	public static void main(String[] args) {

		manager.openFile();
		manager.readFile();

		printMenu();

		String choice;
		String quantity;

		do {
			System.out.print("Enter your Choice: ");
			choice = sc.next();
			if (choiceNum(choice)) {
				if (Integer.parseInt(choice) <= RestaurantManager.menuItems.size()) {
					System.out.print("Enter Quantity: ");
					quantity = sc.next();
					System.out.println("");
					RestaurantManager.quantity.set(Integer.parseInt(choice) - 1,
							RestaurantManager.quantity.get(Integer.parseInt(choice) - 1) + Integer.parseInt(quantity));
				} else if (Integer.parseInt(choice) > RestaurantManager.menuItems.size()) {
					System.out.println("# Invalid input");
				}
			} else if (choice.equalsIgnoreCase("T")) {
				printReceipt();
			}

		} while (!choice.equalsIgnoreCase("X"));
		change();

	}

}