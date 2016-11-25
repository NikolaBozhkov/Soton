import java.util.*;

public class Main {
	public static void main(String[] args) {
		WordGroup platoQuote = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
		WordGroup rooseveltQuote = new WordGroup("When you play play hard when you work dont play at all");
		
		String[] platoQuoteWords = platoQuote.getWordArray();
		String[] rooseveltQuoteWords = rooseveltQuote.getWordArray();
		
		// Print each word in platoQuoteWords
		System.out.println("Plato quote words:");
		for (String word : platoQuoteWords) {
			System.out.println(word);
		}
		
		// Print each word in rooseveltQuoteWords
		System.out.println("\nRoosevelt quote words:");
		for (String word : rooseveltQuoteWords) {
			System.out.println(word);
		}
		
		HashSet<String> platoRooseveltWordSet = platoQuote.getWordSet(rooseveltQuote);
		
		// Print all words in the set of combined words from both quotes
		System.out.println("\nCombined set words: ");
		for (String word : platoRooseveltWordSet) {
			System.out.println(word);
		}
		
		HashMap<String, Integer> platoQuoteWordsCount = platoQuote.getWordCounts();
		HashMap<String, Integer> rooseveltQuoteWordsCount = rooseveltQuote.getWordCounts();
		
		// Print all words in the plato quote's set and their count
		System.out.println("Word counts of plato quote:");
		for (String key : platoQuoteWordsCount.keySet()) {
			System.out.println(key +  " " + platoQuoteWordsCount.get(key));
		}
		
		// Print all words in the roosevelt quote's set and their count
		System.out.println("\nWord counts of roosevelt quote:");
		for (String key : rooseveltQuoteWordsCount.keySet()) {
			System.out.println(key +  " " + rooseveltQuoteWordsCount.get(key));
		}
		
		// Print word counts of both quotes combined
		System.out.println("\nWord counts of both quotes:");
		for (String word : platoRooseveltWordSet) {
			// Sum of occurances in both hash maps
			int platoCount = platoQuoteWordsCount.getOrDefault(word, 0);
			int rooseveltCount = rooseveltQuoteWordsCount.getOrDefault(word, 0);
			int combinedCount = platoCount + rooseveltCount;
			
			System.out.println(word + " " + combinedCount);
		}
	} 
}