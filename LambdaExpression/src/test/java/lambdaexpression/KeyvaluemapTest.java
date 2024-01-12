package lambdaexpression;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;



public class KeyvaluemapTest {

    private Map<String, String> map;

    @Before
    public void setUp() {
        map = new HashMap<>();
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        map.put("Key3", "Value3");
    }

    @Test
    public void testConstructKeyValueString() {
        String result = Keyvaluemap.constructKeyValueString(map);
        String expected = "Key[1:Value1, Key2:Value2], Key3:Value3";
        assertEquals(expected, result);
    }
}

