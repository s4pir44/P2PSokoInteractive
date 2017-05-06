package model;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IModel {
	public void move(String direction) throws FileNotFoundException, ClassNotFoundException, IOException;
	public void exit();
	public void save1(String sa, String fi) throws IOException;
	public void load1(String lo)throws ClassNotFoundException, IOException;
	void display1();
}
