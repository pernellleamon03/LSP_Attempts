/** Pernell Leamon **/

package org.howard.edu.lsp.hw2;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import java.io.File;


public class word_counting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> wordCounts = new HashMap<>();
		Scanner fileScanner = null;
		try {
		     fileScanner = new Scanner(new File("src/main/resources/words.txt"));
		      while (fileScanner.hasNext()) {
		        String word = fileScanner.next().toLowerCase();
		        if (word.length() > 3 && !isNum(word)) {
		          wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
		        }
		        //setting rules for what counts as a word (no numbers and words less than 3
		      }
		      for (String word : wordCounts.keySet()) {
		        System.out.println(word + " " + wordCounts.get(word));
		        //print statement for the word and how many times in our .txt file
		      }
		    } catch (FileNotFoundException e) {
		      System.out.println("File not found");
		      // if no file is found print out file not found
		    } finally {
		      if (fileScanner != null) {
		        fileScanner.close();
		       //close scanner
		      }
		    }
		  }
	public static boolean isNum(String word) {
	    try {
	        Double.parseDouble(word);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	        // this function allows us to include numbers that are paired with words to be string values. Therefore it will count as an occurrence
	    }
	}
}



	