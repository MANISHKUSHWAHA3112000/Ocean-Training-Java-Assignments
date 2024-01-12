package lambdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Logger;



/**
 * LambdaStringLength
 */
public class LambdaStringLength {
	private static final Logger logger=Logger.getLogger(Hintlambda.class.getName());

    /**
     * @param words
     * @return
     */
    public static String generateStringWithFirstCharacters(List<String> words) {
        StringJoiner result = new StringJoiner("");
        words.forEach(word -> result.add(String.valueOf(word.charAt(0))));
        return result.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Lambda", "Expression");
        String result = generateStringWithFirstCharacters(words);
       logger.info(result);
    }
}

