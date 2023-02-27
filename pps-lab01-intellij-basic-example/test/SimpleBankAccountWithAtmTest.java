import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest {

    public static final int INITIAL_DEPOSIT = 500;
    public static final int NUMBER_OF_ATTEMPS = 100;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testCheckInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        initializeBalance();
        int initialDepositWithFee = 499;
        assertEquals(initialDepositWithFee, bankAccount.getBalance());
    }

    @Test
    void testCheckBalanceAfterMultipleDeposit() {
        int moneyAdded = 2;
        for (int i = 0; i < NUMBER_OF_ATTEMPS; i++) {
            bankAccount.deposit(accountHolder.getId(), moneyAdded);
        }
        int balanceAfterDeposits = 100;
        assertEquals(balanceAfterDeposits, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        initializeBalance();
        int moneyToWithdraw = 50;
        bankAccount.withdraw(accountHolder.getId(), moneyToWithdraw);
        int balanceAfterWithdraw = 448;
        assertEquals(balanceAfterWithdraw, bankAccount.getBalance());
    }

    @Test
    void testCheckBalanceAfterMultipleWithdraw() {
        initializeBalance();
        int moneyTaken = 2;
        for (int i = 0; i < NUMBER_OF_ATTEMPS; i++) {
            bankAccount.withdraw(accountHolder.getId(), moneyTaken);
        }
        int balanceAfterWithdraws = 199;
        assertEquals(balanceAfterWithdraws, bankAccount.getBalance());
    }

    private void initializeBalance() {
        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
    }

    @Test
    void testHolder() {
        assertSame(bankAccount.getHolder(), accountHolder);
    }

    @Test
    void testWrongUserDeposit() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(2, INITIAL_DEPOSIT));
    }

    @Test
    void testWrongUserWithdraw() {
        initializeBalance();
        int attemptWithdraw = 5;
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(2, attemptWithdraw));
    }

    @Test
    void testWrongWithdraw() {
        initializeBalance();
        int attemptWrongWithdraw = 500;
        bankAccount.withdraw(accountHolder.getId(), attemptWrongWithdraw);
        assertEquals(INITIAL_DEPOSIT - 1, bankAccount.getBalance());
    }
}