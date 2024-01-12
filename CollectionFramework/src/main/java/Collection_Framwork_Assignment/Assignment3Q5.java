package Collection_Framwork_Assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

class Employee implements Comparable<Employee> {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    // Other methods remain the same...

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee E = (Employee) obj;
        return id == E.id && Objects.equals(name, E.name);
    }
}

public class Assignment3Q5 {

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment3Q5.class.getName());

    @Test
    void testEmployeeMap() {
        Employee emp1 = new Employee("Manish", 1);
        Employee emp2 = new Employee("Gourav", 2);
        Employee emp3 = new Employee("Aryan", 3);

        Map<Employee, String> map = new Hashtable<>();
        map.put(emp1, "Employee 1");
        map.put(emp2, "Employee 2");
        map.put(emp3, "Employee 3");

        // Log the map using the logger
        logger.log(Level.INFO, "Employee Map:");
        map.forEach((employee, value) -> logger.log(Level.INFO, employee + " -> " + value));

        // Log additional test cases using the logger
        logger.log(Level.INFO, "\nAdditional test cases:");

        // Test get method and log the results
        logger.log(Level.INFO, "Get Employee 1: " + map.get(emp1));
        logger.log(Level.INFO, "Get Employee 2: " + map.get(emp2));
        logger.log(Level.INFO, "Get Employee 3: " + map.get(emp3));

        // Perform assertions as needed for the test
        assertEquals("Employee 1", map.get(emp1));
        assertEquals("Employee 2", map.get(emp2));
        assertEquals("Employee 3", map.get(emp3));

        // Additional assertions...
        assertTrue(emp1.equals(emp1));
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Manish", 1);
        Employee emp2 = new Employee("Gourav", 2);
        Employee emp3 = new Employee("Aryan", 3);

        TreeMap<Employee, String> map = new TreeMap<>();
        map.put(emp1, "Employee 1");
        map.put(emp2, "Employee 2");
        map.put(emp3, "Employee 3");

        // Log the map using the logger
        logger.log(Level.INFO, "Employee Map:");
        map.forEach((employee, value) -> logger.log(Level.INFO, employee + " -> " + value));

        // Log additional test cases using the logger
        logger.log(Level.INFO, "\nAdditional test cases:");

        // Log the results of using the get method
        logger.log(Level.INFO, "Get Employee 1: " + map.get(emp1));
        logger.log(Level.INFO, "Get Employee 2: " + map.get(emp2));
        logger.log(Level.INFO, "Get Employee 3: " + map.get(emp3));
    }
}
