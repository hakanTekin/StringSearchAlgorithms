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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the two file names");
		System.out.print("Dictionary Filename : ");
		String dictionaryFileName = "dictionary.txt";//sc.next();
		
		System.out.print("\nText Filename : ");
		String textFileName = "testWrongWords.txt";//sc.next();
		System.out.println();

		SpellCheck spellCheck = new SpellCheck(dictionaryFileName, textFileName);
	}

	File dictionary, text;
	TrieST<Integer> dictionaryTrie;

	public SpellCheck(String dictionaryName, String textName){
		this.dictionary = new File(dictionaryName);
		this.text = new File(textName);
		createTrie();
		searchText();
	}

	private TrieST<Integer> createTrie() {
		TrieST<Integer> trie = new TrieST<Integer>();
		Scanner sc;
		try {
			sc = new Scanner(this.dictionary);
			for(int i =0; sc.hasNext(); i++) {
				trie.put(sc.next(), i);
			}
			dictionaryTrie = trie;
			sc.close();
			return trie;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

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
			int indexCounter = 0;

			while(sc.hasNext()) {
				curWord = sc.next();
				if(!this.dictionaryTrie.contains(curWord.toUpperCase())){ //if true, then the word is misspelled
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

	private String suggestWord(String wrongWord) {
		String suggestion = "";
		for(int i = wrongWord.length()-1; i >= 0; i--) {
			String ww = wrongWord.substring(0,i).toUpperCase();
			if(dictionaryTrie.contains(ww)) {
				suggestion = ww;
				break;
			}
		}
		return suggestion;
	}
	private String[] suggest3Word(String wrongWord) {
		String[] suggestion = new String[3];
		return suggestion;
	}
}
