package bankingsystem;

public class AccountHolder implements Runnable {
    private final BankAccount account;
    private final double withdrawalAmount;
    public AccountHolder(BankAccount account, double withdrawalAmount) {
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
    }
    @Override
    public void run() {
        account.withdraw(withdrawalAmount);
    }
}