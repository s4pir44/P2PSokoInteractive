package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LevelLoaderGUI {

	
	public char[][] loadLevel(String fileName) throws FileNotFoundException, IOException{
		Map<String,Integer> dimenssions = GetMaxDimensions(fileName);
		char[][] mazeData = new char[dimenssions.get("row")][dimenssions.get("col")];
		
		int lineCounter = 0;
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		
		
		for(String line; (line = br.readLine()) != null && lineCounter != mazeData.length;) {
			System.out.println(line);
			int index = 0;
			while(index < dimenssions.get("col"))
			{
				if(index < line.length())
				{
					System.out.println(index);
					
					mazeData[lineCounter][index] = line.charAt(index);
				}
				else mazeData[lineCounter][index] = 'z';
				++index;
			}
			
			lineCounter++;
		}
		return mazeData;
	}
	
	
	
	private Map<String,Integer> GetMaxDimensions(String fileName) throws FileNotFoundException, IOException{
		int row = 0;
		int col = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        row++;
		        
		        if(line.length() > col){
		        	col = line.length();
		        }
		    }
		    // line is not visible here.
		}
		Map<String, Integer> dimenssions=  new HashMap<>();
		dimenssions.put("row", row);
		dimenssions.put("col", col);
		return dimenssions;
	}
}
