import java.io.File;

import Dependencies.Stopwatch;

public class SpellCheck {

	public static void main(String[] args) {
		
	}
	
	File dictionary, text;
	
	public SpellCheck(String dictionaryName, String textName){
		this.dictionary = new File(dictionaryName);
		this.text = new File(textName);
	}
}
