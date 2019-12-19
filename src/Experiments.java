import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Dependencies.BoyerMoore;
import Dependencies.Brute;
import Dependencies.KMP;
import Dependencies.RabinKarp;

public class Experiments {

	
	static String pattern = "it is a far, far better thing that I do, than I have ever done.";
	static String txt;
	final int R = 26;
	String inputFile;
	
	public Experiments(String pattern,int R, String inputFile) {
		
		this.pattern = pattern;
		this.inputFile = inputFile;
		
		createTextString();
		
		runBrute();
		runKMP();
		runRK();
		runBM();
		
	}
	
	private void createTextString() {
		
		try {
			txt = Files.readString(Paths.get(this.inputFile));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

}
