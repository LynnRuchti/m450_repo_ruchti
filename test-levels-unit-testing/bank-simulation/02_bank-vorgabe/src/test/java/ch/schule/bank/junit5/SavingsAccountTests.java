package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTests{
    @Test
    public void test()
    {
        SavingsAccount acc = new SavingsAccount("S-1");

        acc.deposit(1, 1000);

        assertTrue(acc.withdraw(2, 1000));

        assertEquals(0, acc.getBalance());

        assertFalse(acc.withdraw(3, 1));

        assertEquals(0, acc.getBalance());
    }
}