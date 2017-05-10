package view;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class viewGUI extends Application {

	/*
	 * @Override public void start(Stage stage) throws Exception { // TODO
	
	  Auto-generated method stub*/ 
	  
	 
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@FXML
	@Override
	public void start(Stage stage) throws Exception {
		try {
			 BorderPane root = FXMLLoader.load(getClass().getResource("view.fxml")); 
			 Scene scene= new Scene(root, 400, 400); 
			 stage.setScene(scene); 
			 stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
//		Scene scene = new Scene(root);
//		primaryStage.setScene(scene);
//		primaryStage.sizeToScene();
//		primaryStage.show();
	}
	
	public void openFile()
	{
		FileChooser fc= new FileChooser();
		fc.setTitle("Opem maze file");
	//	fc.setInitialDirectory(new File("./resorcs"));
	//	fc.selectedExtensionFilterProperty();
		File chousen = fc.showOpenDialog(null);
		if (chousen !=null)
		{
			System.out.println(chousen.getName());

		}
			
	}
	
	public void stageLoader() {
		System.out.println("sjgdhfjasd");
	}
}
