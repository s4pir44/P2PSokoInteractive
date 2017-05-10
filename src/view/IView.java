package view;


import java.io.FileNotFoundException;
import java.io.IOException;

public interface IView {//לזמן את הדיספלי
	
	void displayError(String msg);
	void start() throws ClassNotFoundException, FileNotFoundException, IOException;
	
}
