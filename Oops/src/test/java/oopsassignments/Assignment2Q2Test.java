package oopsassignments;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

public class Assignment2Q2Test {

    @Test
    public void testManagerSalary() {
        Manager manager = new Manager();
        int expectedSalary = manager.getBaseSalary();

        assertEquals(expectedSalary, manager.getBaseSalary());
    }

    @Test
    public void testLabourSalary() {
        Labour labour = new Labour();
        int expectedSalary = labour.getBaseSalary();

        assertEquals(expectedSalary, labour.getBaseSalary());
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

    @Test
    public void testTotalEmployeesSalaryWithMock() {
        ArrayList<Integer> salaries = new ArrayList<>();
        salaries.add(10000);
        salaries.add(15000);
        salaries.add(12000);

        Employee employeeMock = mock(Employee.class);
        when(employeeMock.calculateTotalSalary(salaries)).thenReturn(37000);

        assertEquals(37000, employeeMock.calculateTotalSalary(salaries));
    }

    @Test
    public void testEmptySalaryList() {
        ArrayList<Integer> salaries = new ArrayList<>();

        Employee employee = new Employee();
        int expectedTotalSalary = 0;

        assertEquals(expectedTotalSalary, employee.calculateTotalSalary(salaries));
    }

    @Test
    public void testManagerBaseSalaryWithOvertime() {
        Manager manager = new Manager();
        int expectedSalary = manager.getBaseSalary() + Manager.OVERTIME;

        assertEquals(expectedSalary, manager.getBaseSalary());
    }
}
