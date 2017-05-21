package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import util.LevelLoaderGUI;

public class ViewLogic implements Initializable{

	char[][] mazeData=null;

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

	public char[][] getMazeData() {
		return mazeData;
	}



	public void loadLevel() throws IOException{
		//GET data from server
		LevelLoaderGUI levelLoaderGUI = new LevelLoaderGUI();
		mazeDisplayer.setMazeData(levelLoaderGUI.loadLevel("./resources/level1.txt"));
	}
}


