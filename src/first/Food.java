package first;

public class Food {
	
	private String name;
	private double price;
	
	public Food(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setPrice(double cPrice) {
		this.price = cPrice;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	

}
