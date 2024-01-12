package lambdaexpression;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;
/**
 * Hintlambda class
 */
public class Hintlambda {
	private static final Logger logger=Logger.getLogger(Hintlambda.class.getName());

    /**
     * @param words
     * @param consumer
     */
    public static void applyConsumer(List<String> words, Consumer<String> consumer) {
        words.forEach(consumer);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apples", "cutardapple", "cherryapple", "mushrooms", "elderberry");

        StringBuilder result = new StringBuilder();

        Consumer<String> firstLetterAppender = word -> result.append(word.charAt(0));

        applyConsumer(words, firstLetterAppender);

        logger.info("Resulting string: " + result.toString());
    }
}

