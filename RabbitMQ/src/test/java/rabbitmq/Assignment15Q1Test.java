//package rabbitmq;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.atLeastOnce;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.MessageProperties;
//
//import rabbitmq.Assignment15Q1;
//
//class Assignment15Q1Test {
//
//    private Assignment15Q1 productInventoryService;
//    private Channel mockChannel;
//
//    @BeforeEach
//    void setUp() {
//        // Mocking RabbitMQ Channel for testing
//        mockChannel = mock(Channel.class);
//
//        // Creating a test instance of Assignment15Q1
//        productInventoryService = new Assignment15Q1();
//    }
//
//    @Test
//    void testSendLowQuantityNotification() throws IOException, InterruptedException {
//        // Arrange
//        Map<Integer, Assignment15Q1.Product> testProductInventory = new HashMap<>();
//        testProductInventory.put(1, new Assignment15Q1.Product(1, "TestProduct", "TestCategory", 5));
//
//        // Set up the product inventory in the service
//        Assignment15Q1.productInventory.clear();
//        Assignment15Q1.productInventory.putAll(testProductInventory);
//
//        // Mocking behavior for basicPublish (do nothing)
//        doNothing().when(mockChannel).basicPublish(eq("product_exchange"), eq(""), eq(MessageProperties.PERSISTENT_TEXT_PLAIN), any(byte[].class));
//
//        // Act
//        productInventoryService.sendLowQuantityNotification(mockChannel);
//
//        // Assert
//        // Verify that basicPublish was called on the mockChannel at least once
//        verify(mockChannel, atLeastOnce())
//                .basicPublish(eq("product_exchange"), eq(""), eq(MessageProperties.PERSISTENT_TEXT_PLAIN), any(byte[].class));
//    }
//}
