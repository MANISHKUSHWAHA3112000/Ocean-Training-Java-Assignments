package oopsassignments;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * This class contains JUnit test cases for the SingletonInheritanceCheck class.
 */
public class Assignment2Q1Test {

    /** Junit test case to test Singleton instance **/
    @Test
    public void testGetSingleton() {
        // Call the static method to get the singleton instance
        final SingletonInheritanceCheck instance1 = SingletonInheritanceCheck.getInstance();
        final SingletonInheritanceCheck instance2 = SingletonInheritanceCheck.getInstance();

        // Assert that the instances are the same
        assertSame(instance1, instance2);

        // Test that the instance is not null
        assertNotNull(instance1);
        assertNotNull(instance2);

        // Additional test: Ensure a new instance is not created on subsequent calls
        final SingletonInheritanceCheck instance3 = SingletonInheritanceCheck.getInstance();
        assertSame(instance2, instance3);

        // Additional test: Ensure a new instance is not created using getInstanceForTesting
        final SingletonInheritanceCheck instance4 = SingletonInheritanceCheck.getInstanceForTesting();
        assertSame(instance2, instance4);

        // Additional test: Ensure the class is not instantiable via reflection
        try {
            // Attempt to create a new instance using reflection
            SingletonInheritanceCheck.class.getDeclaredConstructor().newInstance();
            fail("Expected IllegalAccessException");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalAccessException);
        }
    }

    /** Junit test case to test multiple threads accessing the Singleton instance **/
    @Test
    public void testThreadSafety() throws InterruptedException {
        final SingletonInheritanceCheck[] instances = new SingletonInheritanceCheck[3];
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                instances[index] = SingletonInheritanceCheck.getInstance();
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // Ensure that all instances obtained in different threads are the same
        assertSame(instances[0], instances[1]);
        assertSame(instances[1], instances[2]);
    }

    /** Junit test case to test the singleton instance after resetting it using reflection **/
    @Test
    public void testResetSingletonInstance() {
        SingletonInheritanceCheck instance1 = SingletonInheritanceCheck.getInstance();
        SingletonInheritanceCheck.getInstanceForTesting();
        SingletonInheritanceCheck instance2 = SingletonInheritanceCheck.getInstance();

        // Ensure that the instances are different after resetting
        assertSame(instance1, instance2);
    }
}
