package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class viewGUIcontroler extends Canvas{
	
	int [][] mazeData;

	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
	}
	
	private void redrow() {
		if (mazeData != null){
			
			double W = getWidth();
			double H = getHeight();
			double w = W/mazeData[0].length;
			double h = H/ mazeData.length;
			GraphicsContext gc = getGraphicsContext2D();
			for(int i=0;i<mazeData.length;i++)
				for(int j=0;j<mazeData[0].length;j++){
					if(mazeData[i][j]!=0)//
						gc.fillRect(j*w, i*h, w, h);
				}
					
			
			
		}

	}

}
