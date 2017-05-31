package util;

import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import model_Data.SokobanObj;

public class ArrayTransformer {
	
	
	public static SokobanObj[][] parseArray(ArrayList<ArrayList<SokobanObj>> arrLst){
		
		OptionalInt max = arrLst.stream().mapToInt(innerArray -> innerArray.size()).max();
		
		SokobanObj[][] retVal = new SokobanObj[arrLst.size()][max.getAsInt() + 1];
		
		IntStream.range(0, arrLst.size()).forEach(
				nbr -> {
					for (int i = 0; i < arrLst.get(nbr).size(); i++) {
						retVal[nbr][i] = arrLst.get(nbr).get(i);
					} 						
				});
		
		return retVal;
	} 
}
