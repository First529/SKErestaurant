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
	
	static ArrayList<Food> menu = new ArrayList<Food>();
	private Scanner sc;
	
	static final String LOCATION = "first/menu.txt";
	static ClassLoader loader = RestaurantManager.class.getClassLoader();
	
	public InputStream openFile() {
		InputStream input = loader.getResourceAsStream(LOCATION);
		
		return input;
	}
	
	public void readFile(InputStream temp) {
		sc = new Scanner(temp);
		while(sc.hasNextLine()){
			String x = sc.nextLine();
			if (x.startsWith("#") || x.startsWith("-")) {
				x = sc.nextLine();
			} else {
				menu.add(new Food(x.split(";")[0].trim(), Double.parseDouble(x.split(";")[1].trim())));
			}
		}
		sc.close();
	}
	
}

