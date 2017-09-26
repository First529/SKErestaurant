package first;

import java.util.Scanner;

public class f {
	
	
	static int total1 = 0; 
	static int total2 = 0; 
	static int total301 = 0, total302 = 0, total303 = 0; 
	static int total = 0;
	
	
	public static int choicePizza(int c, int q){
		total1 += 250 * q;
		total += total1;
		return total1;
	}
	public static int choiceChicken(int c, int q){
		total2 = 120 * q;
		total += total2;
		return total2;
	}
	public static int choiceOrange(int c, int q){
		total301 = 65 * q;
		total += total301;
		return total301;
	}
	public static int choiceCoke(int c, int q){
		total302 = 45 * q;
		total += total302;
		return total302;
	}
	public static int choiceWater(int c ,int q){
		total303 = 20 * q;
		total += total303;
		return total303;
	}
	public static boolean choice5(int choice){
		
		if (choice != 5){
			return true;
		}
		return false;
		
	}
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		System.out.printf("1.) Pizza\t 250 Baht.\n");
		System.out.printf("2.) Chickens\t 120 Baht.\n");
		System.out.printf("3.) Beverage\t 45 Baht.\n");
		System.out.printf("4.) Total\t\n");
		System.out.printf("5.) Exit\t\n");

		int choice;
		int quantity;
		int count1 = 0; int count2 = 0; int count301 = 0 ; int count302 = 0; int count303 = 0;
		int counter1 = 0; int counter2 = 0; int counter301 = 0; int counter302 = 0; int counter303 = 0; 
		int tcount = 0;
		
		do {
			System.out.print("Enter your Choice: ");
			choice = sc.nextInt();
			if (choice5(choice)) {
				switch (choice) {

				case 1:
					System.out.print("Enter Quantity: ");
					quantity = sc.nextInt();
					System.out.println("");
					choicePizza(choice , quantity);
					count1 += quantity;
					counter1++;
					tcount++;
					break;
				case 2:
					System.out.print("Enter Quantity: ");
					quantity = sc.nextInt();
					System.out.println("");
					choiceChicken(choice, quantity);
					count2 += quantity;
					counter2++;
					tcount++;
					break;
				case 3:
					System.out.print("3.1) Orange juice\t 65 baht.\n");
					System.out.print("3.2) Coke\t\t 45 baht.\n");
					System.out.print("3.3) Mineral water\t 20 baht.\n");
					System.out.print("Choose your drink: ");
					int subchoice = sc.nextInt();
					System.out.print("Enter Quantity: ");
					quantity = sc.nextInt();
					System.out.println("");
					if (subchoice == 1){
						choiceOrange(subchoice, quantity);
						count301 += quantity;
						counter301++;
						tcount++;
						break;
					}
					if (subchoice == 2){
						choiceCoke(choice, quantity);
						count302 += quantity;
						counter302++;
						tcount++;
						break;
					}
					if (subchoice == 3){
						choiceWater(choice, quantity);
						count303 += quantity;
						counter303++;
						tcount++;
						break;
					}
				case 4:
					System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
					if (total1 >= 250){
						for (int i = 1; i <= 1 ; i++){
							System.out.printf("| %s\t\t   |%9d|%11d|\n", "Pizza" , count1, total1);
						}
					}
					if (total2 >= 120){
						for (int i = 1; i <= 1 ; i++){
							System.out.printf("| %s\t   |%9d|%11d|\n", "Chickens" , count2, total2);
						}
					}
					if (total301 >= 65){
						for (int i = 1; i <= 1 ; i++){
							System.out.printf("| %s\t   |%9d|%11d|\n", "Orange juice" , count301, total301);
						}
					}
					if (total302 >= 45){
						for (int i = 1; i <= 1 ; i++){
							System.out.printf("| %s\t\t   |%9d|%11d|\n", "Coke" , count302, total302);
						}
					}
					if (total303 >= 20){
						for (int i = 1; i <= 1 ; i++){
							System.out.printf("| %s\t   |%9d|%11d|\n", "Mineral Water" , count303, total303);
						}
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
		if (amount == total){
			System.out.print("There is no more change for you. :)");
		}
		else if (amount > total){
			System.out.printf("Your change is %d.\n", amount-total);
		}
		else {
			System.out.printf("Please input more money !\n");
			int aAmount = 0;
			int count = 0;
			int bAmount = 0;
			int cAmount =0;
			do{
				if (count == 0){
				System.out.printf("Your total is %d please add %d more.\n",total, total-amount);
				System.out.print("+ ");
				aAmount = sc.nextInt();
				if ((aAmount) == (total-amount)){
					System.out.println("There is no more change for you. :)");
					System.out.println("");
					break;
				}
				else if ((aAmount) > (total-amount)){
					System.out.printf("Your change is %d.\n",  aAmount - (total-amount));
					
				}
				count++;
				} else {
					System.out.printf("Your total is %d please add %d more.\n",total, total-amount-aAmount-cAmount);
					System.out.print("+ ");
					bAmount = sc.nextInt();
					if ((bAmount) == (total-amount-aAmount-cAmount) ){
						System.out.println("There is no more change for you. :)");
						System.out.println("");
						break;
					}
					else if ((bAmount) > (total-amount-aAmount-cAmount)){
						System.out.printf("Your change is %d.\n",  bAmount - (total-amount-aAmount-cAmount));
						break;
						
				}
					cAmount += bAmount;
				}
			}while (bAmount <= (total-amount-aAmount-cAmount));
		}
			System.out.print("===== Thank you =====");
			
			
		
	}

}

