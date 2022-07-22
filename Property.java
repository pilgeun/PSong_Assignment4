/*
 * Class: CMSC203 CRN 46519
 * Instructor: Farnaz Eivazi
 * Description: Create a management company and add the properties managed by the company to its list.
 * Due: 7/21/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   Print your Name here: Philip Song
*/

public class Property {
	
	private String propertyName, city, owner;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.owner= "";
		this.rentAmount = 0;
		this.plot = new Plot();
	}
	
	public Property(Property p) {
		this.propertyName = p.getPropertyName();
		this.city = p.getCity();
		this.owner= p.getOwner();
		this.rentAmount = p.getRentAmount();
		this.plot = new Plot(p.getPlot());
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth ) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}

	
	public String getCity() {
		return city;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	@Override
	public String toString() {
		
		return "PropertyName: " + this.propertyName + "\n Located in " + this.city + "\n Belonging to: " + this.owner + "\n Rent Amount: " + this.rentAmount + "\n";
		
	}
	
}
