package Java11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Assignment8Q6Test {

    private Assignment8Q6 assignment;
    private HttpClient mockHttpClient;

    @BeforeEach
    void setUp() {
        assignment = new Assignment8Q6();
        mockHttpClient = Mockito.mock(HttpClient.class);
        assignment.setHttpClient(mockHttpClient);
    }
   

    @SuppressWarnings("unchecked")
	@Test
    void testSendHttpRequestError() throws Exception {
        // Given
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenThrow(new RuntimeException("Simulated error"));

        // When
        assignment.sendHttpRequest();

        // Then
        // Assert that the log message contains the expected error message
        assertLogContains("An error occurred while sending the HTTP request: Simulated error");
    }

    // Helper method to capture log messages
    private void assertLogContains(String expectedMessage) {
        Logger logger = Logger.getLogger(Assignment8Q6.class.getName());
        TestHandler testHandler = new TestHandler();
        logger.addHandler(testHandler);

        // Trigger a log statement to capture it
        logger.log(Level.INFO, "Test log message");

        // Assert that the captured log messages contain the expected message
        assertEquals(expectedMessage, testHandler.getCapturedLog());
    }

    // Helper class to capture log messages
    private static class TestHandler extends Handler {
        private StringBuilder capturedLog = new StringBuilder();

        @Override
        public void publish(LogRecord record) {
            capturedLog.append(record.getMessage()).append("\n");
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() throws SecurityException {
        }

        public String getCapturedLog() {
            return capturedLog.toString().trim();
        }
    }
}
