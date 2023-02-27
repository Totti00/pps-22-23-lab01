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
        return this.holder;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if(checkUser(userID)) {
            balance += --amount;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID)) {
            if (canToWithdraw(amount)) {
                balance -= ++amount;
            }
        }
    }

    private boolean canToWithdraw(double amount) {
        return this.balance >= amount;
    }

    private boolean checkUser(int userID) {
        if (userID != this.holder.getId()) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
