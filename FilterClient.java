//Andrew Rogers CS553

/**
 *  Test bed for the Filter design pattern. This is building off the source
 *  material in the project CD where a text file stream is loaded and analyzed.
 *  <P>
 *  This client will test the word counter filter that I created in addition
 *  to the byte count filter that was already included. Additionally, they will
 *  be utilized multiple times and in different orders to demonstrate the 
 *  composability of the classes
 */
 
 public class FilterClient {
 	/**
 	 * This will read from a txt file whose name is given as an argument,
 	 * printing the number of words and bytes multiple times to show the 
 	 * interchangeability of the filters.
 	 * @param arg Only a single argument is allowed
 	 *			This is the filename of the textfile to be analyzed
 	 */
 	 
 	 public static void main (String [] args) {
 	 	try {
 	 		if (args.length != 1)
 	 			throw new Exception ("Expecting a single filename argument");
 	 		FileInStream textFile = new FileInStream(args[0]);
 	 		
 	 		//filters
 	 		ByteCountInStream firstByteCount = new ByteCountInStream(textFile);
 	 		WordCountInStream firstWordCount = 
 	 			new WordCountInStream(firstByteCount);
 	 		//adding the filters again, but backwards
 	 		WordCountInStream secondWordCount = 
 	 			new WordCountInStream(firstWordCount);
 	 		ByteCountInStream secondByteCount = 
 	 			new ByteCountInStream (secondWordCount);
 	 			
 	 		//pulling the data through the filters
 	 		int fileLength;
 	 		byte [] fileArray = new byte [2000000];
 	 		while ((fileLength = secondByteCount.read(fileArray)) != -1) {}
 	 		System.out.println("The textfile, " + args[0] + " contains: ");
 	 		System.out.println("Bytes: " + firstByteCount.getByteCount());
 	 		System.out.println("Words: " + firstWordCount.getWordCount());
 	 		System.out.println("Bytes(2nd): " + secondByteCount.getByteCount());
 	 		System.out.println("Words(2nd): " + secondWordCount.getWordCount());
 	 	} catch (Exception e){
 	 		System.err.println ("Exception raised: " + e.getMessage());
 	 		e.printStackTrace(); 	 		
 	  	}
 	 }
 }
