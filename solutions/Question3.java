import java.io.*;
import java.util.*;

public class Question3 {

	public static void main(String[] args)  throws FileNotFoundException {
		Scanner scan = new Scanner(new File("../inputs/3.txt"));
		PrintStream output = new PrintStream(new File("../answers/3.txt"));
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> words2 = new ArrayList<String>();
		ArrayList<String> outputWords = new ArrayList<String>();
		while(scan.hasNext()) {
			words.add(scan.next());
			words2.add(scan.next());
		}
		for(int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			if(!isCompound(words, words2, word, 0)) {
				outputWords.add(word);
			}
		}
		for(int i =0; i < outputWords.size(); i++) {
			output.println(outputWords.get(i));
		}
	}
	
	public static boolean isCompound(ArrayList words, ArrayList words2, String word, int start) {
		for (int j = start+1; j <= word.length(); j++) {
			for (int k = 0; k < words.size(); k++) {
				if (word.substring(start, j).equals(words.get(k)) && 
						!(start == 0 && j == word.length())) {
					//words2.indexOf(words.get(k));
					if (j < word.length()) {
						return isCompound(words, words2,word,j);
					} else {
						return true;
					}
				} 
			}
		}
		return false;
	}

}
