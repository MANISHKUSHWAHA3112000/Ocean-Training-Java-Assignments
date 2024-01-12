package insurancebazzar;


import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Represents an Insurance Bazaar that stores policy details and allows searching based on policy type.
 */
class InsuranceBazaar {

    private final Map<Integer, String> policyDetails; // Map to store policy details
    private static Logger logger = Logger.getLogger(InsuranceBazaar.class.getName());

    /**
     * Constructor for InsuranceBazaar class.
     *
     * @param loggerMock The logger to be used for logging events.
     */
    @SuppressWarnings("static-access")
	public InsuranceBazaar(Logger loggerMock) {
        this.policyDetails = new TreeMap<>();
        this.logger = loggerMock != null ? loggerMock : Logger.getLogger(InsuranceBazaar.class.getName());
    }


    /**
     * Adds policy details to the InsuranceBazaar.
     *
     * @param policyId   The ID of the policy.
     * @param policyName The name of the policy.
     */
    public void addPolicyDetails(final int policyId, final String policyName) {
        policyDetails.put(policyId, policyName);
        logger.log(Level.INFO, "Added policy with ID: " + policyId);
    }

    /**
     * Searches for policies based on the given policy type.
     *
     * @param policyType The type of policy to search for.
     * @return A list of policy IDs matching the given policy type.
     */
    public List<Integer> searchBasedOnPolicyType(final String policyType) {
        List<Integer> result = new ArrayList<>();
        for (final Map.Entry<Integer, String> entry : policyDetails.entrySet()) {
            if (entry.getValue().toLowerCase().contains(
                    policyType != null ? policyType.toLowerCase() : "")) {
                result.add(entry.getKey());
            }
        }
        if (logger != null) {
            logger.log(Level.INFO, "Searched for policies with type: " + policyType);
        }
        return result;
    }


    /**
     * Gets the policy details stored in the InsuranceBazaar.
     *
     * @return A map containing policy IDs and their corresponding names.
     */
    public Map<Integer, String> getPolicyDetails() {
        return policyDetails;
    }
}

/**
 * Represents a test class for the InsuranceBazaar.
 */
public class Assignment12Q1 {

	@Test
    void testSearchBasedOnPolicyType() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");
        insuranceBazaar.addPolicyDetails(10321, "SBI Health Insurance");
        insuranceBazaar.addPolicyDetails(20145, "IFFCO Tokio Two Wheeler Insurance");
        insuranceBazaar.addPolicyDetails(20165, "New India Assurance Two Wheeler Insurance");

        List<Integer> searchResult1 = insuranceBazaar.searchBasedOnPolicyType("Two Wheeler");
        assertEquals(List.of(20145, 20165), searchResult1);

        List<Integer> searchResult2 = insuranceBazaar.searchBasedOnPolicyType("Health");
        assertEquals(List.of(10321, 10654), searchResult2);

        // Add more test cases for different policy types
        List<Integer> searchResult3 = insuranceBazaar.searchBasedOnPolicyType("Life");
        assertEquals(List.of(), searchResult3); // No matching policy, empty list expected
    }

    @Test
    void testInsuranceBazaar() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");
        insuranceBazaar.addPolicyDetails(10321, "SBI Health Insurance");
        insuranceBazaar.addPolicyDetails(20145, "IFFCO Tokio Two Wheeler Insurance");
        insuranceBazaar.addPolicyDetails(20165, "New India Assurance Two Wheeler Insurance");

        List<Integer> searchResult1 = insuranceBazaar.searchBasedOnPolicyType("Two Wheeler");
        assertEquals(List.of(20145, 20165), searchResult1);

        List<Integer> searchResult2 = insuranceBazaar.searchBasedOnPolicyType("Health");
        assertEquals(List.of(10321, 10654), searchResult2);
    }

    


    @Test
    void testSearchBasedOnInvalidPolicyType() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");

        // Searching with an invalid policy type should return an empty list
        List<Integer> searchResult = insuranceBazaar.searchBasedOnPolicyType("InvalidType");
        assertEquals(List.of(), searchResult);
    }
    
    @Test
    void testGetPolicyDetails() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");
        insuranceBazaar.addPolicyDetails(10321, "SBI Health Insurance");

        Map<Integer, String> policyDetails = insuranceBazaar.getPolicyDetails();
        assertEquals(2, policyDetails.size());
        assertEquals("Max Bupa Health Insurance", policyDetails.get(10654));
        assertEquals("SBI Health Insurance", policyDetails.get(10321));
    }

    @Test
    void testSearchBasedOnPartialPolicyTypeMatch() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");
        insuranceBazaar.addPolicyDetails(10321, "SBI Health Insurance");
        insuranceBazaar.addPolicyDetails(20145, "IFFCO Tokio Two Wheeler Insurance");
        insuranceBazaar.addPolicyDetails(20165, "New India Assurance Two Wheeler Insurance");

        // Searching with a partial match should return the relevant policies
        List<Integer> searchResult = insuranceBazaar.searchBasedOnPolicyType("Health");
        assertEquals(List.of(10321, 10654), searchResult);

        // Searching with a partial match for "Two" should return the two-wheeler policies
        searchResult = insuranceBazaar.searchBasedOnPolicyType("Two");
        assertEquals(List.of(20145, 20165), searchResult);
    }

    
    


    private static final Logger logger = Logger.getLogger(Assignment12Q1.class.getName());

    static {
        // Configuring a console handler for demonstration purposes
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
    }

    /**
     * Main method to demonstrate the functionality of the InsuranceBazaar.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        logger.log(Level.INFO, "Welcome to InsuranceBazaar!");

        // Adding policies
        logger.log(Level.INFO, "Enter the number of policies you want to store:");
        final int numberOfPolicies = scanner.nextInt();

        for (int i = 0; i < numberOfPolicies; i++) {
            logger.log(Level.INFO, "Enter the Policy ID for policy " + (i + 1) + ":");
            final int policyId = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            logger.log(Level.INFO, "Enter the Policy Name for policy " + (i + 1) + ":");
            final String policyName = scanner.nextLine();

            insuranceBazaar.addPolicyDetails(policyId, policyName);
        }

        // Displaying entered policies
        logger.log(Level.INFO, "\nPolicy details entered:");
        Map<Integer, String> policyDetails = insuranceBazaar.getPolicyDetails();
        for (final Map.Entry<Integer, String> entry : policyDetails.entrySet()) {
            logger.log(Level.INFO, entry.getKey() + " " + entry.getValue());
        }

        // Searching for policies
        logger.log(Level.INFO, "\nEnter the policy type to be searched:");
        final String policyType = scanner.nextLine();

        List<Integer> searchResult = insuranceBazaar.searchBasedOnPolicyType(policyType);
        if (!searchResult.isEmpty()) {
            logger.log(Level.INFO, "Policy IDs for the searched type: " + searchResult);
        } else {
            logger.log(Level.INFO, "No policies found for the searched type.");
        }

        scanner.close();
    }
}
