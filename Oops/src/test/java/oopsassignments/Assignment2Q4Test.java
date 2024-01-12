package oopsassignments;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Assignment2Q4Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testConcreteA() {
        ConcreteA objectA = new ConcreteA();
        objectA.show();

        String expectedOutput = "I am a concrete implementation of A" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testConcreteB() {
        ConcreteB objectB = new ConcreteB();
        objectB.show();

        String expectedOutput = "I am an overridden method in class B" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testConcreteE() {
        ConcreteE objectE = new ConcreteE();
        objectE.show();

        String expectedOutput = "I am a method without an abstract type" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMainMethod() {
        // Redirecting System.out to capture the output
        ByteArrayOutputStream mainOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mainOutContent));

        // Calling the main method
        Assignment2Q4.main(null);

        // Restoring the original System.out
        System.setOut(originalOut);

        // Asserting the output of the main method
        String expectedMainOutput = "I am a concrete implementation of A" + System.lineSeparator()
                + "I am an overridden method in class B" + System.lineSeparator()
                + "I am a method without an abstract type" + System.lineSeparator();
        assertEquals(expectedMainOutput, mainOutContent.toString());
    }
}
