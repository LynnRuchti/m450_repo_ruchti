import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.HelperFunc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HelperFuncTest {

    private Address sampleAddress;

    @BeforeEach
    void setUp() {
        sampleAddress = new Address(1, "Erika", null, "987654", new Date());
    }

    @Test
    void testToValueMapExcludesNulls() {
        Map<Integer, Object> values = HelperFunc.toValueMap(sampleAddress);

        assertTrue(values.containsKey(0));
        assertFalse(values.containsKey(1));
        assertTrue(values.containsKey(2));
    }

    @Test
    void testCompareIfBothPresent() {
        int result = HelperFunc.compareIfBothPresent(null, "Test");
        assertEquals(0, result);
    }
}