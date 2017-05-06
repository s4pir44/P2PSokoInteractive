package model_Data;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MyObjectLevelLoader implements LevelLoader {

	@Override
	public Level load(InputStream in) throws IOException, ClassNotFoundException{
		
			
			ObjectInputStream ois =new ObjectInputStream(in);
			Level lvl=(Level) ois.readObject();//מחזיר אובייקט מסוג שלב
			ois.close();
			return lvl;
		}



	
	}


