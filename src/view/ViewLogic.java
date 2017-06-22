package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.persistence.Persistence;

import com.javahelps.jpa.GameRecordDataBaseManager;
import com.mysql.fabric.xmlrpc.base.Param;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import model_Data.Level;

public class ViewLogic extends Observable implements Initializable{

	public String msgTmp = "BLS BLS";
	/*private SokobanObj[][] mazeData=null;*/
	private Level level = null;
	@FXML
	public DisplayerGUI mazeDisplayer;
public int tmp;
public String currentLevelName = "";
	public ViewLogic(){

	}

	public void sendRedraw()
	{
		if(mazeDisplayer != null)
			mazeDisplayer.redraw();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*mazeDisplayer.setMazeData(mazeData);*/
		mazeDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->{mazeDisplayer.requestFocus();});

		mazeDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				
				List<String> params = new ArrayList<String>();
				//params.add("move");
				String currMove = "";
				
				params.add("move");
			
				
				int r=mazeDisplayer.getcRow();
				int c=mazeDisplayer.getcCol();

				if(event.getCode()== KeyCode.UP){
					mazeDisplayer.setCharacterPoints(r-1, c);
					currMove = "up";
					mazeDisplayer.setNumberOfSteps();
				}
				if(event.getCode()== KeyCode.DOWN){
					mazeDisplayer.setCharacterPoints(r+1, c);
					currMove = "down";
					mazeDisplayer.setNumberOfSteps();
					
				}if(event.getCode()== KeyCode.RIGHT){
					mazeDisplayer.setCharacterPoints(r, c+1);
					currMove = "right";
					mazeDisplayer.setNumberOfSteps();
					
				}if(event.getCode()== KeyCode.LEFT){
					mazeDisplayer.setCharacterPoints(r, c-1);
					currMove = "left";
					mazeDisplayer.setNumberOfSteps();
					
				}
				params.add(currMove);
				setChanged();
				notifyObservers(params);
				//mazeDisplayer.redraw();
			}
		});

	}

	/*public SokobanObj[][] getMazeData() {
		return mazeData;
	}*/

	public void viewScores()
	{
		Popup.display(this);
	}
	
	public void submit()
	{
		try {
			//Persistence.createEntityManagerFactory("JavaHelps2");
		GameRecordDataBaseManager.create("sapir", "level1", 3, 69.09);
		GameRecordDataBaseManager.create("Agam", "level1", 2, 70.09);
		GameRecordDataBaseManager.create("Agam", "level2", 5, 70.09);
		GameRecordDataBaseManager.create("sapir", "level2", 5, 69.09);
		GameRecordDataBaseManager.create("sapir", "level3", 2, 80.09);
        GameRecordDataBaseManager.create("yaniv", "level2", 3, 49.09);
        GameRecordDataBaseManager.create("sigi", "level3", 3, 68.09);
	
		}catch(Exception e)
		{
			int i =7;	
			++i;
			System.out.println(e);
		}
	}
	public void loadLevel() throws IOException{
		/*
		List<String> params = new ArrayList<String>();
		String currLoad = "";
		params.add("load");
		params.add("./resources/level1.txt");
		setChanged();
		notifyObservers(params);
		mazeDisplayer.setTimeStart();
		*/
		FileChooser fc= new FileChooser();
		fc.setTitle("Choose level");
		fc.setInitialDirectory(new File("./resources"));
		File choosen = fc.showOpenDialog(null);
		List<String> params = new ArrayList<String>();
		if (choosen!=null){
			params.add("load");
			params.add(choosen.getPath());
			String tmpName = choosen.getName();
			currentLevelName = tmpName.substring(0,tmpName.indexOf("."));
		//	mazeDisplayer.setLevelName(currentLevelName);
			//TODO: mazeDisplayer.setLevelName(currentLevelName);
		}
		setChanged();
		notifyObservers(params);
		mazeDisplayer.setTimeStart();
		mazeDisplayer.setLevelName(currentLevelName);
	//	mazeDisplayer.redraw();
		
		/*//GET data from server
		LevelLoaderGUI levelLoaderGUI = new LevelLoaderGUI();
		
		File file = new File("./resources/level1.txt");
		FileInputStream fis = null;
	
		try {
		fis = new FileInputStream(file);
		MyTextLevelLoader myTextLevelLoader = new MyTextLevelLoader();
		level = myTextLevelLoader.load(fis);
		mazeDisplayer.setLevel(level);
		mazeDisplayer.setMazeData(ArrayTransformer.parseArray(level.getBoard()));
		System.out.println(level.getLevelName());
		} catch (Exception e) {
			e.printStackTrace();
		}	*/
		
	}
}


