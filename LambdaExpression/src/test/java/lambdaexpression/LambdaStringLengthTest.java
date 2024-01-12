package lambdaexpression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class LambdaStringLengthTest {

	private List<String> words;
	private PrintStream originalOut;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() {
		words = Arrays.asList("Hello", "World", "Lambda", "Expression");
		originalOut = System.out;
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
	}

	@After
	public void tearDown() {
		System.setOut(originalOut);
	}

	@Test
	public void testGenerateStringWithFirstCharacters() {
		String result = LambdaStringLength.generateStringWithFirstCharacters(words);
		String expected = "HWLE";
		assertEquals(expected, result);
	}
	
	@Test
	public void testMain() {
		String expectedOutput = "HWLE";
	
		LambdaStringLength.main(null);
		
		String outputText = output.toString();
		assertTrue(outputText.contains(expectedOutput));
	}

}
