package exceptionhandling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

/** IllegalBankTransactionException class which extends Exception **/
@SuppressWarnings("serial")
class IllegalBankTransactionException extends Exception {
    public IllegalBankTransactionException(String message) {
        super(message);
    }
}

public class Assignment4Q3b {

    private static final Logger logger = Logger.getLogger(Assignment4Q3b.class.getName());

    @SuppressWarnings("serial")
    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    /** class SavingAccount **/
    static class SavingAccount {

        private final long id;
        private double balance;
        @SuppressWarnings("unused")
		private static final Logger logger = Logger.getLogger(SavingAccount.class.getName());

        /** Constructor with parameter validation **/
        public SavingAccount(final long id, final double initialBalance) {
            this.id = id;
            this.balance = initialBalance;
        }

        
     // SavingAccount class
        public int deposit(int amount) throws IllegalBankTransactionException {
            if (amount < 0) {
                throw new IllegalBankTransactionException("Invalid transaction amount: " + amount);
            }
            balance += amount;
            return amount;
        }

        
        /** Method for withdrawal with exception handling **/
        public double withdraw(final double amount)
                throws IllegalBankTransactionException, InsufficientBalanceException {
            // Validate withdrawal amount
            if (amount < 0) {
                throw new IllegalBankTransactionException("Cannot withdraw a negative amount");
            }

            /** Check for insufficient balance or zero balance **/
            if (amount > balance || balance == 0) {
                throw new InsufficientBalanceException("Insufficient balance to withdraw " + amount);
            }

            // Perform the withdrawal
            balance -= amount;
            return amount;
        }

        /** Getter for balance **/
        public double getBalance() {
            return balance;
        }

        /** Getter for account ID **/
        public long getId() {
            return id;
        }

      

    }



    @Test
    public void testWithdrawalWithZeroBalance() {
        SavingAccount savingAcc = new SavingAccount(10, 0);

        InsufficientBalanceException exception = assertThrows(InsufficientBalanceException.class, () -> {
            savingAcc.withdraw(100);
        });

        assertEquals("Insufficient balance to withdraw 100.0", exception.getMessage());
    }

    @Test
    public void testDepositWithZeroAmount() throws IllegalBankTransactionException {
        SavingAccount savingAcc = new SavingAccount(13, 1000);

        // Expecting no exception to be thrown
        assertDoesNotThrow(() -> savingAcc.deposit(0));
        
        // Additional assertion to check the balance after the deposit
        assertEquals(1000, savingAcc.getBalance(), 0);
    }




    @Test
    public void testWithdrawalWithValidAmount() throws IllegalBankTransactionException, InsufficientBalanceException {
        SavingAccount savingAcc = new SavingAccount(15, 2000);

        double withdrawnAmount = savingAcc.withdraw(500);

        assertEquals(500, withdrawnAmount, 0);
        assertEquals(1500, savingAcc.getBalance(), 0);
    }

    @Test
    public void testDepositWithNegativeAmount() {
        SavingAccount savingAcc = new SavingAccount(16, 2000);

        assertThrows(IllegalBankTransactionException.class, () -> {
            savingAcc.deposit(-500);
        });
    }

    /** Main method for console testing **/
    public static void main(String[] args) {
        SavingAccount savingAcc = new SavingAccount(1, 2000);

        try {
            // Try withdrawing a negative amount
            savingAcc.withdraw(-1000);
        } catch (InsufficientBalanceException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        } catch (IllegalBankTransactionException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }

        try {
            // Try a valid withdrawal
            final double withdrawnAmount = savingAcc.withdraw(500);
            logger.log(Level.INFO,
                    "Withdrawal of " + withdrawnAmount + " successful. Remaining balance: " + savingAcc.getBalance());
        } catch (InsufficientBalanceException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        } catch (IllegalBankTransactionException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }
    }

}   
