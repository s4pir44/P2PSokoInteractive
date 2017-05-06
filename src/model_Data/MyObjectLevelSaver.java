package model_Data;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectLevelSaver implements LevelSaver {

	public void save(Level saveMe, OutputStream out) throws IOException {
		ObjectOutputStream oos=new ObjectOutputStream(out);
		oos.writeObject(saveMe);
		out.close();
		

	}

}
