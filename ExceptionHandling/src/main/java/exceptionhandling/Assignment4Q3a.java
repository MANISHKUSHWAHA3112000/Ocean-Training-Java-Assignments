package exceptionhandling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

@SuppressWarnings("serial")
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class SavingAccount {
    private final long id;
    private double balance;
    private static final Logger logger = Logger.getLogger(SavingAccount.class.getName());

    public SavingAccount(long id, double initialBalance) {
        if (initialBalance < 0) {
            logger.log(Level.SEVERE, "Invalid initial balance: " + initialBalance);
            throw new IllegalArgumentException("Invalid initial balance: " + initialBalance);
        }
        this.balance = initialBalance;
        this.id = id;
    }

    public double withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            logger.log(Level.WARNING, "Invalid withdrawal amount: " + amount);
            throw new IllegalArgumentException("Invalid withdrawal amount: " + amount);
        }

        if (amount > balance) {
            logger.log(Level.WARNING, "Insufficient balance to withdraw " + amount);
            throw new InsufficientBalanceException("Insufficient balance to withdraw " + amount);
        }

        balance -= amount;
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

	 public int deposit(int amount) throws IllegalBankTransactionException {
            if (amount < 0) {
                throw new IllegalBankTransactionException("Invalid transaction amount: " + amount);
            }
            balance += amount;
            return amount;
        }
}

public class Assignment4Q3a {

    private static final Logger logger = Logger.getLogger(Assignment4Q3a.class.getName());

    @Test
    public void testInvalidInitialBalance() {
        try {
            new SavingAccount(1, -500);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid initial balance: -500.0", e.getMessage());
            logger.log(Level.INFO, "Test passed: InvalidInitialBalance");
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
            logger.log(Level.INFO, "Test passed: InvalidWithdrawalAmount");
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
            logger.log(Level.INFO, "Test passed: InsufficientBalanceException");
        }
    }

    @Test
    public void testValidWithdrawal() {
        SavingAccount savingAcc = new SavingAccount(4, 2000);

        try {
            double withdrawnAmount = savingAcc.withdraw(500);
            assertEquals(500, withdrawnAmount, 0);
            assertEquals(1500, savingAcc.getBalance(), 0);
            logger.log(Level.INFO, "Test passed: ValidWithdrawal");
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
            logger.log(Level.INFO, "Test passed: NegativeInitialBalanceCreation");
        }
    }

    @Test
    public void testMainMethod() throws InsufficientBalanceException {
        Assignment4Q3a.main(new String[]{});
    }

    public static void main(String[] args) throws InsufficientBalanceException {
        try {
            @SuppressWarnings("unused")
            SavingAccount negativeBalanceAccount = new SavingAccount(1, -500);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }

        SavingAccount savingAcc = new SavingAccount(2, 2000);

        try {
            savingAcc.withdraw(-100);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }

        try {
            savingAcc.withdraw(2100);
        } catch (InsufficientBalanceException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }

        try {
            double withdrawnAmount = savingAcc.withdraw(500);
            logger.info("Withdrawal of " + withdrawnAmount + " successful. Remaining balance: " + savingAcc.getBalance());
        } catch (InsufficientBalanceException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }
    }
}
