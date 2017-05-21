package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class viewGUI extends Application implements IView,Initializable{

	
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			 BorderPane root = FXMLLoader.load(getClass().getResource("view.fxml")); 
			 Scene scene= new Scene(root, 500, 500); 
			 primaryStage.setScene(scene); 
			 primaryStage.show();
			 primaryStage.setScene(scene);
			 primaryStage.sizeToScene();
			 primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
	}
	
	/*public void openFile()
	{
		FileChooser fc= new FileChooser();
		fc.setTitle("Opem maze file");
    	fc.setInitialDirectory(new File("./resorcs"));
		fc.selectedExtensionFilterProperty();
		File chousen = fc.showOpenDialog(null);
		if (chousen !=null)
		{
			System.out.println(chousen.getName());

		}
			
	}
	*/
	public void stageLoader() {
		
	}

	@Override
	public void displayError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() throws ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}



	
}
