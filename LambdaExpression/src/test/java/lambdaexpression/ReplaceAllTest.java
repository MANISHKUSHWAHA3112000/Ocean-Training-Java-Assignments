package lambdaexpression;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class ReplaceAllTest {

    private List<String> words;

    @Before
    public void setUp() {
        words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("date");
    }

    @Test
    public void testRemoveIfOddLengthWords() {
        ReplaceAll.removeIfOddLengthWords(words);
        List<String> expected = new ArrayList<>(Arrays.asList("banana", "cherry", "date"));
        assertEquals(expected, words);
    }
}
