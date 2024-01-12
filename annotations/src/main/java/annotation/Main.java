package annotation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Main {
	
	private static final Logger logger=Logger.getLogger(Main.class.getName());

    @Test
    public void exampleTestMethod() {
        // Your test logic here
        logger.info("Executing test method");
    }
    
    @Test
    void testCustomAnnotation() {
        Main testClassInstance = new Main();
        Class<?> testClass = testClassInstance.getClass();
        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                // Perform your test logic here
                logger.info("Running test for method: " + method.getName());
                assertTrue(true, "Your test assertion here");
            }
        }
    }
}    

