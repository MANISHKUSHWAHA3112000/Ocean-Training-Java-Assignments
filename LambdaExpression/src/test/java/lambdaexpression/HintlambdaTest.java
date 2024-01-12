package lambdaexpression;


import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class HintlambdaTest {
	
	private Hintlambda hintLambda;

    private List<String> words;
    private StringBuilder result;
    
    private PrintStream originalOut;
    private ByteArrayOutputStream outputStream;
    
    @Before
    public void setUp() {
    	hintLambda = new Hintlambda();
    	
        words = Arrays.asList("apples", "cutardapple", "cherryapple", "mushrooms", "elderberry");
        result = new StringBuilder();
        
        originalOut = System.out;
        
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearUp() {
    	System.setOut(originalOut);
    }
     
    
    @Test
    public void testAppendFirstLetterOfWords() {
        Consumer<String> firstLetterAppender = word -> result.append(word.charAt(0));
        Hintlambda.applyConsumer(words, firstLetterAppender);

        String expected = "accme";
        assertEquals(expected, result.toString());
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testMainMethodOutput() {
    	String expectedOutput = "Resulting string: accme";
    	
    	hintLambda.main(null);
    	
    	String outputText = outputStream.toString().trim();
    	assertEquals(expectedOutput, outputText);
    }
    
}
