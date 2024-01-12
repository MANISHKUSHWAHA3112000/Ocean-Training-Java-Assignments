package lambdaexpression;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java. util. ArrayList ;


public class OrderfilterTest {

	private PrintStream originalOut;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() {
		originalOut = System.out;
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
	}

	@After
	public void tearDown() {
		System.setOut(originalOut);
	}
	
    @Test
    public void testFilterOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(15000, "ACCEPTED"));
        orders.add(new Order(8000, "COMPLETED"));
        orders.add(new Order(12000, "PENDING"));

        List<Order> filteredOrders = Orderfilter.filterOrders(orders);

        assertEquals(1, filteredOrders.size());
        assertEquals(15000, filteredOrders.get(0).getPrice(), 0.01);
        assertEquals("ACCEPTED", filteredOrders.get(0).getStatus());
    }

    @Test
    public void testMainMethod() {
    	String expectedOutput = "Price: 15000";
    	Orderfilter.main(null);
    	
    	String outputText = output.toString();
    	assertTrue(outputText.contains(expectedOutput));
    }
    


}

