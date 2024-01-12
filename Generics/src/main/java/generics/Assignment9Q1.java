package generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

class Employee {
    private final int id;
    private final String name;
    private final double salary;
    private final String department;

    // Constructors, getters, setters, and other methods can be added as needed

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public void displayDetails(Logger logger) {
        logger.log(Level.INFO, "Employee ID: " + id);
        logger.log(Level.INFO, "Employee Name: " + name);
        logger.log(Level.INFO, "Employee Salary: $" + salary);
        logger.log(Level.INFO, "Employee Department: " + department);
        logger.log(Level.INFO, "----------------------------");
    }

    // Override hashCode and equals to ensure correct behavior in HashSet
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        return id == employee.id;
    }
}

public class Assignment9Q1 {

    private static final Logger logger = Logger.getLogger(Assignment9Q1.class.getName());

    /** JUnit test case for Assignment9Q1 **/
    @Test
    void testEmployeeHashSet() {
        // Create an instance of Assignment9Q1 to test
        @SuppressWarnings("unused")
		Assignment9Q1 assignment = new Assignment9Q1();

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
        assert employeeSet.size() == 3 : "Employee set size should be 3";

        // Verify that the HashSet contains the added employees
        assert employeeSet.contains(employee1) : "Employee set should contain Manish Kushwaha";
        assert employeeSet.contains(employee2) : "Employee set should contain Gourav Singh";
        assert employeeSet.contains(employee3) : "Employee set should contain Aryan Srivastava";

        // Attempt to add a non-employee object (this should not be allowed)
        // Uncommenting this line would result in a compilation error
        // employeeSet.add("Not an Employee");

        // Display details of employees in the HashSet
        for (Employee employee : employeeSet) {
            // Redirect the output to the console (you might want to adapt this part based on your needs)
            employee.displayDetails(logger);
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
    
    /**
     * Creates a HashSet of Employee objects.
     *
     * @return The HashSet containing Employee objects.
     */
    public static HashSet<Employee> createEmployeeSet() {
        // Create a HashSet to hold Employee objects
        HashSet<Employee> employees = new HashSet<>();

        // Add Employee objects to the HashSet
        employees.add(new Employee(1, "Manish Kushwaha", 50000.0, "IT"));
        employees.add(new Employee(2, "Gourav Singh", 60000.0, "HR"));
        employees.add(new Employee(3, "Aryan Srivastava", 55000.0, "Finance"));

        return employees;
    }

    /**
     * The main method of the program responsible for user input, division calculation,
     * and displaying the result or an error message.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        // Use createEmployeeSet to obtain the HashSet<Employee>
        HashSet<Employee> employees = createEmployeeSet();

        // Display details of employees in the HashSet
        for (Employee employee : employees) {
            employee.displayDetails(logger);
        }
    }
}
