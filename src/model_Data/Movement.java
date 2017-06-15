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
		/*if(num==-2)
		{
			Game.getInstance().getLevel().getBoard().get((int)playerPoint.getX()).set((int)playerPoint.getY(),new Space());
			Game.getInstance().getLevel().getPlayer().place=nextPoint;
			
			
		}*/
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
		if(num==-3)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
			Game.getInstance().getLevel().getBoard().get((int)playerPoint.getX()).set((int)playerPoint.getY(), new Space(new Point(x, y)));
		}
		if(num==-2)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			SokobanObj target = Game.getInstance().getLevel().getTargetInPosition(playerPoint);
			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
			if(target != null)
				Game.getInstance().getLevel().getBoard().get(x).set(y, target);
		}
		if(num == -4)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			SokobanObj playerTarget = Game.getInstance().getLevel().getTargetInPosition(playerPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextNextPoint.getX()).set((int)nextNextPoint.getY(), Game.getInstance().getLevel().getObjectAtPosition(nextPoint));
			BoxTarget target = (BoxTarget)Game.getInstance().getLevel().getTargetInPosition(nextNextPoint);
			target.setIfFull(true);
			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
			if(playerTarget != null)
				Game.getInstance().getLevel().getBoard().get(x).set(y, playerTarget);
		}
		if(num == -8)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			BoxTarget boxTarget = (BoxTarget)Game.getInstance().getLevel().getTargetInPosition(nextPoint);
			boxTarget.setIfFull(false);
			SokobanObj playerTarget = Game.getInstance().getLevel().getTargetInPosition(playerPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextNextPoint.getX()).set((int)nextNextPoint.getY(), Game.getInstance().getLevel().getObjectAtPosition(nextPoint));
			BoxTarget target = (BoxTarget)Game.getInstance().getLevel().getTargetInPosition(nextNextPoint);
			target.setIfFull(true);
			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
			if(playerTarget != null)
				Game.getInstance().getLevel().getBoard().get(x).set(y, playerTarget);
		}
		if(num == -9)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			BoxTarget boxTarget = (BoxTarget)Game.getInstance().getLevel().getTargetInPosition(nextPoint);
			boxTarget.setIfFull(false);
			SokobanObj playerTarget = Game.getInstance().getLevel().getTargetInPosition(playerPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextNextPoint.getX()).set((int)nextNextPoint.getY(), Game.getInstance().getLevel().getObjectAtPosition(nextPoint));
			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
			if(playerTarget != null)
				Game.getInstance().getLevel().getBoard().get(x).set(y, playerTarget);
		}
		if(num == -10)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			
			SokobanObj playerTarget = Game.getInstance().getLevel().getTargetInPosition(playerPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextNextPoint.getX()).set((int)nextNextPoint.getY(), Game.getInstance().getLevel().getObjectAtPosition(nextPoint));
			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
			if(playerTarget != null)
				Game.getInstance().getLevel().getBoard().get(x).set(y, playerTarget);
		}
		if(num == -5)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			BoxTarget boxTarget = (BoxTarget)Game.getInstance().getLevel().getTargetInPosition(nextPoint);
			boxTarget.setIfFull(false);
			
			Game.getInstance().getLevel().getBoard().get((int)nextNextPoint.getX()).set((int)nextNextPoint.getY(), Game.getInstance().getLevel().getObjectAtPosition(nextPoint));
			BoxTarget target = (BoxTarget)Game.getInstance().getLevel().getTargetInPosition(nextNextPoint);
			target.setIfFull(true);
			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
			Game.getInstance().getLevel().getBoard().get(x).set(y, new Space(new Point(x, y)));
		}
		
		if(num == -6)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			Game.getInstance().getLevel().getBoard().get((int)nextNextPoint.getX()).set((int)nextNextPoint.getY(), Game.getInstance().getLevel().getObjectAtPosition(nextPoint));
			BoxTarget target = (BoxTarget)Game.getInstance().getLevel().getTargetInPosition(nextNextPoint);
			target.setIfFull(true);
			
			//TODO: the line 48 doing swap (2,2)to(2,2)
			Game.getInstance().getLevel().getPlayer().setPlace(nextPoint);
			Game.getInstance().getLevel().getBoard().get((int)nextPoint.getX()).set((int)nextPoint.getY(), Game.getInstance().getLevel().getPlayer());
			Game.getInstance().getLevel().getBoard().get(x).set(y, new Space(new Point(x, y)));
			
		}
		if(num == -7)
		{
			int x = (int)playerPoint.getX();
			int y = (int)playerPoint.getY();
			BoxTarget boxTarget = (BoxTarget)Game.getInstance().getLevel().getTargetInPosition(nextPoint);
			boxTarget.setIfFull(false);
			Game.getInstance().getLevel().swapTwoBoardObjs(nextNextPoint, nextPoint);
			Game.getInstance().getLevel().swapTwoBoardObjs(nextPoint, playerPoint);
			
		}
		/*if(num==-4)
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
			}*/
	}

}
