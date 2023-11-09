package lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() {
		// TODO
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
			if(map.containsKey(word)){
				map.put(word, map.get(word) +1);
			}
			else{
				map.put(word,1);
			}
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		//Cach 2 
		/*
		 * while(input.hasNext){
		 * String word = input.next();
		 * map.put(word,map.getOrderDefaul(word,0)+1)
		 * }
		 * sysout(map);*/
		
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		// TODO
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		// TODO
//		for(Map.Entry<String,Integer> entry : map.entrySet()){
//			System.out.println(entry.getKey() + "-"+ entry.getValue());
//		}
		System.out.println(map);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		// TODO
		Map<String, Integer> sortedMap = new TreeMap<>(map);
		for(Map.Entry<String, Integer> entry : sortedMap.entrySet()){
			System.out.println (entry.getKey() + "-" + entry.getValue());
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
        MyWordCountApp wordCounter = new MyWordCountApp();
        wordCounter.loadData();
        
        System.out.println(wordCounter.countUnique());
        wordCounter.printWordCounts();
        System.out.println("------------");
        wordCounter.printWordCountsAlphabet();
}
}
