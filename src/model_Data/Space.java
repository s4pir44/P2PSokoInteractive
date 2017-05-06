package model_Data;

import java.awt.Point;

public class Space extends NotMovableObj {

	private String charValue=" ";
	
	public Space(){}
	
	public Space (Point p)
	{
		
		this.place.setLocation(p);

	}
	
	
	// Get item's name

	public String getName() {
		return "space";
	}


	public String getCharValue() {
		return charValue;
	}



	public void setCharValue(String charValue) {
		this.charValue = charValue;
	}

}
