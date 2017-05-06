package model_Data;

import java.awt.Point;

public class Player extends MovableObj {
	
	private String charValue="!";
	
	public Player(){}
	
	public Player (Point p)
	{
		//this.setLocation(p);
		this.place.setLocation(p);

	}
	

	
	
	
	// Get item's name
		public String getName() {
			return "player";
		}

		public String getCharValue() {
			return charValue;
		}

		public void setCharValue(String charValue) {
			this.charValue = charValue;
		}
		
		

}
