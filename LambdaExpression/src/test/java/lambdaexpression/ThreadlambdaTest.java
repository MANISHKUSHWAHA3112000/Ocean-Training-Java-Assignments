package lambdaexpression;


import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class ThreadlambdaTest {

    @Test
    public void testLambdaThreadExecution() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Thread thread = new Thread(() -> {
            numbers.forEach(System.out::println);
        });

        thread.start();
        try {
            thread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String expectedOutput = "1\n2\n3\n4\n5"; // Expected output of the lambda function
        assertEquals(expectedOutput, outContent.toString());
        
        System.setOut(System.out); // Restore the standard output stream
    }
}

