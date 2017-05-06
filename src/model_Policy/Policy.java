package model_Policy;

import java.awt.Point;

import model_Data.Level;
import view.Game;

public class Policy extends Level {



	private static final long serialVersionUID = 1L;

	//the Point is the place we want to go to.
	//we are in this .
	//in this function we check if we are capable movement
	public Policy() {

	}

	public Point WherWeGo (Point p,Point z)
	{

		if(z.getX()==p.getX())
		{
			if(z.getY()>p.getY())
				return (new Point  ((int)p.getX(),(int)p.getY()+2));
			return (new Point  ((int)p.getX(),(int)p.getY()-2));
		}
		if(z.getY()==p.getY())
		{
			if(z.getX()>p.getX())
				return (new Point  ((int)p.getX()+2,(int)p.getY()));
			return (new Point  ((int)p.getX()-2,(int)p.getY()));
		}
		return null;
	}

	//function that get (Point,direction-up/down/left/right)

	public Point getNextPoint (Point p,String goTo,int numberOfSteps)
	{
		Point nextPointToReturn = null;

		switch(goTo)
		{
		case "up":
			nextPointToReturn = new Point((int)p.getX()-numberOfSteps,(int)p.getY());
			break;

		case "down":

			nextPointToReturn=new Point((int)p.getX()+numberOfSteps,(int)p.getY());

			break;

		case "left":

			nextPointToReturn= new Point((int)p.getX(),(int)p.getY()-numberOfSteps);

			break;

		case "right":

			nextPointToReturn=new Point((int)p.getX(),(int)p.getY()+numberOfSteps);

			break;
		default:
			return null;
		}


		return isPointInBoardLimits(Game.getInstance().getLevel(), nextPointToReturn)? nextPointToReturn : null;
	}




	//-1=false=we are not capable of movement
	//0=null=is't a box target
	//1=true=we are capable of movement
	//2=true=the point z is't a box target
	//3=true= move the player and the box


	//p=the player point
	//z= the destination o the player.int one step

	private boolean isPointInBoardLimits(Level level, Point p)
	{
		int numOfLines = level.getBoard().size();
		if(p.getX() >  numOfLines - 1)
			return false;
		int columnLimit = level.getBoard().get((int)p.getX()).size();
		if(p.getY() >  columnLimit - 1)
			return false;
		return true;
	}

	public int checkPlayer(Level level,Point p,Point z ){

		if(!isPointInBoardLimits(level, p) || !isPointInBoardLimits(level, z))
			return -1;

		if(level.getBoard().get((int)p.getX()).get((int)p.getY()) != null)///
		{
			if(level.getBoard().get((int)p.getX()).get((int)p.getY()).getName()=="boxTarget")//אם המיקום על הלוח איפה שהשחקן נמצא הוא 
			{
				if(level.getBoard().get((int)z.getX()).get((int)z.getY()).getName()=="space")
					return-4;
				if(level.getBoard().get((int)z.getX()).get((int)z.getY()).getName()=="boxTarget")
					return-5;
				if(level.getBoard().get((int)z.getX()).get((int)z.getY()).getName()=="box")
					return-6;
			}

			if(level.getBoard().get((int)z.getX()).get((int)z.getY()).getName()== "wall")
			{
				return -1;
			}
			if(level.getBoard().get((int)z.getX()).get((int)z.getY()).getName()=="space")
			{
				return 1;
			}
			if(level.getBoard().get((int)z.getX()).get((int)z.getY()).getName()=="boxTarget")
			{
				return 0;
			}

			if(level.getBoard().get((int)z.getX()).get((int)z.getY()).getName()=="target")
			{
				return -2;
			}
			if(level.getBoard().get((int)z.getX()).get((int)z.getY()).getName()=="box")
			{
				Point next=WherWeGo(p, z);//לבדוק את הreturn  הראשון 
				if(!isPointInBoardLimits(level, next))
					return -1;
				String nextObj=level.getBoard().get((int)next.getX()).get((int)next.getY()).getName();

				if(nextObj=="wall" || nextObj=="box" ||next==null)
					return -1;
				if(nextObj=="boxTarget")
					return 2;
				if(nextObj=="space")
					return 3;
			}
		}
		return -1;
	}

}
