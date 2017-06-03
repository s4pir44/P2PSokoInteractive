package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model_Data.Level;

public class ViewLogic extends Observable implements Initializable{

	/*private SokobanObj[][] mazeData=null;*/
	private Level level = null;
	@FXML
	public DisplayerGUI mazeDisplayer;
public int tmp;
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
				}
				if(event.getCode()== KeyCode.DOWN){
					mazeDisplayer.setCharacterPoints(r+1, c);
					currMove = "down";
				}if(event.getCode()== KeyCode.RIGHT){
					mazeDisplayer.setCharacterPoints(r, c+1);
					currMove = "right";
				}if(event.getCode()== KeyCode.LEFT){
					mazeDisplayer.setCharacterPoints(r, c-1);
					currMove = "left";
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



	public void loadLevel() throws IOException{
		
		List<String> params = new ArrayList<String>();
		String currLoad = "";
		params.add("load");
		params.add("./resources/level1.txt");
		setChanged();
		notifyObservers(params);
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


