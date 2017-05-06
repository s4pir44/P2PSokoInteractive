package view;


import java.io.FileNotFoundException;
import java.io.IOException;

public interface View {//לזמן את הדיספלי
	
	void displayError(String msg);
	void start() throws ClassNotFoundException, FileNotFoundException, IOException;
	
}
