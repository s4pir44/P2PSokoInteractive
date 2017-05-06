package view;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application implements View{
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root= FXMLLoader.load(getClass().getResource("view.fxml"));
		Scene scene= new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void bla(String args) {
		launch(null);
	}
	
	public void stageLoader() {
		System.out.println("sjgdhfjasd");
	}
}

