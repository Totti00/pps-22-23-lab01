import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest {

    public static final int INITIAL_DEPOSIT = 500;
    public static final int NUMBER_OF_ATTEMPS = 100;
    public static final int MONEY_TO_WITHDRAW = 2;
    public static final int INITIAL_DEPOSIT_WITH_FEE = 499;
    public static final int USER_ID_NOT_EXIST = 2;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    private void initializeBalance() {
        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
    }

    @Test
    void testCheckInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        initializeBalance();
        assertEquals(INITIAL_DEPOSIT_WITH_FEE, bankAccount.getBalance());
    }

    @Test
    void testCheckBalanceAfterMultipleDeposit() {
        for (int i = 0; i < NUMBER_OF_ATTEMPS; i++) {
            bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
        }
        int balanceAfterDeposits = 49900;
        assertEquals(balanceAfterDeposits, bankAccount.getBalance());
    }

    @Test
    void testWrongUserDeposit() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(USER_ID_NOT_EXIST, INITIAL_DEPOSIT));
    }

    @Test
    void testWithdraw() {
        initializeBalance();
        bankAccount.withdraw(accountHolder.getId(), MONEY_TO_WITHDRAW);
        int balanceAfterWithdraw = 496;
        assertEquals(balanceAfterWithdraw, bankAccount.getBalance());
    }

    @Test
    void testWrongUserWithdraw() {
        initializeBalance();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(USER_ID_NOT_EXIST, MONEY_TO_WITHDRAW));
    }

    @Test
    void testCheckBalanceAfterMultipleWithdraw() {
        initializeBalance();
        for (int i = 0; i < NUMBER_OF_ATTEMPS; i++) {
            bankAccount.withdraw(accountHolder.getId(), MONEY_TO_WITHDRAW);
        }
        int balanceAfterWithdraws = 199;
        assertEquals(balanceAfterWithdraws, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.withdraw(accountHolder.getId(), MONEY_TO_WITHDRAW);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testHolder() {
        assertSame(bankAccount.getHolder(), accountHolder);
    }
}