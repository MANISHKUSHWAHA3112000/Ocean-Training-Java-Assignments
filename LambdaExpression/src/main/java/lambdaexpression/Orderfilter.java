package lambdaexpression;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * orderfilter
 */
public class Orderfilter {
	private static final Logger logger=Logger.getLogger(Hintlambda.class.getName());

    /**
     * @param orders
     * @return
     */
    public static List<Order> filterOrders(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getPrice() > 10000 && (order.getStatus().equals("ACCEPTED") || order.getStatus().equals("COMPLETED")))
                .toList();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(15000, "ACCEPTED"));
        orders.add(new Order(8000, "COMPLETED"));
        orders.add(new Order(12000, "PENDING"));

        List<Order> filteredOrders = filterOrders(orders);

        filteredOrders.forEach(order -> logger.info("Price: " + order.getPrice() + ", Status: " + order.getStatus()));
    }
}
