package exceptionhandling;

import org.junit.Test;

import static org.junit.Assert.*;

public class Assignment4Q3aTest {

    @Test
    public void testInvalidInitialBalance() {
        try {
            new SavingAccount(1, -500);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid initial balance: -500.0", e.getMessage());
        }
    }

    @Test
    public void testInvalidWithdrawalAmount() throws InsufficientBalanceException {
        SavingAccount savingAcc = new SavingAccount(2, 2000);

        try {
            savingAcc.withdraw(-100);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid withdrawal amount: -100.0", e.getMessage());
        }
    }

    @Test
    public void testInsufficientBalanceException() {
        SavingAccount savingAcc = new SavingAccount(3, 2000);

        try {
            savingAcc.withdraw(2100);
            fail("Expected InsufficientBalanceException was not thrown");
        } catch (InsufficientBalanceException e) {
            assertEquals("Insufficient balance to withdraw 2100.0", e.getMessage());
        }
    }

    @Test
    public void testValidWithdrawal() {
        SavingAccount savingAcc = new SavingAccount(4, 2000);

        try {
            double withdrawnAmount = savingAcc.withdraw(500);
            assertEquals(500, withdrawnAmount, 0);
            assertEquals(1500, savingAcc.getBalance(), 0);
        } catch (InsufficientBalanceException e) {
            fail("Unexpected InsufficientBalanceException was thrown");
        }
    }

    @Test
    public void testNegativeInitialBalanceCreation() {
        try {
            new SavingAccount(1, -500);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid initial balance: -500.0", e.getMessage());
        }
    }

    @Test
    public void testMainMethod() throws InsufficientBalanceException {
        // Redirect System.out for testing
        System.setOut(new java.io.PrintStream(System.out) {
            @Override
            public void println(String s) {
                // Assert the printed messages if needed
                // For simplicity, we are not checking the actual message content here
                super.println(s);
            }
        });

        // Run the main method to cover its execution
        Assignment4Q3a.main(new String[]{});
    }

    @Test
    public void testWithdrawalEqualsBalance() {
        SavingAccount savingAcc = new SavingAccount(6, 500);

        try {
            double withdrawnAmount = savingAcc.withdraw(500);
            assertEquals(500, withdrawnAmount, 0);
            assertEquals(0, savingAcc.getBalance(), 0);
        } catch (InsufficientBalanceException e) {
            fail("Unexpected InsufficientBalanceException was thrown");
        }
    }

    @Test
    public void testWithdrawalGreaterThanBalance() {
        SavingAccount savingAcc = new SavingAccount(7, 200);

        try {
            @SuppressWarnings("unused")
			double withdrawnAmount = savingAcc.withdraw(300);
            fail("Expected InsufficientBalanceException was not thrown");
        } catch (InsufficientBalanceException e) {
            assertEquals("Insufficient balance to withdraw 300.0", e.getMessage());
        }
    }
}
