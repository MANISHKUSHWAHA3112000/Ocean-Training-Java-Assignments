package Collection_Framwork_Assignment;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment3Q8a {

    private static final Logger logger = Logger.getLogger(Assignment3Q8a.class.getName());

    public static void failFast(Map<String, String> cityCode) {
        if (cityCode == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        Iterator<Map.Entry<String, String>> iterator = cityCode.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            logger.info(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static void failFastWithModification(Map<String, String> cityCode) {
        Iterator<Map.Entry<String, String>> iterator = cityCode.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            logger.info(entry.getKey() + ": " + entry.getValue());

            // Modify the map during iteration
            cityCode.put("NewCity", "NewCode");
        }
    }
    
    @Test
    void testFailFastWithModificationDuringIteration() {
        Map<String, String> cityCode = new HashMap<>();
        cityCode.put("Delhi", "DL");
        cityCode.put("Mumbai", "MH");
        cityCode.put("Kolkata", "WB");

        assertThrows(ConcurrentModificationException.class, () -> {
            Assignment3Q8a.failFastWithModification(cityCode);
        });
    }

    @Test
    void testFailFastWithEmptyMap() {
        Map<String, String> emptyMap = new HashMap<>();

        // Expecting no exception since the map is empty
        assertDoesNotThrow(() -> Assignment3Q8a.failFast(emptyMap));
    }
}
