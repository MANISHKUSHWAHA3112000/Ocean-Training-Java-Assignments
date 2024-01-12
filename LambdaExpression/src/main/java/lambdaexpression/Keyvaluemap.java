package lambdaexpression;


import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Logger;

/**
 * keyvaluemap class
 */
public class Keyvaluemap {
	private static final Logger logger=Logger.getLogger(Hintlambda.class.getName());

    /**
     * @param map
     * @return
     */
    public static String constructKeyValueString(Map<String, String> map) {
        StringJoiner result = new StringJoiner(", ");
        map.forEach((key, value) -> result.add(key + ":" + value));
        return result.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        map.put("Key3", "Value3");
        String finalResult = constructKeyValueString(map);
        logger.info(finalResult);
    }
}

