package model_Data;

import view.Game;

public class DisplayLevel implements IDisplay {

	public void display(Level level) {
			
			String obj;
			
			for(int i=0;i<level.getBoard().size();i++)
		    {	for(int j=0;j<level.getBoard().get(i).size();j++)
		  	{
		    	 obj= level.getBoard().get(i).get(j).getName();
					switch(obj)
					{
					case "wall":
				        System.out.print('#');
						break;
					case "box":
						System.out.print('@');
						break;

					case "player":
					//	if(Game.getInstance().getLevel().getPlayer().getPlace().getX()==i && Game.getInstance().getLevel().getPlayer().getPlace().getY()==j)
						System.out.print('!');
						

						break;
					case "space":
						System.out.print(' ');
						break;
					case "boxTarget":
						if(Game.getInstance().getLevel().getPlayer().getPlace().getX()==i && Game.getInstance().getLevel().getPlayer().getPlace().getY()==j)
							System.out.print('!');
						else
					    	System.out.print('o');
						break;
					}
			
		}
	 System.out.println();
	}
	}
	
		
	
	}


