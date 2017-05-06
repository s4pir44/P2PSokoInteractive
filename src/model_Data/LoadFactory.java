package model_Data;


import java.util.HashMap;

public class LoadFactory {

	HashMap<String, Creator> loadCreators;
	public String path;

	public LoadFactory() {

		loadCreators = new HashMap<String, Creator>();
		loadCreators.put("obj", new MyObjecLevelLoaderCreator());
		loadCreators.put("txt", new MyTextLevelLoaderCreator());
		loadCreators.put("xml", new MyXMLLevelLoaderCreator());
		// notice, takes O(n) memory

	}

	public LevelLoader createLoader(String path) {
		String extension = "";
		this.path=path;

		int i = path.lastIndexOf('.');
		if (i > 0) {
			extension = path.substring(i + 1);
			Creator c = loadCreators.get(extension);
			// takes O(1) time!
			if (c != null)
				return c.create();
		}
		return null;
	}

	private interface Creator {
		public LevelLoader create();
	}

	private class MyObjecLevelLoaderCreator implements Creator {
		public LevelLoader create() {
			return new MyObjectLevelLoader();
		}
	}

	private class MyTextLevelLoaderCreator implements Creator {
		public LevelLoader create() {
			return new MyTextLevelLoader();
		}
	}

	private class MyXMLLevelLoaderCreator implements Creator{
		public LevelLoader create() {
		return new MyXMLLevelLoader();
		}


}}

