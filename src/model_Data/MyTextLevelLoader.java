package model_Data;


import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MyTextLevelLoader implements LevelLoader {

	@Override
	public Level load(InputStream in) throws IOException, ClassNotFoundException {

		
		
		ArrayList<ArrayList<SokobanObj>> board = new ArrayList<>();
		board.add(new ArrayList<SokobanObj>());
		ArrayList<BoxTarget> targets = new ArrayList<>();
		Player player = null;
		BoxTarget  boxTarget;
		
	
		//this char in the text 
	    char ch;
	    //the checker
	    int c;
	    //the index of the Piont(x,y)
	    int x=0,y=0;
	    
	    while ((c=in.read()) !=-1) {
	    	ch=(char)c;
			switch(ch)
			{
			case '#':
				board.get(x).add(y, new Wall(new Point(x,y)));
				y++;
				break;
			case '@':
				board.get(x).add(y, new Box(new Point(x,y)));
				y++;
				break;
			case '\n':
				y=0;
				x++;
				board.add(new ArrayList<SokobanObj>());
				break;
			case '!':
				player = new Player(new Point(x, y));
				board.get(x).add(player);
				
				y++;
				break;
			case ' ':
				board.get(x).add(y, new Space(new Point(x, y)));
				y++;
				break;
			case 'o':
				boxTarget = new BoxTarget(new Point(x, y));
				
				board.get(x).add(y, boxTarget);
				targets.add(boxTarget);
				y++;
				break;
				
		
			}
			
				
			}
	 
		return (new Level(player, board,targets));
			
		}


		
}