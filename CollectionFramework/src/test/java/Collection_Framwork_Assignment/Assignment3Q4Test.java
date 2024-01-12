package Collection_Framwork_Assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class Assignment3Q4Test {

    @Test
    void testGetEmployee() {
        Assignment3Q4 assignment = new Assignment3Q4();

        HashMap<DateClass, String> employeeMap = new HashMap<>();
        DateClass date1 = new DateClass(1, 1, 2022);
        DateClass date2 = new DateClass(2, 1, 2022);
        DateClass date3 = new DateClass(1, 2, 2022);
        DateClass date4 = new DateClass(1, 1, 2023);

        employeeMap.put(date1, "John");
        employeeMap.put(date2, "Alice");
        employeeMap.put(date3, "Bob");
        employeeMap.put(date4, "John");

        // Test employee with unique date and month
        assertEquals("Alice", assignment.getEmployee(employeeMap, "Alice"));

        // Test employee with a date that repeats, but only once
        assertEquals("Bob", assignment.getEmployee(employeeMap, "Bob"));

        // Test employee with a date that repeats more than once but in the same year
        assertEquals("John", assignment.getEmployee(employeeMap, "John"));

        // Test employee with a date that repeats more than once but in different years
        assertNull(assignment.getEmployee(employeeMap, "Chris"));
    }
    
    @Test
    void testGetEmployeeWithNoMatches() {
        Assignment3Q4 assignment = new Assignment3Q4();

        HashMap<DateClass, String> employeeMap = new HashMap<>();
        DateClass date1 = new DateClass(1, 1, 2022);
        DateClass date2 = new DateClass(2, 1, 2022);
        DateClass date3 = new DateClass(1, 2, 2022);
        DateClass date4 = new DateClass(1, 1, 2023);

        employeeMap.put(date1, "John");
        employeeMap.put(date2, "Alice");
        employeeMap.put(date3, "Bob");
        employeeMap.put(date4, "John");

        // Test employee with a date that has no matches
        assertNull(assignment.getEmployee(employeeMap, "Chris"));
    }

    
    @Test
    void testGetEmployeeWithNullEmployeeName() {
        Assignment3Q4 assignment = new Assignment3Q4();

        HashMap<DateClass, String> employeeMap = new HashMap<>();
        DateClass date1 = new DateClass(1, 1, 2022);
        DateClass date2 = new DateClass(2, 1, 2022);

        employeeMap.put(date1, "John");
        employeeMap.put(date2, "Alice");

        // Test employee with a null employee name
        assertNull(assignment.getEmployee(employeeMap, null));
    }
}
