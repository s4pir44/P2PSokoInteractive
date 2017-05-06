package model_Data;

import java.awt.Point;

public  abstract  class SokobanObj  {
	
	public SokobanObj() {
		place = new Point();
	}

	// Get item's name
	public abstract String getName();
	
	
	
	public SokobanObj(Point place) {
		setPlace(place);
	}
	
	public Point place;

	public Point getPlace() {
		return place;
	}

	public void setLocation(int x, int y) {
		place.setLocation(x, y);
	}
	
	public void setPlace(Point place) {
		this.place = place;
	}
	
	

}
