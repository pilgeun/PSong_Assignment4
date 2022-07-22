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

public class Plot {

	private int x, y, width, depth;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot( Plot p ) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * determines if this plot overlaps the parameter,
	 * returns true if the two plots overlap, false otherwise
	 * 
	 * */
	public boolean overlaps( Plot plot ) {
		
		int x1 = this.x,				
			y1 = this.y,	
			x2 = this.x + this.width,
			y2 = this.y + this.depth,
			x3 = plot.x,
			y3 = plot.y,
			x4 = plot.x + plot.width,
			y4 = plot.y + plot.depth;
		
		if ( (x1 < x4) && (x3 < x2) && (y1 < y4) && (y3 < y2) )
			return true;
		else
			return false;
			
	}
	
	/**
	 * takes a Plot instance and determines if the current plot contains it.
	 * 
	 * */
	public boolean encompasses( Plot plot ) {
		
		int x1 = this.x,
			y1 = this.y,	
			x2 = this.x + this.width,
			y2 = this.y + this.depth,
			x3 = plot.x,
			y3 = plot.y,
			x4 = plot.x + plot.width,
			y4 = plot.y + plot.depth;
		
		if ( (x1 <= x3) && (y1 <= y3) && (x4 <= x2) && (y4 <= y2) )
			return true;
		else
			return false;
			
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	@Override
	/**
	 * Returns the name, city, owner and rent amount for a property
	 * 
	 * */
	public String toString() { //Upper left: (1,1); Width: 3 Depth: 3
		
		return "Upper left: (" + this.x+","+this.y + "); Width: " + this.width + " Depth: " + this.depth;
		
	}
	
}
