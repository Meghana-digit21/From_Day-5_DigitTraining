
package bankingsystem;

public class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw $" + amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed the withdrawal of $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw $" + amount + " but only $" + balance + " is available. Withdrawal failed.");
        }
    }
    public double getBalance() {
        return balance;
    }
}
