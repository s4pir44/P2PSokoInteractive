package model_Data;


import java.util.HashMap;
public class SaveFactory {
	

    private HashMap<String, Creator> saveCreators;
	public SaveFactory() {
	saveCreators = new HashMap<String, Creator>();
	saveCreators.put("obj", new MyObjecLevelSaverCreator());
	saveCreators.put("txt", new MyTextLevelSaverCreator());
	saveCreators.put("xml", new MyXMLLevelSaverCreator());
	// notice, takes O(n) memory
 }
	public LevelSaver createSaver(String path) {

			Creator c = saveCreators.get(path);
			// takes O(1) time!
			if (c != null)
				return c.create();
		
		return null;
	}

	public interface Creator {
		public LevelSaver create();
	}

	private class MyObjecLevelSaverCreator implements Creator {
		public LevelSaver create() {
			return new MyObjectLevelSaver();
		}
	}

	private class MyTextLevelSaverCreator implements Creator {
		public LevelSaver create() {
			return new MyTextLevelSaver();
		}
	}

	private class MyXMLLevelSaverCreator implements Creator{
		public LevelSaver create() {
		return new MyXMLLevelSaver();
		}
	}

}
