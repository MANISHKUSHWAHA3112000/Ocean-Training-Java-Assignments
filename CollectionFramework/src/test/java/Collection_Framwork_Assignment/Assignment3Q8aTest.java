package Collection_Framwork_Assignment;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Assignment3Q8aTest {

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
   

    @Test
    void testFailFastWithNullMap() {
        // Expecting IllegalArgumentException since the map is null
        assertThrows(IllegalArgumentException.class, () -> {
            Assignment3Q8a.failFast(null);
        });
    }

}
