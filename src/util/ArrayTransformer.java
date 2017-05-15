package util;

import java.util.ArrayList;
import java.util.stream.IntStream;

import model_Data.SokobanObj;

public class ArrayTransformer {
	
	
	public static SokobanObj[][] parseArray(ArrayList<ArrayList<SokobanObj>> arrLst){
		SokobanObj[][] retVal = new SokobanObj[arrLst.size()][];
		
		IntStream.range(0, arrLst.size()).forEach(
				nbr -> {
				
					for (int i = 0; i < retVal[nbr].length; i++) {
						retVal[nbr][i] = arrLst.get(nbr).get(i);
					} 						
				});
		
		return retVal;
	} 
}
