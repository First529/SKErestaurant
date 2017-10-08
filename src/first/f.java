package first;

import java.util.Scanner;
/** 
 * Main class for SKE restaurant order taking application.
 * It displays different dishes and beverages to choose from the menu.
 * When done, it asks you to input the money in order to complete the purchase.
 * 
 * @author Dechabhol Kotheeranurak
 */

public class f {

	static int totalPizza = 0;
	static int totalChickens = 0;
	static int totalOrange = 0, totalCoke = 0, totalWater = 0;
	static int total = 0;
	
	private static final String[] list = { "Pizza", "Chickens", "Beverages", "totalPrice" };
	private static final String[] choiceBeverages = { "Orange juice", "Coke", "Water" };
	private static final int[] prices = { 250, 120, 65, 45, 20 };
	private static final int[] totalQuantity = new int[5];
	

	public static int choicePizza(int c, int q, int[] prices) {
		totalPizza += prices[0] * q;
		return totalPizza;
	}

	public static int choiceChicken(int c, int q, int[] prices) {
		totalChickens += prices[1] * q;
		return totalChickens;
	}

	public static int choiceOrange(int c, int q, int[] prices) {
		totalOrange += prices[2] * q;
		return totalOrange;
	}

	public static int choiceCoke(int c, int q, int[] prices) {
		totalCoke += prices[3] * q;
		return totalCoke;
	}

	public static int choiceWater(int c, int q, int[] prices) {
		totalWater += prices[4] * q;
		return totalWater;
	}

	public static boolean choice5(int choice) {

		if (choice != 5) {
			return true;
		}
		return false;

	}
	
	public static String choiceToString(int choice, String[] menus) {
		if (choice == 1) {
			return menus[0];
		}
		if (choice == 2) {
			return menus[1];
		}
		if (choice == 3) {
			return menus[2];
		}
		if (choice == 4) {
			return menus[3];
		}
		return null;
	}

	public static String subChoice(int subChoice, String[] choiceBeverages) {
		if (subChoice == 1) {
			return choiceBeverages[0];
		}
		if (subChoice == 2) {
			return choiceBeverages[1];
		}
		if (subChoice == 3) {
			return choiceBeverages[2];
		}
		return null;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		System.out.printf("1.) Pizza\t 250 Baht.\n");
		System.out.printf("2.) Chickens\t 120 Baht.\n");
		System.out.printf("3.) Beverages\t \n");
		System.out.printf("4.) Total\t\n");
		System.out.printf("5.) Exit\t\n");
		
		int choice;
		int quantity;

		do {
			System.out.print("Enter your Choice: ");
			choice = sc.nextInt();
			if (choice5(choice)) {
				switch (choiceToString(choice,list)) {

				case "Pizza":
					System.out.print("Enter Quantity: ");
					quantity = sc.nextInt();
					System.out.println("");
					choicePizza(choice, quantity, prices);
					totalQuantity[0] += quantity;
					break;
					
				case "Chickens":
					System.out.print("Enter Quantity: ");
					quantity = sc.nextInt();
					System.out.println("");
					choiceChicken(choice, quantity, prices);
					totalQuantity[1] += quantity;
					break;
					
				case "Beverages":
					System.out.print("3.1) Orange juice\t 65 baht.\n");
					System.out.print("3.2) Coke\t\t 45 baht.\n");
					System.out.print("3.3) Mineral water\t 20 baht.\n");
					System.out.print("Choose your drink: ");
					int subChoice = sc.nextInt();
					System.out.print("Enter Quantity: ");
					quantity = sc.nextInt();
					System.out.println("");
					if (subChoice(subChoice,choiceBeverages).equals("Orange juice")) {
						choiceOrange(subChoice, quantity, prices);
						totalQuantity[2] += quantity;
						break;
					}
					if (subChoice(subChoice,choiceBeverages).equals("Coke")) {
						choiceCoke(choice, quantity, prices);
						totalQuantity[3] += quantity;
						break;
					}
					if (subChoice(subChoice,choiceBeverages).equals("Water")) {
						choiceWater(choice, quantity, prices);
						totalQuantity[4] += quantity;
						break;
					}
				case "totalPrice":
					total = totalPizza + totalChickens + totalOrange + totalCoke + totalWater;
					System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
					if (totalPizza >= 250) {
						System.out.printf("| %s\t\t   |%9d|%11d|\n", "Pizza", totalQuantity[0], totalPizza);
					}
					if (totalChickens >= 120) {
						System.out.printf("| %s\t   |%9d|%11d|\n", "Chickens", totalQuantity[1], totalChickens);
					}
					if (totalOrange >= 65) {
						System.out.printf("| %s\t   |%9d|%11d|\n", "Orange juice", totalQuantity[2], totalOrange);
					}
					if (totalCoke >= 45) {
						System.out.printf("| %s\t\t   |%9d|%11d|\n", "Coke", totalQuantity[3], totalCoke);
					}
					if (totalWater >= 20) {
						System.out.printf("| %s\t   |%9d|%11d|\n", "Mineral Water", totalQuantity[4], totalWater);
					}

					System.out.println("+------------------+---------+-----------+");
					System.out.printf("| Total\t\t\t     |%11d|\n", total);
					System.out.println("+----------------------------+-----------+");
					System.out.println("");

				}
			}

		} while (choice5(choice));
		System.out.print("Received Amount : ");
		int amount = sc.nextInt();
		if (amount == total) {
			System.out.print("There is no more change for you. :)");
		} else if (amount > total) {
			System.out.printf("Your change is %d.\n", amount - total);
		} else {
			System.out.printf("Please input more money !\n");
			int aAmount = 0;
			int count = 0;
			int bAmount = 0;
			int cAmount = 0;

			do {
				if (count == 0) {
					System.out.printf("Your total is %d please add %d more.\n", total, total - amount);
					System.out.print("+ ");
					aAmount = sc.nextInt();
					if ((aAmount) == (total - amount)) {
						System.out.println("There is no more change for you. :)");
						System.out.println("");
						break;
					} else if ((aAmount) > (total - amount)) {
						System.out.printf("Your change is %d.\n", aAmount - (total - amount));
						
					}
					count++;
				} else if (count > 0){
					int zTotal = total - amount - aAmount;
					System.out.printf("Your total is %d please add %d more.\n", total, zTotal - cAmount);
					System.out.print("+ ");
					bAmount = sc.nextInt();
					if ((bAmount) == (zTotal - cAmount)) {
						System.out.println("There is no more change for you. :)");
						System.out.println("");
						break;
					} else if ((bAmount) > (zTotal - cAmount)) {
						System.out.printf("Your change is %d.\n", bAmount - (zTotal - cAmount));
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

}
