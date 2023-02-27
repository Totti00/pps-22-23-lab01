package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount{

    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public AccountHolder getHolder() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void deposit(int userID, double amount) {

    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
