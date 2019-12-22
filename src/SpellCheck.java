import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Dependencies.BoyerMoore;
import Dependencies.KMP;
import Dependencies.Stopwatch;
import Dependencies.TST;
import Dependencies.TrieST;

public class SpellCheck {

	//Main function, runs only this program
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the two file names");
		System.out.print("Dictionary Filename : ");
		String dictionaryFileName = "dictionary.txt";//sc.next();
		
		System.out.print("\nText Filename : ");
		String textFileName = "long.txt";//sc.next();
		System.out.println();

		//SpellCheck object created. Constructor does everything to suggest words automatically.
		SpellCheck spellCheck = new SpellCheck(dictionaryFileName, textFileName);
	}

	File dictionary, text;
	TrieST<Integer> dictionaryTrie;

	public SpellCheck(String dictionaryName, String textName){
		this.dictionary = new File(dictionaryName);
		this.text = new File(textName);
		createTrie(); //Tree creation from dictionary file
		Stopwatch sw = new Stopwatch();
		searchText();
		System.out.println("Elapsed Time : " + sw.elapsedTime());
	}

	//Creates a Trie from given file dictionary
	private TrieST<Integer> createTrie() {
		TrieST<Integer> trie = new TrieST<Integer>();
		Scanner sc;
		try {
			
			sc = new Scanner(this.dictionary);
			//For each word in the dictionary. Put lowercase versions to the trie
			for(int i =0; sc.hasNext(); i++) {
				trie.put(sc.next().toLowerCase(), i);
			}
			dictionaryTrie = trie;
			sc.close();
			return trie;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	//Creates a Ternary Trie.
	private TST<Integer> createTST() {
		TST<Integer> trie = new TST<Integer>();
		Scanner sc;
		try {
			sc = new Scanner(this.dictionary);
			for(int i =0; !sc.hasNext(); i++) {
				trie.put(sc.next(), i);
			}
			return trie;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	//Search the text one word at a time. If the word is misspelled, suggest the most similar word(s).
	private void searchText() {
		try {
			Scanner sc = new Scanner(text);
			String curWord;
			int indexCounter = 0; //Counter to know which word the program checks.

			//For each word in the text
			while(sc.hasNext()) {
				curWord = sc.next();
				if(!this.dictionaryTrie.contains(curWord.toLowerCase())){ //if the statement is true, then the word is misspelled
					
					//Print out a message for misspelled word and suggest a new word.
					//SuggestWord can be switched with Suggest3Word. Which suggests 3 words, instead of 1
					System.out.println("Error: " + curWord + "(index:" + indexCounter + ")- suggested: " + suggestWord(curWord));
				}
				indexCounter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	//Suggest function. Starts from the last letter of the word and goes to the start. If a word exists in the dictionary, suggests that word.
	private String suggestWord(String wrongWord) {
		//Initalization
		String suggestion = "";
		
		//for(int i = 0; i<=wrongWord.length()-1; i++) { ///For starting from beginning instead of last letter.
		for(int i = wrongWord.length(); i>0; i--) {
			//Get substring from start to i. Lowercase is taken because dictionary is in lowercase
			String ww = wrongWord.substring(0,i).toLowerCase();
			if(dictionaryTrie.contains(ww)) { //If there is a word in the dictionary that is same with the substring. Then suggestion is found.
				suggestion = ww;
				//Suggestion found, no need to go further.
				break;
			}
		}
		return suggestion;
	}
	
	//Suggests 3 words instead of one
	private String[] suggest3Word(String wrongWord) {
		String[] suggestion = new String[3];
		int count = 0;
		//for(int i = 0; i<=wrongWord.length()-1; i++) {
				for(int i = wrongWord.length(); i>0; i--) {	
					String ww = wrongWord.substring(0,i).toLowerCase();
					if(dictionaryTrie.contains(ww)) {
						suggestion[count++] = ww;
						if(count == 3)
						break;
					}
				}
		return suggestion;
	}
}
