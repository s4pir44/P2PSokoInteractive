package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

	int[][] mazeData=null;

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



	public void loadLevel() throws IOException{
		//GET data from server side
		
		mazeData = new int[7][7];

		int lineCounter = 0;
		File file = new File("./resources/level1.txt");
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		for(String line; (line = br.readLine()) != null;) {
			for (int i = 0; i < line.length(); i++) {
				mazeData[lineCounter][i] = line.indexOf(i);
			}
			lineCounter++;
		}
		
		mazeDisplayer.setMazeData(mazeData);
	}
}


