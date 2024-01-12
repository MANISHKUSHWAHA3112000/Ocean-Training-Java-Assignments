package annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExecuteClassTest {

    @org.junit.Test
    public void testExecutionOrder() throws Exception {
        ExecuteClass executeClass = new ExecuteClass();
        List<Method> methods = new ArrayList<>();

        for (Method method : ExecuteClass.class.getDeclaredMethods()) {
            Execute annotation = method.getAnnotation(Execute.class);
            if (annotation != null) {
                methods.add(method);
            }
        }

        // Sort the methods based on their sequence value
        Collections.sort(methods, (m1, m2) -> {
            int sequence1 = m1.getAnnotation(Execute.class).sequence();
            int sequence2 = m2.getAnnotation(Execute.class).sequence();
            return Integer.compare(sequence1, sequence2);
        });

        // Invoke the methods in the specified order
        for (Method method : methods) {
            method.invoke(executeClass);
        }
    }
}

