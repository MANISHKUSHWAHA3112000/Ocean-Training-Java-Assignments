package Collection_Framwork_Assignment;

import static org.assertj.core.api.Assertions.assertThat; // Import the assertThat method

import org.junit.jupiter.api.Test;

class Assignment3Q9Test {

    @Test
    void testBankAccountList() {
        SavingAccount sa1 = new SavingAccount(5000, 101, "chris", true);
        SavingAccount sa2 = new SavingAccount(6000, 102, "Aryan", true);
        SavingAccount sa3 = new SavingAccount(7000, 103, "Sahil", true);

        BankAccountList bankList = new BankAccountList();

        assertThat(bankList.addSavingAccount(sa1)).isTrue();
        assertThat(bankList.addSavingAccount(sa2)).isTrue();
        assertThat(bankList.addSavingAccount(sa3)).isTrue();
        assertThat(bankList.addSavingAccount(sa1)).isFalse(); // Adding the same account again should return false

        assertThat(bankList.displaySavingAccountID()).containsExactly(101, 102, 103);

        sa1.deposit(2000);

        assertThat(bankList.displaySavingAccountID()).containsExactly(101, 102, 103);

        sa1.withDraw(1000); // Corrected the typo in the method name

        assertThat(bankList.displaySavingAccountID()).containsExactly(101, 102, 103);
    }
    
    @Test
    void testBankAccountListWithMultipleDepositsAndWithdrawals() {
        SavingAccount sa1 = new SavingAccount(5000, 101, "chris", true);

        BankAccountList bankList = new BankAccountList();

        assertThat(bankList.addSavingAccount(sa1)).isTrue();

        assertThat(bankList.displaySavingAccountID()).containsExactly(101);

        sa1.deposit(2000);
        assertThat(sa1.getAcc_balance()).isEqualTo(7000);

        sa1.withDraw(1000);
        assertThat(sa1.getAcc_balance()).isEqualTo(6000);

        sa1.deposit(3000);
        assertThat(sa1.getAcc_balance()).isEqualTo(9000);

        assertThat(bankList.displaySavingAccountID()).containsExactly(101);
    }

    @Test
    void testBankAccountListWithEmptyList() {
        BankAccountList bankList = new BankAccountList();

        assertThat(bankList.displaySavingAccountID()).isEmpty();
    }

    @Test
    void testBankAccountListWithDifferentAccountOrder() {
        SavingAccount sa1 = new SavingAccount(5000, 101, "chris", true);
        SavingAccount sa2 = new SavingAccount(6000, 102, "Aryan", true);
        SavingAccount sa3 = new SavingAccount(7000, 103, "Sahil", true);

        BankAccountList bankList = new BankAccountList();

        assertThat(bankList.addSavingAccount(sa2)).isTrue();
        assertThat(bankList.addSavingAccount(sa1)).isTrue();
        assertThat(bankList.addSavingAccount(sa3)).isTrue();

        assertThat(bankList.displaySavingAccountID()).containsExactly(101, 102, 103);
    }

}
