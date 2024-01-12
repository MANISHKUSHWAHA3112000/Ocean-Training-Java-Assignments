package annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;


public class ExecuteAnnotationTest {

    @Test
    void testExecutionOrder() throws NoSuchMethodException {
        MyClass myClass = new MyClass();
        List<String> executionOrder = new ArrayList<>();

        // Get all methods in MyClass
        Method[] methods = MyClass.class.getDeclaredMethods();

        // Get the methods annotated with @Execute
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Execute.class)) {
                annotatedMethods.add(method);
            }
        }

        // Sort the methods based on the sequence property
        Collections.sort(annotatedMethods, (m1, m2) -> {
            int sequence1 = m1.getAnnotation(Execute.class).sequence();
            int sequence2 = m2.getAnnotation(Execute.class).sequence();
            return Integer.compare(sequence1, sequence2);
        });

        // Invoke the methods in the sorted order
        for (Method method : annotatedMethods) {
            try {
                method.invoke(myClass);
                executionOrder.add(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Verify the execution order
        assertEquals("myMethod2", executionOrder.get(0));
        assertEquals("myMethod1", executionOrder.get(1));
        assertEquals("myMethod3", executionOrder.get(2));
    }
}
