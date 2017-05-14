package view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class ViewLogic implements Initializable{
	
	int[][] mazeData={
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	};
	
	@FXML
	DisplayerGUI mazeDisplayer;
	
	public ViewLogic(){

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mazeDisplayer.setMazeData(mazeData);
		mazeDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->{mazeDisplayer.requestFocus();});
		
		mazeDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				int r=mazeDisplayer.getcRow();
				int c=mazeDisplayer.getcCol();
				
				
				
				
				if(event.getCode()== KeyCode.UP){
					mazeDisplayer.setCharacterPoints(r-1, c);
					
				}
				if(event.getCode()== KeyCode.DOWN){
					mazeDisplayer.setCharacterPoints(r+1, c);
					
				}if(event.getCode()== KeyCode.RIGHT){
					mazeDisplayer.setCharacterPoints(r, c+1);
					
				}if(event.getCode()== KeyCode.LEFT){
					mazeDisplayer.setCharacterPoints(r, c-1);
					
				}
			}
		});
		
	}

	public int[][] getMazeData() {
		return mazeData;
	}


	
	public void openFile(){
		FileChooser fc=new FileChooser();
		fc.setTitle("Choose level");
		fc.setInitialDirectory(new File("./resources"));
		File choosen = fc.showOpenDialog(null);
		if(choosen!=null){
			System.out.println(choosen.getName());
		}
		
	}
	
}
