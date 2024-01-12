package generics;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Assignment9Q1Test {

    @Test
    void testEmployeeHashSet() {
        // Create a HashSet to hold Employee objects
        HashSet<Employee> employeeSet = Assignment9Q1.createEmployeeSet();

        // Add Employee objects to the HashSet
        Employee employee1 = new Employee(1, "Manish Kushwaha", 50000.0, "IT");
        Employee employee2 = new Employee(2, "Gourav Singh", 60000.0, "HR");
        Employee employee3 = new Employee(3, "Aryan Srivastava", 55000.0, "Finance");

        employeeSet.add(employee1);
        employeeSet.add(employee2);
        employeeSet.add(employee3);

        // Verify the size of the HashSet
        assertEquals(3, employeeSet.size(), "Employee set size should be 3");

        // Verify that the HashSet contains the added employees
        assertTrue(employeeSet.contains(employee1), "Employee set should contain Manish Kushwaha");
        assertTrue(employeeSet.contains(employee2), "Employee set should contain Gourav Singh");
        assertTrue(employeeSet.contains(employee3), "Employee set should contain Aryan Srivastava");

        // Attempt to add a non-employee object (this should not be allowed)
        // Uncommenting this line would result in a compilation error
        // employeeSet.add("Not an Employee");

        // Create a Logger for testing
        Logger testLogger = Logger.getLogger("TestLogger");

        // Display details of employees in the HashSet using the logger
        for (Employee employee : employeeSet) {
            // Redirect the output to the console (you might want to adapt this part based on your needs)
            employee.displayDetails(testLogger);
        }
    }

    @Test
    void testEmptyEmployeeHashSet() {
        // Create an empty HashSet
        HashSet<Employee> emptySet = new HashSet<>();

        // Verify the size of the empty set
        assertEquals(0, emptySet.size(), "Empty set size should be 0");

        // Attempt to retrieve an element from the empty set (should return null)
        Employee employee = emptySet.stream().findFirst().orElse(null);
        assertEquals(null, employee, "Retrieved employee should be null");
    }
}
