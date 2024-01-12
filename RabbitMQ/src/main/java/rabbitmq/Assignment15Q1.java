//package rabbitmq;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//import java.util.concurrent.TimeoutException;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.MessageProperties;
//
//public class Assignment15Q1 {
//
//    private static final String EXCHANGE_NAME = "product_exchange";
//    private static final String QUEUE_NAME = "product_queue";
//
//    static final Map<Integer, Product> productInventory = new HashMap<>();
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//        initializeProductInventory();
//
//        final ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//
//        try (Connection connection = factory.newConnection();
//             Channel channel = connection.createChannel()) {
//
//            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
//            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
//
//            sendLowQuantityNotification(channel);
//
//        } catch (IOException | TimeoutException e) {
//            e.printStackTrace();
//        }
//    }
//
//    static void sendLowQuantityNotification(final Channel channel) throws IOException {
//        while (true) {
//            try {
//                Thread.sleep(5000); // Simulate checking inventory every 5 seconds
//
//                int productId = getRandomProductId();
//                final Product product = productInventory.get(productId);
//
//                if (product != null && product.getQuantity() < 10) {
//                    final String message = "Low Quantity Alert: Product ID " + productId +
//                            " - " + product.getName() +
//                            ", Current Quantity: " + product.getQuantity();
//
//                    channel.basicPublish(EXCHANGE_NAME, "", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
//                    System.out.println("Sent: " + message);
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt(); // Preserve the interrupted status
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static int getRandomProductId() {
//        if (productInventory.isEmpty()) {
//            throw new IllegalStateException("Product inventory is empty");
//        }
//
//        final Random random = new Random();
//        final int randomIndex = random.nextInt(productInventory.size());
//        
//        return (int) productInventory.keySet().toArray()[randomIndex];
//    }
//
//
//    private static void initializeProductInventory() {
//        productInventory.put(26342, new Product(26342, "Skullcandy In-Ear Earbud", "Electronics", 123));
//        // ... (other product entries)
//    }
//
//    static class Product {
//        private final int id;
//        private final String name;
//        private final String category;
//        private int quantity;
//
//        public Product(int id, String name, String category, int quantity) {
//            this.id = id;
//            this.name = name;
//            this.category = category;
//            this.quantity = quantity;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getCategory() {
//            return category;
//        }
//
//        public int getQuantity() {
//            return quantity;
//        }
//
//        public void setQuantity(int quantity) {
//            this.quantity = quantity;
//        }
//    }
//}
