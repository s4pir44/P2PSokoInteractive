package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class DisplayerGUI extends Canvas {

	int [][] mazeData;
	StringProperty wallFileName;


	int cCol, cRow;
	
	public DisplayerGUI() {
		cCol = 0;
		cRow = 0;
		
		
		wallFileName = new SimpleStringProperty();
	}
	
	public void setCharacterPoints(int row,int col) {
		cRow=row;
		cCol=col;
		redraw();

	}
	
	public String getWallFileName() {
		return wallFileName.get();
	}


	public void setWallFileName(String wallFileName) {
		this.wallFileName.set(wallFileName);
	}



	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
		redraw();
	}
	
	
	
	private void redraw() {
		if (mazeData != null){
	
			Image wall = null;
			Image player = null;
			Image box = null;
			Image target = null;
			try {
				wall = new Image(new FileInputStream(getWallFileName()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			double W = getWidth();
			double H = getHeight();
			double w = W/mazeData[0].length;
			double h = H/ mazeData.length;
			GraphicsContext gc = getGraphicsContext2D();
			gc.clearRect(0, 0, W, H);
			for(int i=0;i<mazeData.length;i++)
				for(int j=0;j<mazeData[0].length;j++){
					if(mazeData[i][j]!=0)//
						if(wall == null)
							gc.fillRect(j*w, i*h, w, h);
						else 
							gc.drawImage(wall, j*w, i*h, w, h);
				}
					
			gc.setFill(Color.RED);
			gc.fillOval(cCol*w,cRow*h, w, h);
			
		}

	}

	public int getcCol() {
		return cCol;
	}

	public int getcRow() {
		return cRow;
	}


}
