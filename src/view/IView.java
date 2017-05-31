package view;


import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.stage.Stage;

public interface IView {//���� �� �������
	
	void displayError(String msg);
	void start() throws ClassNotFoundException, FileNotFoundException, IOException;
	void start(Stage primaryStage) throws Exception;
	void redraw();
	
}
