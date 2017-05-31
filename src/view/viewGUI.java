package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.MyGameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Model;


public class viewGUI extends Application implements IView,Initializable{
 
	ViewLogic viewLogicController;
	/*public String[] args;*/
	/*public MyGameController gameController;*/
	
	/*public void initArguments(String[] myArgs)
	{
		args = myArgs;
	}*/
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
			BorderPane root = (BorderPane) loader.load();
			 viewLogicController = loader.getController();
        
			Model model = new Model();
			
	 		
	 		
			
			MyGameController controller = new MyGameController(model, this);
			viewLogicController.addObserver(controller);
			model.addObserver(controller);
			//view.addObserver(controller);
			
			
			
			
			
		/*	 BorderPane root = FXMLLoader.load(getClass().getResource("view.fxml")); 
			
			 FXMLLoader loader2 = new FXMLLoader(getClass().getResource("view.fxml"));

		        
		        ViewLogic viewLogicController = ((ViewLogic)loader2.getController());
		        */
		//	viewLogicController.addObserver(gameController);

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
	public void start() throws ClassNotFoundException, FileNotFoundException, IOException {
		
	}

	
	@Override
	public void displayError(String msg) {
		System.out.println("Error: " + msg);

	 }
/*
	public void registerController(MyGameController controller) {
		// TODO Auto-generated method stub
		gameController = controller;
	}
*/

	@Override
	public void redraw() {
		// TODO Auto-generated method stub
		
		viewLogicController.sendRedraw();
	}		
}



	

