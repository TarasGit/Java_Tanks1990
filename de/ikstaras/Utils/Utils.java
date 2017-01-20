package de.ikstaras.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Utils{
	
	public static Integer[][] getMap(String title){
		
		String str;
		List<Integer[]> iList = new LinkedList<Integer[]>();
		Integer[][] resArr = null;
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(title)))){
			
			while((str = reader.readLine()) != null){
				iList.add(str2int_arrays(str.split(" ")));
			}
			
			int i=0;
			resArr = new Integer[iList.size()][];
			for(Integer[] l : iList)
				resArr[i++] = l; 
				
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resArr;
	}
	
	private static Integer[] str2int_arrays(String[] sArr){
		
		Integer[] iArr = new Integer[sArr.length];
		for(int i=0;i<sArr.length;i++){
			iArr[i] = Integer.parseInt(sArr[i]);
		}
		return iArr;
	}
	
}