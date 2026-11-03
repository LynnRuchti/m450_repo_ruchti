package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BookingTests {

    @Test
    public void testInitialization()
    {
        Booking booking = new Booking(1, 1000);

        assertEquals(1, booking.getDate());

        assertEquals(1000, booking.getAmount());
    }

    @Test
    public void testPrint()
    {
        PrintStream old = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            new Booking(0, 100000).print(0);
        } finally {
            System.setOut(old);
        }

        assertTrue(out.toString().contains("01.01.1970"));
    }
}