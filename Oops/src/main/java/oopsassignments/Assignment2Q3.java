package oopsassignments;

import java.util.logging.Logger;


class Bank {
    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Bank.class.getName());
    private int totalDeposits;

    public Bank(int totalDeposits) {
        this.totalDeposits = totalDeposits;
    }

    public int getTotalDeposits() {
        return totalDeposits;
    }
}

class CurrentAccount extends Bank {
    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CurrentAccount.class.getName());
    private int creditLimit;

    public CurrentAccount(int totalDeposits, int creditLimit) {
        super(totalDeposits);
        this.creditLimit = creditLimit;
    }

    public int getCash() {
        return getTotalDeposits() - creditLimit;
    }
}

class SavingsAccount extends Bank {
    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(SavingsAccount.class.getName());
    private int fixedDepositAmount;

    public SavingsAccount(int totalDeposits, int fixedDepositAmount) {
        super(totalDeposits);
        this.fixedDepositAmount = fixedDepositAmount;
    }

    public int getCash() {
        return getTotalDeposits() + fixedDepositAmount;
    }
}

public class Assignment2Q3 {
	
	Assignment2Q3(){}
	
	
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;

    public Assignment2Q3(CurrentAccount currentAccount, SavingsAccount savingsAccount) {
        this.currentAccount = currentAccount;
        this.savingsAccount = savingsAccount;
    }

    public int totalCashInBank() {
        return currentAccount.getCash() + savingsAccount.getCash();
    }
	
	
    private static final Logger logger = Logger.getLogger(Assignment2Q3.class.getName());

    

    public static void main(String[] args) {
        CurrentAccount currentAccount = new CurrentAccount(10000, 2000);
        SavingsAccount savingsAccount = new SavingsAccount(10000, 5000);

        Assignment2Q3 assignment2Q3 = new Assignment2Q3(currentAccount, savingsAccount);

        // Logging instead of System.out.println
        logger.info("Current Account Cash: " + currentAccount.getCash());
        logger.info("Savings Account Cash: " + savingsAccount.getCash());

        logger.info("Total Cash in Bank: " + assignment2Q3.totalCashInBank());
    }
    
    
}
