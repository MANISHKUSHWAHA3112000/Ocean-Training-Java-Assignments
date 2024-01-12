package oopsassignments;

import static org.junit.Assert.assertEquals;
 

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Test;

class Employee {
    private static final int BASE_SALARY = 10000;

    public int getBaseSalary() {
        return BASE_SALARY;
    }

    public int calculateTotalSalary(ArrayList<Integer> salaries) {
        int totalSalary = 0;
        for (int salary : salaries) {
            totalSalary += salary;
        }
        return totalSalary;
    }
}

class Manager extends Employee {
    private static final int INCENTIVE = 5000;
	public static final int OVERTIME = 0;

    @Override
    public int getBaseSalary() {
        return super.getBaseSalary() + INCENTIVE;
    }
}

class Labour extends Employee {
    private static final int OVERTIME = 500;

    @Override
    public int getBaseSalary() {
        return super.getBaseSalary() + OVERTIME;
    }
}

public class Assignment2Q2 {

    private static final Logger logger = Logger.getLogger(Assignment2Q2.class.getName());

    @Test
    public void testManagerSalary() {
        Manager manager = new Manager();
        int expectedSalary = manager.getBaseSalary();

        assertEquals(expectedSalary, manager.getBaseSalary());
    }

    @Test
    public void testTotalEmployeesSalary() {
        ArrayList<Integer> salaries = new ArrayList<>();
        salaries.add(10000);
        salaries.add(15000);
        salaries.add(12000);

        Employee employee = new Employee();
        int expectedTotalSalary = salaries.stream().mapToInt(Integer::intValue).sum();

        assertEquals(expectedTotalSalary, employee.calculateTotalSalary(salaries));
    }

    

    public static void main(String[] args) {
        Labour labour = new Labour();
        Manager manager = new Manager();

        // Logging base salary and total salary for a manager and a labour
        logger.info("Manager's Base Salary: " + manager.getBaseSalary());
        logger.info("Labour's Base Salary: " + labour.getBaseSalary());

        ArrayList<Integer> salaries = new ArrayList<>();
        salaries.add(manager.getBaseSalary());
        salaries.add(labour.getBaseSalary());

        Employee employee = new Employee();
        logger.info("Total Salary of Employees: " + employee.calculateTotalSalary(salaries));
    }
}
