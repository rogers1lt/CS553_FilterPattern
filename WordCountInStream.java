//Andrew Rogers CS553
import java.io.IOException;

/**
 * Filter class to count the number of words read from an InStream
 */
public class WordCountInStream extends FilterInStream {
    private long wordCount = 0;
    private boolean previousWhitespace = true;

    /**
     * Constructor
     * @param inStream The InStream that this object should delegate read
     * operations to.
     */
    public WordCountInStream(InStream inStream) throws IOException {
        super(inStream);
    } // Constructor(InStream)

    /**
     * Read bytes from a stream of bytes and fill an array with those bytes.
     * @param array The array of bytes to fill.
     * @exception IOException  if a I/O error occurs.
     */
    public int read(byte[] array) throws IOException {
        int count;
        
        count = super.read(array);
        for (int i = 0; i < count; i++){
        	char tempChar = (char) array[i];
        	boolean currentWhitespace = Character.isWhitespace(tempChar);
        	if(previousWhitespace && !currentWhitespace) wordCount++;
        	previousWhitespace = currentWhitespace;
        }
        return count;
    } // read(byte[])

    /**
     * return the number of words that have been read by this object.
     */
    public long getWordCount() {
        return wordCount;
    } // getWordCount()
} // class WordCountInStream
