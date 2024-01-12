package junit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.Test;

public class Assignment7Q3 {
	
	private static final Logger logger=Logger.getLogger(Assignment7Q3.class.getName());

    private double balance;

    /**
     * Zero-argument constructor.
     */
    public Assignment7Q3() {
        // Zero-argument constructor
    }

    /**
     * Sets the initial balance of the account.
     *
     * @param initialBalance The initial balance.
     */
    public void setInitialBalance(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Deposits the specified amount to the account balance.
     *
     * @param amount The amount to be deposited.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraws the specified amount from the account balance.
     * Throws InsufficientFundsException if the withdrawal amount exceeds the current balance.
     *
     * @param amount The amount to be withdrawn.
     * @throws InsufficientFundsException Thrown if there are insufficient funds for the withdrawal.
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Cannot withdraw " + amount);
        }
        balance -= amount;
    }

    /**
     * Gets the current balance of the account.
     *
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Custom exception class representing insufficient funds for a withdrawal operation.
     */
    @SuppressWarnings("serial")
	public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
    
    @Test
    public void testDeposit() {
        Assignment7Q3 bankAccount = new Assignment7Q3();
        bankAccount.setInitialBalance(1000);

        // Deposit a specific amount
        bankAccount.deposit(500);

        // Verify that the balance has increased accordingly
        assertEquals(1500, bankAccount.getBalance());
    }

    @Test
   public  void testWithdrawSufficientFunds() {
        Assignment7Q3 bankAccount = new Assignment7Q3();
        bankAccount.setInitialBalance(1000);

        // Withdraw a specific amount that is less than the current balance
        assertDoesNotThrow(() -> bankAccount.withdraw(500));

        // Verify that the balance has decreased accordingly
        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Assignment7Q3 bankAccount = new Assignment7Q3();
        bankAccount.setInitialBalance(1000);

        // Withdraw an amount greater than the current balance
        assertThrows(Assignment7Q3.InsufficientFundsException.class, () -> bankAccount.withdraw(2000));

        // Verify that the balance remains unchanged
        assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawExactBalance() {
        Assignment7Q3 bankAccount = new Assignment7Q3();
        bankAccount.setInitialBalance(1000);

        // Withdraw an amount equal to the current balance
        assertDoesNotThrow(() -> bankAccount.withdraw(1000));

        // Verify that the balance is now zero
        assertEquals(0, bankAccount.getBalance());
    }

    

    /**
     * Main method for testing the Assignment7Q3 class.
     */
    public static void main(String[] args) {
        Assignment7Q3 bankAccount = new Assignment7Q3();

        // Set an initial balance
        bankAccount.setInitialBalance(1000);

        try {
            // Try to withdraw an amount greater than the current balance
            bankAccount.withdraw(2000);
            logger.info("Withdrawal successful. New balance: " + bankAccount.getBalance());
        } catch (InsufficientFundsException e) {
           logger.info("Error: " + e.getMessage());
        }
    }
}
