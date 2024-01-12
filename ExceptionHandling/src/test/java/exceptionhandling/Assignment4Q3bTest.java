package exceptionhandling;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Assignment4Q3bTest {

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
    public void testWithdrawalWithNegativeAmount() {
        SavingAccount savingAcc = new SavingAccount(14, 1500);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            savingAcc.withdraw(-300);
        });

        assertEquals("Invalid withdrawal amount: -300.0", exception.getMessage());
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
}
