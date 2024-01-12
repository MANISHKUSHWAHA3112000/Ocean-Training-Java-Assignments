package Java11;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.BinaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;



public class Assignment8Q2 {

    private static final Logger logger = Logger.getLogger(Assignment8Q2.class.getName());

    // No initialization
    // Cannot use var without initialization
    // You need to initialize the variable at the point of declaration
    // For example, assuming x is an int:
    int x = 0;

    // Method Parameter
    // Cannot use var for method parameters
    // Specify the type of the parameter explicitly
    public void myMethod(int parameter) {
        // ...
    }

    // Array Declaration
    // Cannot use var for array declarations
    // Specify the type explicitly
    int[] array = new int[5];

    // Lambda Expression without Explicit types
    // Cannot use var for lambda expressions without explicit types
    // Specify the types of lambda parameters explicitly
    BinaryOperator<Integer> myLambda = (Integer a, Integer b) -> a + b;

    // Instance variables
    // Cannot use var for instance variables
    // Specify the type explicitly
    class MyClass {
        int myField = 42;
    }

    // Null initializer
    // Cannot use var with null initializer
    // Specify the type explicitly
    String myVar = null;

    // Expression with multiple variables
    // Cannot use var for expressions with multiple variables
    // Specify the types explicitly
    int a = 5, b = 10;

    
    
    
    @Test
    void testMethodParameter() {
        Assignment8Q2 assignment = new Assignment8Q2();

        // Check if myMethod accepts int parameter
        assignment.myMethod(10);
        // If the method is called without any compilation errors, it passes
        assertTrue(true);
    }

    @Test
    void testArrayDeclaration() {
        Assignment8Q2 assignment = new Assignment8Q2();

        // Check if array is initialized
        assertNotNull(assignment.array);
    }

    @Test
    void testLambdaExpression() {
        Assignment8Q2 assignment = new Assignment8Q2();

        // Check if myLambda is a BinaryOperator
        assertTrue(assignment.myLambda instanceof BinaryOperator);
    }

    @Test
    void testInstanceVariable() {
        Assignment8Q2.MyClass myClass = new Assignment8Q2().new MyClass();

        // Check if myField is initialized
        assertNotEquals(0, myClass.myField);
    }

    @Test
    void testNullInitializer() {
        Assignment8Q2 assignment = new Assignment8Q2();

        // Check if myVar is initialized with null
        assertNull(assignment.myVar);
    }

    @Test
    void testExpressionWithMultipleVariables() {
        Assignment8Q2 assignment = new Assignment8Q2();

        // Check if a and b are initialized
        assertNotEquals(0, assignment.a);
        assertNotEquals(0, assignment.b);
    }
    
    public static void main(String[] args) {
        try {
            Assignment8Q2 assignment = new Assignment8Q2();
            assignment.execute();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
        }
    }

    private void execute() {
        // Logging examples
        logger.log(Level.INFO, "Executing Assignment8Q2...");

        // Your code logic here

        // Example using System.out
        logger.info("Logging to System.out: Assignment8Q2 executed successfully.");

        // More code logic...

        logger.log(Level.INFO, "Finished executing Assignment8Q2.");
    }
}
