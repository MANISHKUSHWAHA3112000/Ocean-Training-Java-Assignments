package lambdaexpression;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class LambdacriteriaTest {

	
	@SuppressWarnings("unused")
	private Lambdacriteria lambdaCriteria;
	
    private List<String> words;

    private PrintStream originalOut;
    private ByteArrayOutputStream output;
    
    @Before
    public void setUp() {
    	lambdaCriteria = new Lambdacriteria();
    	
        words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        
        originalOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }
    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testConvertWordsToUppercase() {
        Lambdacriteria.convertWordsToUppercase(words);
        List<String> expected = List.of("APPLE", "BANANA", "CHERRY");
        assertEquals(expected, words);
    }
    
    @Test
    public void testMainMethod() {
    	String expectedOutput = "[APPLE, BANANA, CHERRY]";
    	
    	Lambdacriteria.main(null);
    	String outputText = output.toString().trim();
    	
    	assertEquals(expectedOutput, outputText);
    }
}

