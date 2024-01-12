package lambdaexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReplaceAll {
    private static final Logger logger = Logger.getLogger(ReplaceAll.class.getName());

    public static void removeIfOddLengthWords(List<String> words) {
        words.removeIf(word -> word.length() % 2 != 0);
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();  // Use ArrayList<String> instead of String
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("date");

        removeIfOddLengthWords(words);
        logger.info(String.valueOf(words));  // Convert the list to a string
    }
}
