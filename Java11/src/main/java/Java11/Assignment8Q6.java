package Java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment8Q6 {

    private static final Logger logger = Logger.getLogger(Assignment8Q6.class.getName());
    
    @SuppressWarnings("unused")
	private HttpClient httpClient;

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public static void main(String[] args) {
        Assignment8Q6 assignment = new Assignment8Q6();
        assignment.sendHttpRequest();
    }

    public void sendHttpRequest() {
        // Create an HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Create a GET request to the specified URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .header("User-Agent", "Java 11 HttpClient Bot") // Optional: Set a custom user agent
                .build();

        try {
            // Send the GET request and receive the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Logging example
            logger.log(Level.INFO, "Response Status Code: " + response.statusCode());

            // Log the response headers
            response.headers().map().forEach((key, values) ->
                    logger.log(Level.INFO, key + ": " + values));

            // Log the response body
            logger.log(Level.INFO, "Response Body:\n" + response.body());

        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred while sending the HTTP request: " + e.getMessage(), e);
        }
    }
}
