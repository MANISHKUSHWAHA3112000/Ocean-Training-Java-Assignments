package oopsassignments;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import org.junit.Test;

abstract class A {
    abstract void show();
}

abstract class B extends A {
	private static final Logger logger=Logger.getLogger(ConcreteA.class.getName());
    @Override
    void show() {
    	logger.info("I am an overridden method in class B");
    }
}

abstract class E {
	private static final Logger logger=Logger.getLogger(ConcreteA.class.getName());
    public void show() {
    	logger.info("I am a method without an abstract type");
    }
}

class ConcreteA extends A {
	
	private static final Logger logger=Logger.getLogger(ConcreteA.class.getName());
    @Override
    void show() {
        logger.info("I am a concrete implementation of A");
    }
}

class ConcreteB extends B {
    // No need to override the show method here
}

class ConcreteE extends E {
    // No need to override the show method here
}

public class Assignment2Q4 {

    public static void main(String[] args) {
        // Demonstrating ConcreteA
        A objectA = new ConcreteA();
        objectA.show();

        // Demonstrating ConcreteB
        B objectB = new ConcreteB();
        objectB.show();

        // Demonstrating ConcreteE
        E objectE = new ConcreteE();
        objectE.show();
    }



    @Test
    public void testMainMethod() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the main method to execute the code
        Assignment2Q4.main(null);

        // Expected output
        String expectedOutput = "I am a concrete implementation of A" +
                                System.lineSeparator() +
                                "I am an overridden method in class B" +
                                System.lineSeparator() +
                                "I am a method without an abstract type" +
                                System.lineSeparator();
        
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);  // Reset System.out to its original PrintStream
    }
}
