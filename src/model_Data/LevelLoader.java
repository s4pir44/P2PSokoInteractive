package model_Data;

import java.io.IOException;
import java.io.InputStream;

/**<p>
*QUESTION A-D:<br/>
*<hr />
*A.the Separation is done by using the Level class in order to 
*store the data and the LevelLoader to perform the loading process into it. <br />
*Level stores the data that we want to access/save/load. <br />
*LevelLoader - Loads the data to the Level object<br />
*LevelSave  - Saves the data from the level object<br />
*B.This separation maintains the open/close principle because if we have errors in the load or save process<br />
*we'll know where it is and if it is working ok we won't touch it and won't change anything and if we will need to add another loader is not crate any problems for the others loader.<br />
*C.The separation uses 'Liskov Substitution Principle' like this:<br/>
*  'LoadLevel' gets a general 'InputStream' as a parameter, and the overriding methods use methods from the abstract class 'InputStream',<br/> so they are defined for each specific kind of 'InputStream' (FileInputStream, ObjectInputStream...)
*D.We choose to use OutputStream and not which String file name because in this way we can load an save not only files .<br/> we can create more class of loading that if tomorrow the file we get is different.<br />
*/ 


public interface LevelLoader {
	

	public Level load(InputStream in) throws IOException, ClassNotFoundException;
	
	
}
