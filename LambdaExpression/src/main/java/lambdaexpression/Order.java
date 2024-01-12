package lambdaexpression;

/**
 * order class
 */
public class Order {
	 /**
	 * price
	 */
	private double price;
	    /**
	     * status
	     */
	    private String status;

	    /**
	     * @param price
	     * @param status
	     */
	    public Order(double price, String status) {
	        this.price = price;
	        this.status = status;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public String getStatus() {
	        return status;
	    }
}
