package view;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;

import javafx.stage.Stage;

public class MyView extends Observable implements IView {

	@Override
	public void displayError(String msg) {

	}

	@Override
	public void start() throws ClassNotFoundException, FileNotFoundException, IOException{
		Cli c= new Cli();
		c.start();
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
