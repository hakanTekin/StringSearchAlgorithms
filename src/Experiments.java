import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

import Dependencies.BoyerMoore;
import Dependencies.Brute;
import Dependencies.KMP;
import Dependencies.RabinKarp;

public class Experiments {

	
	static String pattern = "It is a far, far better thing that I do, than I have ever done";
	static String txt;
	final int R = 26;
	String inputFile;
	
	public Experiments(String pattern, String inputFile) {
		
		this.pattern = pattern;
		this.inputFile = inputFile;
		
		System.out.println("Searching for \""+pattern+"\" in "+inputFile);
		
		createTextString();
		
		isFound();
		System.out.println();
		
		runBrute();
		runKMP();
		runRK();
		runBM();
		
	}
	
	private void createTextString() {
		
		/*try {
			
			Scanner scanner = new Scanner( new File(inputFile));
			
			//txt = scanner.useDelimiter("\\A").next();
			scanner.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//String content = "";
		 
        try
        {
            txt = new String ( Files.readAllBytes( Paths.get(inputFile) ) );
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        //System.out.println(txt);
		
	}
	
	public static double runBrute() {

		double start = System.currentTimeMillis();

		Brute brute = new Brute();
		
		brute.search1(pattern,txt);
		
		
		double end = System.currentTimeMillis();

		System.out.println("Brute Force took: "+(end-start)+"ms");

		return (end-start);

	}

	public static double runKMP() {

		double start = System.currentTimeMillis();

		KMP kmp = new KMP(pattern);
		kmp.search(txt);
		

		double end = System.currentTimeMillis();

		System.out.println("Knuth-Morris-Platt took: "+(end-start)+"ms");

		return (end-start);

	}

	public static double runRK() {

		double start = System.currentTimeMillis();

		RabinKarp rk = new RabinKarp(pattern);
		rk.search(txt);
		double end = System.currentTimeMillis();

		System.out.println("Rabin-Karp took: "+(end-start)+"ms");

		return (end-start);

	}

	public static double runBM() {

		double start = System.currentTimeMillis();

		BoyerMoore bm = new BoyerMoore(pattern);
		bm.search(txt);

		double end = System.currentTimeMillis();

		System.out.println("Boyer-Moore took: "+(end-start)+"ms");

		return (end-start);

	}
	
	public static void isFound() {
		
		BoyerMoore bm = new BoyerMoore(pattern);
		int temp = bm.search(txt);
		
		if(temp>=0) {
			System.out.println("Found in i= "+temp);
		}
		else {
			System.out.println("Pattern not found");
		}
	}

}
