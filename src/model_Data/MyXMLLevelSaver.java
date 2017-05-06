package model_Data;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.OutputStream;

public class MyXMLLevelSaver implements LevelSaver {

	
	public void save(Level saveMe, OutputStream out) throws IOException {
		XMLEncoder e=new XMLEncoder(out);
		e.writeObject(saveMe);
		e.close();

	}

}

