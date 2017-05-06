package model_Data;

import java.awt.Point;

public class BoxTarget extends NotMovableObj {

	public Boolean ifFull=false;
	private String charValue="o";
	
	 public BoxTarget() {

	} 
	
	 
    	public BoxTarget (Point p)
		{
			this.place.setLocation(p);
		}
		
	
	// Get item's name
	public String getName() {
		return "boxTarget";
	}



	public Boolean getIfFull() {
		return ifFull;
	}



	public void setIfFull(Boolean ifFull) {
		this.ifFull = ifFull;
	}


	public String getCharValue() {
		return charValue;
	}


	public void setCharValue(String charValue) {
		this.charValue = charValue;
	}
	

}
