import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Scanner;


/**
 * Fooling around in lab 3.
 * @author thomas
 *
 */
public class Lab3 {

    /**
     * Main method.
     * @param args list of arguments that are passed into main
     */
    public static void main(final String[] args) {
        System.out.println(uniqueWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }

    /**
     * Retrieves a text file from the Internet as a URL and prints it to the console.
     * @param url the url from which to find the document
     * @return a string of the document
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param  document to find the word count.
     * @return the contents from the url as a string, or an empty string on error
     */
    public static int wordCount(final String document) {
        Scanner wordCounter = new Scanner(document);
        int count = 0;
        while (wordCounter.hasNext()) {
            wordCounter.next();
            count += 1;
        }
        wordCounter.close();
        return count;
    }

    /**
     * Counts the number of unique words in the document.
     * @param document the document to be parsed
     * @return the number of unique words.
     */
    public static int uniqueWordCount(final String document) {
        Hashtable<String, Boolean> uniqueWords = new Hashtable<String, Boolean>();
        Scanner wordCounter = new Scanner(document);
        String currentWord = "";
        while (wordCounter.hasNext()) {
            currentWord = wordCounter.next();
            if (!uniqueWords.containsKey(currentWord)) {
                uniqueWords.put(currentWord, true);
            }
        }
        wordCounter.close();
        return uniqueWords.size();
    }
}
