import Dependencies.BoyerMoore;
import Dependencies.Brute;
import Dependencies.KMP;
import Dependencies.RabinKarp;

public class SearchAlgorithmTracer {
	public static void main(String[] args) {
		int R = 26;
		String text = "ABABABABAABABABABAAAAAAAA";
		String pattern ="ABABABAB";
		SearchAlgorithmTracer sat = new SearchAlgorithmTracer(R, text, pattern);
	}
	
	int R;
	String text, pattern;
	public SearchAlgorithmTracer(int R, String text, String pattern) {
		this.pattern = pattern;
		this.R = R;
		this.text = text;
		traceBrute();
		traceKMP();
		traceBM();
		traceRK();
	}
	
	private void traceBrute() {
		System.out.println("-----------------------------------");
		System.out.println("Brute Force trace: ");
		Brute brute = new Brute();
		brute.searchTrace(pattern,text);
		System.out.println("-----------------------------------");
	}
	private void traceKMP() {
		System.out.println("-----------------------------------");
		System.out.println("Knuth Morris Pratt trace: ");
		KMP kmp = new KMP(pattern);
		kmp.searchTrace(text);
		System.out.println("-----------------------------------");
	}
	private void traceBM() {
		System.out.println("-----------------------------------");
		System.out.println("Boyer Moore trace: ");
		BoyerMoore bm = new BoyerMoore(pattern);
		bm.searchTrace(text);
		System.out.println("\n-----------------------------------");
	}
	private void traceRK() {
		System.out.println("-----------------------------------");
		System.out.println("Rabin Karp trace: \n");
		RabinKarp bm = new RabinKarp(pattern);
		bm.searchTrace(text);
		System.out.println("-----------------------------------");
	}
	
	private void traceTheBestAlgorithmOfAll() {//Which is brute force obviously.
	}
}