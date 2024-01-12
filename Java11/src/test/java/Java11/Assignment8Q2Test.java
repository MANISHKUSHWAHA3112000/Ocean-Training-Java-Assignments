package Java11;



import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.BinaryOperator;

import org.junit.jupiter.api.Test;

class Assignment8Q2Test {

    

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
}
