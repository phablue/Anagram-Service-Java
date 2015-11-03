package anagram;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Words {
	public HashMap<String, String> anagramMap;
	private Helper helper;

	public Words(Helper helper) {
		this.helper = helper;
		anagramMap = createAnagramMap();
	}

	public HashMap<String, String> createAnagramMap() {
		HashMap<String, String> anagramMap = new HashMap<String, String>();

		try {
			BufferedReader reader = helper.createReaderFromURL();
			String word, sortedWord = null;

	        while ((word = reader.readLine()) != null) {
	        	sortedWord = helper.sort(word);
	        	anagramMap.put(word, sortedWord);
	        }
	        reader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return anagramMap;
	}

	public ArrayList<String> getAnagramFromMapBy(String input) {
		ArrayList<String> anagrams = new ArrayList<String>();
		int i = 0;

		for (String word : anagramMap.keySet()) {
			if (availableAnagram(word, input.toLowerCase())) {
				anagrams.add(i, word);
				i++;
			}
		}
		Collections.sort(anagrams);

		return anagrams;
	}

	private boolean availableAnagram(String word, String input) {
		String sortedInput = helper.sort(input);

		return existentValue(word, sortedInput) && differentFromInput(word, input);
	}

	private boolean existentValue(String word, String input) {
		return anagramMap.get(word).equals(input);
	}

	public boolean differentFromInput(String word, String input) {
		return !(word.equals(input));
	}
}
