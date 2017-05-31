package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model_Data.Level;
import model_Data.SokobanObj;
import util.ArrayTransformer;

public class DisplayerGUI extends Canvas {

	@FXML
	private SokobanObj[][] mazeData;
	/*Level level = null;*/
	private StringProperty wallFileName;
	private StringProperty playerFileName;
	private StringProperty targetFileName;
	private StringProperty boxFileName;
	private StringProperty floorFileName;


	private int cCol, cRow;
	
	public DisplayerGUI() {
		wallFileName = new SimpleStringProperty();
		playerFileName = new SimpleStringProperty();
		targetFileName = new SimpleStringProperty();
		boxFileName = new SimpleStringProperty();
		floorFileName=new SimpleStringProperty();
	}
	
	public void setCharacterPoints(int row,int col) {
		/*level.getPlayer().setLocation(row,col); 
		redraw();*/

	}

	
	
	/*public void setMazeData(SokobanObj[][] mazeData) {
		this.mazeData = mazeData;
		redraw();
	}*/
	
	private void drawMazeObject(GraphicsContext gc, Image mazeObjImage, double x, double y, double w, double h)
	{
		if(mazeObjImage == null) 
			gc.fillRect(x,y,w,h);
		else 
			gc.drawImage(mazeObjImage, x,y,w,h);
	}
	
	public void redraw() {
		/*if (mazeData != null){*/
		Level l = getLevel();
		if(l == null)
			return;
		
		
		ArrayList<ArrayList<SokobanObj>> b = l.getBoard();
			mazeData = ArrayTransformer.parseArray(b);
			//TODO delete after debug 
			Image wall = null;
			Image player = null;
			Image box = null;
			Image target = null;
			Image floor = null;
			try {
				wall = new Image(new FileInputStream(getWallFileName()));
				player = new Image(new FileInputStream(getPlayerFileName()));
				box = new Image(new FileInputStream(getBoxFileName()));
				target = new Image(new FileInputStream(getTargetFileName()));
				floor = new Image(new FileInputStream(getFloorFileName()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			double W = getWidth();
			double H = getHeight();
			double w = W/mazeData[0].length;
			double h = H/ mazeData.length;
			Image imageMazeObj = null;
			GraphicsContext gc = getGraphicsContext2D();
			gc.clearRect(0, 0, W, H);
			for(int i=0;i<mazeData.length;i++)
				for(int j=0;j<mazeData[0].length;j++){
					
					if(mazeData[i][j] != null)
						{
						if(mazeData[i][j].getName().equalsIgnoreCase("wall"))
							imageMazeObj = wall;
						if(mazeData[i][j].getName().equalsIgnoreCase("player"))
							imageMazeObj = player;
						if(mazeData[i][j].getName().equalsIgnoreCase("target"))
							imageMazeObj = target;
						if(mazeData[i][j].getName().equalsIgnoreCase("box"))
							imageMazeObj = box;
						if(mazeData[i][j].getName().equalsIgnoreCase("space"))
							imageMazeObj = floor;
						drawMazeObject(gc,imageMazeObj, j*w, i*h, w, h);
						}
				}
	/*	}*/
	}

	public int getcCol() {
		return cCol;
	}

	public int getcRow() {
		return cRow;
	}

	
	public String getWallFileName() {
		return wallFileName.get();
	}

	public void setWallFileName(String wallFileName) {
		this.wallFileName.set(wallFileName);
	}
	

	public String getBoxFileName() {
		return boxFileName.get();
	}

	public void setBoxFileName(String boxFileName) {
		this.boxFileName.set(boxFileName);
	}
	
	public String getPlayerFileName() {
		return playerFileName.get();
	}

	public void setPlayerFileName(String playerFileName) {
		this.playerFileName.set(playerFileName);
	}
	
	public String getTargetFileName() {
		return targetFileName.get();
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName.set(targetFileName);
	}
	
	
	public String getFloorFileName() {
		return floorFileName.get();
	}

	public void setFloorFileName(String floorFileName) {
		this.floorFileName.set(floorFileName);
	}

	public Level getLevel() {
		return Game.getInstance().getLevel();
	}

	/*public void setLevel(Level level) {
		this.level = level;
	}*/
}
