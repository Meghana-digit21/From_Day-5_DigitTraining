package bankingsystem;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread holder1 = new Thread(new AccountHolder(account, 500), "Holder1");
        Thread holder2 = new Thread(new AccountHolder(account, 300), "Holder2");
        Thread holder3 = new Thread(new AccountHolder(account, 700), "Holder3");

        holder1.start();
        holder2.start();
        holder3.start();
    }
}