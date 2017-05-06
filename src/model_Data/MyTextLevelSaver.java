package model_Data;

import java.io.IOException;
import java.io.OutputStream;


public class MyTextLevelSaver implements LevelSaver {

	
	public void save(Level saveMe, OutputStream out) throws IOException {
	
	    //the obj
	    String obj;
	    
	    for(int i=0;i<saveMe.getBoard().size();i++)
	    {	for(int j=0;j<saveMe.getBoard().get(i).size();j++)
	  	{
	        obj= saveMe.getBoard().get(i).get(j).getName();
			switch(obj)
			{
			case "wall":
		        out.write('#');
				break;
			case "box":
				 
				break;

			case "player":
			
				break;
			case "space":
			
				break;
			case "boxTarget":
				
				break;
				
			}
			//לרדת שורה 
			}
	  	}
				
			}
	
			


	}
