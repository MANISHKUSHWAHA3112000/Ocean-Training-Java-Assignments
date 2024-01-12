package lambdaexpression;





import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        order = new Order(100.0, "Pending");
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = 100.0;
        assertEquals(expectedPrice, order.getPrice(), 0.01);
    }

    @Test
    public void testGetStatus() {
        String expectedStatus = "Pending";
        assertEquals(expectedStatus, order.getStatus());
    }
}
