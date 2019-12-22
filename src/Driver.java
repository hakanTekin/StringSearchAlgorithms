
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
		Experiments experiment = new Experiments(pattern, inputFile);
	}

}
