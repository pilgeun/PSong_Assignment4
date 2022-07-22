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

public class ManagementCompany {
	
	final private int MAX_PROPERTY = 5, MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	
	private double mgmFeePer;	// management fee percentage
	private String name, taxID;
	private Property[] properties;
	private Plot plot;		// plot of the ManagementCompany
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, 10, 10);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;	// needs math first?
		this.plot = new Plot(0, 0, 10, 10);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;	// needs math first?
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;	// needs math first?
		this.plot = new Plot(otherCompany.plot.getX(), otherCompany.plot.getY(), 
							otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
	}
	
	public String getName() {
		return this.name;
	}
	
	public Plot getPlot() {
		return this.plot;		
	}
	
	/**
	 * addProperty checks for valid Property parameter
	 * (e.g. not null value, does not encompass or overlap with other properties)
	 * before adding a new property
	 * */
	public int addProperty(Property property) {
		
		if (property == null)
			return -2;
		
		else if ( !this.plot.encompasses(property.getPlot()) )
			return -3;
		
		for (int i = 0; i < this.properties.length; i++)
		{
			if ( this.properties[i] != null && this.properties[i].getPlot().overlaps(property.getPlot()) )
				return -4;
		}
		
		int index = 0;
		boolean full = true;
		
		for (; index < this.properties.length; index++) 
		{ 
			if (this.properties[index] == null) {
				this.properties[index] = new Property(property);
				full = false;
				break;
			}
		}
		
		if (full)	// for loop completed with nothing added 
			index = -1;
		
		return index;
	}
	
	public int addProperty(String name,String city, double rent,String owner) {
	
		int index = 0;
		
		for (; index < this.properties.length; index++) 
		{ 
			if (this.properties[index] == null) {
				this.properties[index] = new Property(name, city, rent, owner);
				break;
			}
		}
			
		return index;
	}
	
	public int addProperty( String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		
		int index = 0;
		
		for (; index < this.properties.length; index++) 
		{ 
			if (this.properties[index] == null) {
				this.properties[index] = new Property(name, city, rent, owner, x, y, width, depth);
				break;
			}
			
			else if (this.properties[4] != null)
				index = -1;
		}
		
		if (this.properties[index] == null)
			index = -2;
		
		if ( !this.plot.encompasses(properties[index].getPlot()) )
			index = -3;
		
		for (int i = 0; i < this.properties.length; i++)
		{
			if ( (index != i)&&(this.properties[index].getPlot().overlaps(this.properties[i].getPlot())) )
				index = -4;
		}
		
		
		return index;
	}
	
	
	public String displayPropertyAtIndex(int i) {
		return this.properties[i].toString();
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public double maxRentProp() {
		
		double maxRent = 0;
		
		for(int i = 0; i < this.properties.length; i++) 
		{
			if (this.properties[i] != null && this.properties[i].getRentAmount() > maxRent)
				maxRent = this.properties[i].getRentAmount();
		}
		
		return maxRent;
	}
	
	public int maxRentPropertyIndex() {
		
		int maxIndex = 0;
		double maxRent = 0;
		
		for(int i = 0; i < this.properties.length; i++) 
		{
			if (this.properties[i] != null && this.properties[i].getRentAmount() > maxRent)
				maxRent = this.properties[i].getRentAmount();
				maxIndex = i;
		}
		
		return maxIndex;	
	}
	
	public double totalRent() {
		
		double total = 0;
		
		for(int i = 0; i < this.properties.length; i++) {
			if (this.properties[i] != null)
				total += this.properties[i].getRentAmount();
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		
		String information = "List of the properties for " + this.name + ", taxID: " + this.taxID + "\n\n";
		
		String line = "";
		for (int l = 0; l < information.length(); l++)
			line += "-";
		
		information += line + "\n";
		
		for(int i = 0; i < this.properties.length; i++) {
			if (this.properties[i] != null)
				information += this.properties[i].toString();
		}
		
		information += "\n" + line + "\n\n total management Fee: " + ((this.mgmFeePer/100)*totalRent());
		
		return information;
	}
	

}
