import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest {

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
        int initialDeposit = 100;
        bankAccount.deposit(accountHolder.getId(), initialDeposit);
        int initialDepositWithFee = 99;
        assertEquals(initialDepositWithFee, bankAccount.getBalance());
    }

    @Test
    void TestCheckBalanceAfterMultipleDeposit() {
        int numberOfConsecutiveDeposits = 200;
        int moneyAdded = 2;
        for (int i = 0; i < numberOfConsecutiveDeposits; i++) {
            bankAccount.deposit(accountHolder.getId(), moneyAdded);
        }
        assertEquals(200, bankAccount.getBalance());
    }
    
}