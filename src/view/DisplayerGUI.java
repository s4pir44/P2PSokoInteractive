package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class DisplayerGUI extends Canvas {

	@FXML
	private char[][] mazeData;
	private StringProperty wallFileName;
	private StringProperty playerFileName;
	private StringProperty targetFileName;
	private StringProperty boxFileName;
	private StringProperty floorFileName;


	int cCol, cRow;
	
	public DisplayerGUI() {
		cCol = 0;
		cRow = 0;
		wallFileName = new SimpleStringProperty();
		playerFileName = new SimpleStringProperty();
		targetFileName = new SimpleStringProperty();
		boxFileName = new SimpleStringProperty();
		floorFileName=new SimpleStringProperty();
	}
	
	public void setCharacterPoints(int row,int col) {
		cRow=row;
		cCol=col;
		redraw();

	}
	
	



	public void setMazeData(char[][] mazeData) {
		this.mazeData = mazeData;
		redraw();
	}
	
	private void drawMazeObject(GraphicsContext gc, Image mazeObjImage, double x, double y, double w, double h)
	{
		if(mazeObjImage == null) 
			gc.fillRect(x,y,w,h);
		else 
			gc.drawImage(mazeObjImage, x,y,w,h);
	}
	
	private void redraw() {
		if (mazeData != null){
	
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
					
					if(mazeData[i][j]!='z')
						{
						if(mazeData[i][j]=='#')
							imageMazeObj = wall;
						if(mazeData[i][j]=='!')
							imageMazeObj = player;
						if(mazeData[i][j]=='o')
							imageMazeObj = target;
						if(mazeData[i][j]=='@')
							imageMazeObj = box;
						if(mazeData[i][j]==' ')
							imageMazeObj = floor;
						drawMazeObject(gc,imageMazeObj, j*w, i*h, w, h);
						
						}
						
					
					
				}
					
		/*	gc.setFill(Color.RED);
			gc.fillOval(cCol*w,cRow*h, w, h);*/
			
		}

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
}
