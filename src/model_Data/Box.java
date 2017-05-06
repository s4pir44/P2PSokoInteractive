package model_Data;
import java.awt.Point;

public class Box extends MovableObj {
	private String charValue="@";
	public String getCharValue() {
		return charValue;
	}

	public void setCharValue(String charValue) {
		this.charValue = charValue;
	}

	public Box ()
	{
		
	}
	
	public Box (Point p)
	{
		//this.setLocation(p);
		this.place.setLocation(p);

	}
	
	
	
	// Get item's name
		public String getName() {
			return "box";
		}
		
		

}
