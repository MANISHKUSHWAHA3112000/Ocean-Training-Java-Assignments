package insurancebazzar;

import static java.util.logging.Level.INFO;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment12Q1Test {

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
    void testAddPolicyDetailsWithLogger() {
        Logger loggerMock = mock(Logger.class);
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(loggerMock);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");

        // Verify that the logger was called with the expected message and level
        verify(loggerMock).log(INFO, "Added policy with ID: 10654");
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

    
    @Test
    void testSearchBasedOnExactPolicyTypeMatch() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");
        insuranceBazaar.addPolicyDetails(10321, "SBI Health Insurance");
        insuranceBazaar.addPolicyDetails(20145, "IFFCO Tokio Two Wheeler Insurance");
        insuranceBazaar.addPolicyDetails(20165, "New India Assurance Two Wheeler Insurance");

        // Searching with an exact match should return the policy with that type
        List<Integer> searchResult = insuranceBazaar.searchBasedOnPolicyType("SBI Health Insurance");
        assertEquals(List.of(10321), searchResult);

        // Searching with an exact match for a two-wheeler policy
        searchResult = insuranceBazaar.searchBasedOnPolicyType("IFFCO Tokio Two Wheeler Insurance");
        assertEquals(List.of(20145), searchResult);
    }

    @Test
    void testSearchBasedOnPolicyTypeCaseInsensitive() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");
        insuranceBazaar.addPolicyDetails(10321, "SBI Health Insurance");

        // Searching with a different case should still return the matching policies
        List<Integer> searchResult = insuranceBazaar.searchBasedOnPolicyType("sbi health insurance");
        assertEquals(List.of(10321), searchResult);
    }

   

    

    @Test
    void testSearchBasedOnPolicyTypeWithNoMatches() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");

        // Searching for a non-existing policy type should return an empty list
        List<Integer> searchResult = insuranceBazaar.searchBasedOnPolicyType("Car Insurance");
        assertEquals(List.of(), searchResult);
    }

    @Test
    void testAddMultiplePoliciesWithSameType() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        insuranceBazaar.addPolicyDetails(10654, "Max Bupa Health Insurance");
        insuranceBazaar.addPolicyDetails(10321, "SBI Health Insurance");
        insuranceBazaar.addPolicyDetails(20145, "IFFCO Tokio Two Wheeler Insurance");
        insuranceBazaar.addPolicyDetails(20165, "New India Assurance Two Wheeler Insurance");
        insuranceBazaar.addPolicyDetails(30123, "ABC Health Insurance"); // Another health insurance

        // Searching for health insurance should return multiple policies
        List<Integer> searchResult = insuranceBazaar.searchBasedOnPolicyType("Health");
        assertEquals(List.of(10321, 10654, 30123), searchResult);
    }

    @Test
    void testAddPolicyWithEmptyName() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        // Adding a policy with an empty name
        insuranceBazaar.addPolicyDetails(10654, "");

        // The policy details should still be added
        Map<Integer, String> policyDetails = insuranceBazaar.getPolicyDetails();
        assertEquals(1, policyDetails.size());
        assertEquals("", policyDetails.get(10654));
    }

    @Test
    void testAddPolicyWithNullName() {
        InsuranceBazaar insuranceBazaar = new InsuranceBazaar(null);

        // Adding a policy with a null name
        insuranceBazaar.addPolicyDetails(10654, null);

        // The policy details should still be added
        Map<Integer, String> policyDetails = insuranceBazaar.getPolicyDetails();
        assertEquals(1, policyDetails.size());
        assertNull(policyDetails.get(10654));
    }


}
