package controller;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import view.DisplayerGUI;

public class ControllerGUI implements Initializable{
	
	int[][] mazeData={
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	};
	
	@FXML
	
	DisplayerGUI mazeDyspayer;
	
	public ControllerGUI(){
		mazeDyspayer.setMazeData(mazeData);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mazeDyspayer.setMazeData(mazeData);
		
	}

	public int[][] getMazeData() {
		return mazeData;
	}

	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
	}
	
	public void openFile(){
		FileChooser fc=new FileChooser();
		fc.setTitle("Choose level");
		fc.setInitialDirectory(new File("./Resources"));
		File choosen = fc.showOpenDialog(null);
		if(choosen!=null){
			System.out.println(choosen.getName());
		}
		
	}
	
}
