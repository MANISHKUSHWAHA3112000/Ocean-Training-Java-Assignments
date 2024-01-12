package lambdaexpression;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Lambdacriteria
 */
public class Lambdacriteria {
	private static final Logger logger=Logger.getLogger(Hintlambda.class.getName());

    /**
     * @param words
     */
    public static void convertWordsToUppercase(List<String> words) {
        words.replaceAll(String::toUpperCase);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        convertWordsToUppercase(words);
        logger.info(words.toArray().toString());
    }
}

