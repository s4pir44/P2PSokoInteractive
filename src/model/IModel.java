package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.javahelps.jpa.GameRecord;

public interface IModel {
	public void move(String direction) throws FileNotFoundException, ClassNotFoundException, IOException;
	public void exit();
	public void save1(String sa, String fi) throws IOException;
	public void load1(String lo)throws ClassNotFoundException, IOException;
	public void display1();
	public void submitToDataBase(String recordToSubmit);
	
	public List<GameRecord> pullFromDataBase();
}
