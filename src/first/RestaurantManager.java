package first;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class RestaurantManager {
	
	static ArrayList<String> menuItems = new ArrayList<String>();
	static ArrayList<Double> prices = new ArrayList<Double>();
	static ArrayList<Integer> quantity = new ArrayList<Integer>();
	private Scanner sc;
	
	public void openFile() {
		try {
			sc = new Scanner (new File("src/first/menu.txt"));
		}
		catch(Exception e) {
			System.out.println("Could not find file.");
		}
	}
	
	public void readFile() {
		while(sc.hasNextLine()){
			String x = sc.nextLine();
			if (x.startsWith("#") || x.startsWith("-")) {
				x = sc.nextLine();
			} else {
				menuItems.add(x.split(";")[0].trim());
				prices.add(Double.parseDouble(x.split(";")[1].trim()));
				quantity.add(0);
			}
		}
		sc.close();
	}
	
}

