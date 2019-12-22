
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pattern = "It is a far, far better thing that I do, than I have ever done";
		String inputFile = "tale.txt";
		//String pattern = "I say things happen not as we plan";
		//String inputFile = "war+peace.txt";
		//String pattern = "With this emphatic";
		//String inputFile = "dickens.txt";
		//String pattern = "which we are not conscious";
		
		String tracePattern1 = "AAAAAAAAAAAAAAAAAAAAAAAAB";
		String traceText1 = "AAAAAAAB";
		
		String tracePattern2 = "ABABABABAABABABABAAAAAAAA";
		String traceText2 = "ABABABAB";
		
		String spellCheckFileName = "long.txt";
		String spellCheckDictionaryFileName = "dictionary.txt";
		
		System.out.println("\nExperiments : ");
		Experiments experiment = new Experiments(pattern, inputFile);
		System.out.println("\nTracer for Pattern 1 : ");
		SearchAlgorithmTracer sat1 = new SearchAlgorithmTracer(26, traceText1, tracePattern1);
		System.out.println("\nTracer for Patern 2 : ");
		SearchAlgorithmTracer sat2 = new SearchAlgorithmTracer(26, traceText2, tracePattern2);
		System.out.println("\nSpellCheck : ");
		SpellCheck sc = new SpellCheck(spellCheckDictionaryFileName, spellCheckFileName);
	}

}
