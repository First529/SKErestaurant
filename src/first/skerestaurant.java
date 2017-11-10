package first;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class for SKE restaurant order taking application. It displays different
 * dishes and beverages to choose from the menu. When done, it asks you to input
 * the money in order to complete the purchase.
 * 
 * @author Dechabhol Kotheeranurak
 */

public class skerestaurant {

	static double total = 0.0;

	static Food[] menu = new Food[RestaurantManager.menu.size()];

	static int[] quantity;
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

		menu = RestaurantManager.menu.toArray(menu);
		quantity = new int[menu.length];
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d.) %s\t%.2f Baht.\n", i + 1, menu[i].getName(), menu[i].getPrice());
		}
		System.out.println("");
		System.out.printf("[T] Total\t\n");
		System.out.printf("[X] Exit\t\n");
	}

	public static void printReceipt() {
		System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
		for (int i = 0; i < quantity.length; i++) {
			if (quantity[i] > 0) {
				System.out.printf("| %-17s|%9d|%11.2f|\n", menu[i].getName(), quantity[i],
						quantity[i] * menu[i].getPrice());
			}
		}
		total = 0.0;
		for (int j = 0; j < quantity.length; j++) {
			total += quantity[j] * menu[j].getPrice();
		}
		System.out.println("+------------------+---------+-----------+");
		System.out.printf("| Total\t\t\t     |%11.2f|\n", total);
		System.out.println("+----------------------------+-----------+");
		System.out.println("");
	}

	public static void change() {
		boolean tf = true;
		System.out.print("Received Amount : ");
		double amount = sc.nextDouble();
		if (amount == total) {
			System.out.print("There is no more change for you. :)");
		} else if (amount > total) {
			System.out.printf("Your change is %.2f.\n", amount - total);
			
		} else {
			System.out.printf("Please input more money !\n");
			double aAmount = 0;
			int count = 0;
			double bAmount = 0;
			double cAmount = 0;

			do {
				if (count == 0) {
					System.out.printf("Your total is %.2f please add %.2f more.\n", total, total - amount);
					System.out.print("+ ");
					aAmount = sc.nextDouble();
					if ((aAmount) == (total - amount)) {
						System.out.println("There is no change for you. :)");
						System.out.println("");
						break;
					} else if ((aAmount) > (total - amount)) {
						System.out.printf("Your change is %.2f.\n", aAmount - (total - amount));
						break;
					}
					count++;
				} else if (count > 0) {
					double zTotal = total - amount - aAmount;
					System.out.printf("Your total is %.2f please add %.2f more.\n", total, zTotal - cAmount);
					System.out.print("+ ");
					bAmount = sc.nextDouble();
					if ((bAmount) == (zTotal - cAmount)) {
						System.out.println("There is no change for you. :)");
						System.out.println("");
						break;
					} else if ((bAmount) > (zTotal - cAmount)) {
						System.out.printf("Your change is %.2f.\n", bAmount - (zTotal - cAmount));
						break;

					} else {
						cAmount += bAmount;
					}

				}
			} while (tf);
		}
		System.out.println();
		System.out.print("===== Thank you =====");
	}

	public static void inputMoney() {
		String choice;
		String quan;

		do {
			System.out.print("Enter your Choice: ");
			choice = sc.next();
			if (choiceNum(choice)) {
				if (Integer.parseInt(choice) <= menu.length) {
					System.out.print("Enter Quantity: ");
					quan = sc.next();
					System.out.println("");
					quantity[Integer.parseInt(choice) - 1] += Integer.parseInt(quan);
				} else if (Integer.parseInt(choice) > menu.length) {
					System.out.println("# Invalid input");
				}
			} else if (choice.equalsIgnoreCase("T")) {
				printReceipt();
			}

		} while (!choice.equalsIgnoreCase("X"));
		change();

	}

	public static void main(String[] args) {
		manager.readFile(manager.openFile());
		printMenu();
		inputMoney();
	}

}