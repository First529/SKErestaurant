package first;

/**
 * This class is responsible for open and read file from a text file.
 * Then it collects data using an arraylist for the Food object.
 * 
 * @author Dechabhol Kotheeranurak
 */

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class RestaurantManager {
	
//	static ArrayList<Food> menu = new ArrayList<Food>();
	private Scanner sc;
	private static ArrayList<Food> menu;
	private static final String LOCATION = "first/menu.txt";
	private static ClassLoader loader = RestaurantManager.class.getClassLoader();
	
	public InputStream openFile(String location) {
		InputStream input = loader.getResourceAsStream(location);
		
		return input;
	}
	
	public ArrayList<Food> addMenu() {
		ArrayList<Food> menu = new ArrayList<Food>();
		sc = new Scanner(openFile(LOCATION));
		while(sc.hasNextLine()){
			String x = sc.nextLine();
			if (x.startsWith("#") || x.startsWith("-")) {
				x = sc.nextLine();
			} else {
				menu.add(new Food(x.split(";")[0].trim(), Double.parseDouble(x.split(";")[1].trim())));
			}
		}
		sc.close();
		return menu;
	}
		
}

