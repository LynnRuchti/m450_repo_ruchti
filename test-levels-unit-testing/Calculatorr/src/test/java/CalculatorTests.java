import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    Calculator cal = new Calculator();

    @Test
    public void addNumbers(){
        assertEquals(22.11, cal.add(10.01, 12.10));
    }

    @Test
    public void subtractNumbers(){
        assertEquals(21.03, cal.subtract(32.30, 11.27), 0.0001);
    }

    @Test
    public void multiplyNumbers(){
        assertEquals(20.00, cal.multiply(5.00, 4.00));
    }

    @Test
    public void divideNumbers(){
        assertEquals(22.00, cal.divide(66.00, 3.00));
    }
}
