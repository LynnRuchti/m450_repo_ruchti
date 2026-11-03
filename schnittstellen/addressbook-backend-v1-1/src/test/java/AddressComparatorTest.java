import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressComparatorTest {

    private AddressComparator comparator;

    @BeforeEach
    void setUp() {
        comparator = new AddressComparator();
    }

    @Test
    void testCompareByFirstname() {
        Address a1 = new Address(1, "Zoe", "Smith", "123", new Date());
        Address a2 = new Address(2, "Adam", "Smith", "123", new Date());

        int result = comparator.compare(a1, a2);
        assertTrue(result > 0);
    }

    @Test
    void testCompareByLastnameWhenFirstnameEqual() {
        Address a1 = new Address(1, "John", "Brown", "123", new Date());
        Address a2 = new Address(2, "John", "Smith", "123", new Date());

        int result = comparator.compare(a1, a2);
        assertTrue(result < 0);
    }

    @Test
    void testCompareAWholeList() {
        Address a1 = new Address(1, "John", "Brown", "123", new Date());
        Address a2 = new Address(2, "John", "Smith", "123", new Date());
        Address a3 = new Address(3, "Elif", "Canmaya", "123", new Date());
        Address a4 = new Address(4, "Lisa", "Meergans", "123", new Date());
        Address a5 = new Address(5, "Sophia", "Sas", "123", new Date());

        ArrayList<Address> list = new ArrayList<>();
        list.add(a5);
        list.add(a2);
        list.add(a4);
        list.add(a1);
        list.add(a3);

        List<Address> sortedList = comparator.sort(list);

        ArrayList<Address> expected = new ArrayList<>();
        expected.add(a3);
        expected.add(a1);
        expected.add(a2);
        expected.add(a4);
        expected.add(a5);

        assertEquals(expected, sortedList);
    }

}