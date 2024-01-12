package oopsassignments;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.logging.Logger;

abstract class DesertItem {
    abstract public int getCost();
    abstract public void addCandy(int quantity);
    abstract public void addCookie(int quantity);
    abstract public void addIceCream(int quantity);
}

class Candy extends DesertItem {
    private static final int COST = 20;
    private int candyQuantity;
    private static final Logger logger = Logger.getLogger(Candy.class.getName());

    @Override
    public int getCost() {
        return COST;
    }

    @Override
    public void addCandy(int quantity) {
        candyQuantity += quantity;
        logger.info("Candy added: " + quantity);
    }

    @Override
    public void addCookie(int quantity) {
        // No implementation for Candy
    }

    @Override
    public void addIceCream(int quantity) {
        // No implementation for Candy
    }

    public int getCandyQuantity() {
        return candyQuantity;
    }
}

class Cookie extends DesertItem {
    private static final int COST = 50;
    private int cookieQuantity;
    private static final Logger logger = Logger.getLogger(Cookie.class.getName());

    @Override
    public int getCost() {
        return COST;
    }

    @Override
    public void addCandy(int quantity) {
        // No implementation for Cookie
    }

    @Override
    public void addCookie(int quantity) {
        cookieQuantity += quantity;
        logger.info("Cookie added: " + quantity);
    }

    @Override
    public void addIceCream(int quantity) {
        // No implementation for Cookie
    }

    public int getCookieQuantity() {
        return cookieQuantity;
    }
}

class IceCream extends DesertItem {
    private static final int COST = 80;
    private int iceCreamQuantity;
    private static final Logger logger = Logger.getLogger(IceCream.class.getName());

    @Override
    public int getCost() {
        return COST;
    }

    @Override
    public void addCandy(int quantity) {
        // No implementation for Ice Cream
    }

    @Override
    public void addCookie(int quantity) {
        // No implementation for Ice Cream
    }

    @Override
    public void addIceCream(int quantity) {
        iceCreamQuantity += quantity;
        logger.info("Ice Cream added: " + quantity);
    }

    public int getIceCreamQuantity() {
        return iceCreamQuantity;
    }
}

public class Assignment2Q7 {

    private static final Logger logger = Logger.getLogger(Assignment2Q7.class.getName());

    @Test
    public void testCandy() {
        DesertItem candy = new Candy();
        candy.addCandy(5);
        assertEquals(20, candy.getCost());
    }

    @Test
    public void testCookie() {
        DesertItem cookie = new Cookie();
        cookie.addCookie(3);
        assertEquals(50, cookie.getCost());
    }

    @Test
    public void testIceCream() {
        DesertItem iceCream = new IceCream();
        iceCream.addIceCream(2);
        assertEquals(80, iceCream.getCost());
    }

    @Test
    public void testBuyItems() {
        int candyQuantity = 2;
        int cookieQuantity = 3;
        int iceCreamQuantity = 1;

        DesertItem candy = new Candy();
        DesertItem cookie = new Cookie();
        DesertItem iceCream = new IceCream();

        int totalCost = (candy.getCost() * candyQuantity) +
                        (cookie.getCost() * cookieQuantity) +
                        (iceCream.getCost() * iceCreamQuantity);

        // Corrected expected value to 270
        assertEquals(270, totalCost);
    }

    @SuppressWarnings("unused")
	private static void buyItems(DesertItem candy, DesertItem cookie, DesertItem iceCream,
                                 int candyQuantity, int cookieQuantity, int iceCreamQuantity) {
        int totalCost = (candy.getCost() * candyQuantity) +
                        (cookie.getCost() * cookieQuantity) +
                        (iceCream.getCost() * iceCreamQuantity);

        logger.info("Total cost: " + totalCost);
    }
}
