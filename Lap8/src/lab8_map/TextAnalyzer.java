package lab8_map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	private String word;

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	
	public void load(String fileName) throws IOException {
		// TODO
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        String line = null;
	        int count = 1;
	        while(true) {
	        	line = reader.readLine();
	        	if(line == null) 
	        		break;
	        	StringTokenizer tokens = new StringTokenizer(line + " ");
	        	while(tokens.hasMoreTokens()) {
	        		String word = tokens.nextToken();
	        		if(!tokens.hasMoreTokens())
	        			add(word, -count);
	        		else
	        			add(word, count);
	        		count++;
	        	}
	        }
	       System.out.println(map);
	       reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
	    if (map.containsKey(word)) {
	        map.get(word).add(position);
	    } else {
	        ArrayList<Integer> positions = new ArrayList<>();
	        positions.add(position);
	        map.put(word, positions);
	    }
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
	    Set<String> words = map.keySet();
	    TreeSet<String> sortedWords = new TreeSet<>(words);

	    for (String word : sortedWords) {
	        System.out.print(word + ": ");
	        ArrayList<Integer> positions = map.get(word);

	        for (int position : positions) {
	            System.out.print(position + " ");
	        }

	        System.out.println();
	    }
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		// TODO
		for(String word : map.keySet()){
			System.out.print(word + ": ");
			ArrayList <Integer> positions = map.get(word);
			for(int position : positions) {
				System.out.print(position + ": ");
		}
	System.out.println();
	}
}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
	    String mostFrequent = null;
	    int maxCount = 0;

	    for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
	        int count = entry.getValue().size();

	        if (count > maxCount) {
	            maxCount = count;
	            mostFrequent = entry.getKey();
	        }
	    }

	    return mostFrequent;
	}
public static void main(String[] args) throws IOException {
	TextAnalyzer textAnalyzer = new TextAnalyzer();
	String fileName = "data/short.txt"; 

	textAnalyzer.load(fileName);

	System.out.println(" ");
	textAnalyzer.displayWords();

	System.out.println(" ");
	textAnalyzer.displayText();

	String mostFrequentWord = textAnalyzer.mostFrequentWord();
	System.out.println(" " + mostFrequentWord);
}
}
