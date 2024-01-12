package Collection_Framwork_Assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;
import java.util.Map;


import org.junit.jupiter.api.Test;


public class Assignment3Q5Test {

    @Test
    void testEmployeeMap() {
        Employee emp1 = new Employee("Manish", 1);
        Employee emp2 = new Employee("Gourav", 2);
        Employee emp3 = new Employee("Aryan", 3);

        Map<Employee, String> map = new Hashtable<>();
        map.put(emp1, "Employee 1");
        map.put(emp2, "Employee 2");
        map.put(emp3, "Employee 3");

        // Test get method
        assertEquals("Employee 1", map.get(emp1));
        assertEquals("Employee 2", map.get(emp2));
        assertEquals("Employee 3", map.get(emp3));

        // Test equals and hashCode method
        assertEquals(emp1.hashCode(), emp1.hashCode());
        assertTrue(emp1.equals(emp1));
    }
    
    @Test
    void testEmployeeMapWithDuplicateEmployee() {
        Employee emp1 = new Employee("Manish", 1);
        Employee emp2 = new Employee("Gourav", 2);

        Map<Employee, String> map = new Hashtable<>();
        map.put(emp1, "Employee 1");
        map.put(emp2, "Employee 2");

        // Test adding an employee with the same ID but a different name
        Employee duplicateEmp = new Employee("John", 1);
        map.put(duplicateEmp, "Employee 3");

        // The map should now have three entries, and the duplicateEmp entry should override emp1
        assertEquals(3, map.size());
        assertEquals("Employee 3", map.get(duplicateEmp));
    }

   

    @Test
    void testEmployeeMapWithDifferentHashCodes() {
        Employee emp1 = new Employee("Manish", 1);
        Employee emp2 = new Employee("Gourav", 2);

        Map<Employee, String> map = new Hashtable<>();
        map.put(emp1, "Employee 1");
        map.put(emp2, "Employee 2");

        // Create an employee with the same ID but different name, resulting in a different hashCode
        Employee differentHashCodeEmp = new Employee("John", 1);

        // Test that the map doesn't consider differentHashCodeEmp as equal to emp1
        assertNull(map.get(differentHashCodeEmp));
    }
}
