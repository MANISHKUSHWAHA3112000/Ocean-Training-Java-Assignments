package oopsassignments;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Assignment2Q7Test {

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
}
