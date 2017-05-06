package model_Data;

import java.awt.Point;

public class Wall extends NotMovableObj {
	
	private String charValue="#";
	
	public Wall(){}
	
	public Wall (Point p)
	{
		
		this.place.setLocation(p);

	}

	
	// Get item's name
	public String getName() {
		return "wall";
	}

	public String getCharValue() {
		return charValue;
	}

	public void setCharValue(String charValue) {
		this.charValue = charValue;
	}

}
