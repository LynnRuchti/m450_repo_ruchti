package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PromoYouthSavingsAccountTests {
    @Test
    public void test()
    {
        PromoYouthSavingsAccount acc = new PromoYouthSavingsAccount("Y-1");

        assertTrue(acc.deposit(1, 10000));

        assertEquals(10100, acc.getBalance());

        assertFalse(acc.deposit(2, -100));

        assertEquals(10100, acc.getBalance());

        assertFalse(acc.withdraw(3, 20000));

        assertEquals(10100, acc.getBalance());
    }
}