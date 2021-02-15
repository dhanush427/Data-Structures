import java.util.*;
public class Word implements Comparable<Word>{

	private String word;
	
	public Word(String word) {
		this.word = word; 
	}
	
	public String toString() {
		return word; 
	}

	public int compareTo(Word word1) {
        return word.toLowerCase().compareTo(word1.toString().toLowerCase());
    }

}
