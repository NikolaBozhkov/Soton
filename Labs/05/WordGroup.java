import java.util.*;

public class WordGroup {
	public String words;
	
	public WordGroup(String words) {
		this.words = words.toLowerCase();
	}
	
	public String[] getWordArray() {
		return this.words.split(" ");
	}
	
	// Returns a HashSet of the words in self and the given group
	public HashSet<String> getWordSet(WordGroup wordGroup) {
		HashSet<String> set = new HashSet<String>();
		
		// Put both word group's words in one set
		for (String word : this.getWordArray()) {
			set.add(word);
		}
		
		for (String word : wordGroup.getWordArray()) {
			set.add(word);
		}
		
		return set;
	}
	
	// Returns a HashMap of each word mapped to the number of occurances
	public HashMap<String, Integer> getWordCounts() {
		HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
		
		// Count occurances and map to word
		for (String word : this.getWordArray()) {
			int count = wordsCount.getOrDefault(word, 0) + 1;
			wordsCount.put(word, count);
		}
		
		return wordsCount;
	}
}
