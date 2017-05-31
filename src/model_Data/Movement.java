package model_Data;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;

import view.Game;
import model_Policy.Policy;

public class Movement {
	
	public Movement(){}
	
	public void mackMove(String arg) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Policy policy = new Policy();
		int num;
		Point playerPoint= Game.getInstance().getLevel().getPlayer().place;
	    Point nextPoint = policy.getNextPoint(playerPoint, arg, 1);
	    Point nextNextPoint = policy.getNextPoint(playerPoint, arg, 2);
	    if(nextPoint == null)
	    	return;
	    
		num= policy.checkPlayer(Game.getInstance().getLevel(),playerPoint , nextPoint); 
		if (num==1)
			//Game.getInstance().getLevel().swap(playerPoint, nextPoint);
			Game.getInstance().getLevel().swapTwoBoardObjs(playerPoint, nextPoint);
		if(num==-2)
		{
			Game.getInstance().getLevel().getBoard().get((int)playerPoint.getX()).set((int)playerPoint.getY(),new Space());
			Game.getInstance().getLevel().getPlayer().place=nextPoint;
			
			
		}
		if(num > 1)
		{
			if(nextNextPoint == null)
		    	return;
			
			if(num == 2)
			{
				BoxTarget target = (BoxTarget)(Game.getInstance().getLevel().getBoard().get((int)nextNextPoint.getX()).get((int)nextNextPoint.getY()));
				target.setIfFull(true);
			}
			
			Game.getInstance().getLevel().swapTwoBoardObjs(nextNextPoint, nextPoint);
       		Game.getInstance().getLevel().swapTwoBoardObjs(nextPoint, playerPoint);
		}
		if(num==-4)
		{

			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
		}
			if(num==-5)	 
			{
				Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			}
			if(num==-6)
			{
				Game.getInstance().getLevel().swapTwoBoardObjs(nextNextPoint, nextPoint);
				Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(),  Game.getInstance().getLevel().getPlayer());
			}
	}

}
