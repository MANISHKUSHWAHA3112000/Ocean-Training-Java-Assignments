package oopsassignments;

import org.junit.Test;




import static org.junit.Assert.assertEquals;

public class Assignment2Q3Test {

    @Test
    public void testCurrentAccountGetCash() {
        CurrentAccount currentAccount = new CurrentAccount(10000, 2000);
        assertEquals(8000, currentAccount.getCash());
    }

    @Test
    public void testSavingsAccountGetCash() {
        SavingsAccount savingsAccount = new SavingsAccount(10000, 5000);
        assertEquals(15000, savingsAccount.getCash());
    }

    @Test
    public void testTotalCashInBank() {
        CurrentAccount currentAccount = new CurrentAccount(10000, 2000);
        SavingsAccount savingsAccount = new SavingsAccount(10000, 5000);

        Assignment2Q3 assignment2Q3 = new Assignment2Q3(currentAccount, savingsAccount);

        assertEquals(23000, assignment2Q3.totalCashInBank());
    }

    @Test
    public void testZeroCreditLimit() {
        // Additional test: CurrentAccount with zero credit limit
        CurrentAccount currentAccount = new CurrentAccount(10000, 0);
        assertEquals(10000, currentAccount.getCash());
    }

    @Test
    public void testZeroFixedDepositAmount() {
        // Additional test: SavingsAccount with zero fixed deposit amount
        SavingsAccount savingsAccount = new SavingsAccount(10000, 0);
        assertEquals(10000, savingsAccount.getCash());
    }

    @Test
    public void testNegativeCreditLimit() {
        // Additional test: CurrentAccount with negative credit limit
        CurrentAccount currentAccount = new CurrentAccount(10000, -2000);
        assertEquals(12000, currentAccount.getCash());
    }

    @Test
    public void testNegativeFixedDepositAmount() {
        // Additional test: SavingsAccount with negative fixed deposit amount
        SavingsAccount savingsAccount = new SavingsAccount(10000, -5000);
        assertEquals(5000, savingsAccount.getCash());
    }
}
