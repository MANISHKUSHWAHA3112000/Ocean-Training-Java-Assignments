package Collection_Framwork_Assignment;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedHashSet;

import org.junit.Test;

public class Assignment3Q2Test {

    @Test
    public void testOrdered() {
        Assignment3Q2 assignment = new Assignment3Q2();

        LinkedHashSet<String> lh = new LinkedHashSet<>();
        lh.add("A");
        lh.add("B");
        lh.add("C");
        lh.add("D");
        lh.add("E");

        LinkedHashSet<String> result = assignment.ordered(lh);

        // Since the input LinkedHashSet is already ordered, the result should be the same
        assertEquals(lh, result);
    }
    @Test
    public void testUnordered() {
        Assignment3Q2 assignment = new Assignment3Q2();

        HashSet<String> hash = new HashSet<>();
        hash.add("manish");
        hash.add("gourav");
        hash.add("rahul");
        hash.add("aryan");
        hash.add("Ritik");

        HashSet<String> result = assignment.unordered(hash);

        // Since the input HashSet is unordered, the result HashSet should have the same elements
        // regardless of the order
        assertEquals(hash.size(), result.size());
        assertTrue(hash.containsAll(result) && result.containsAll(hash));
    }
    
    @Test
    public void testOrderedWithDuplicates() {
        Assignment3Q2 assignment = new Assignment3Q2();

        LinkedHashSet<String> lh = new LinkedHashSet<>();
        lh.add("A");
        lh.add("B");
        lh.add("C");
        lh.add("B"); // Adding a duplicate
        lh.add("D");
        lh.add("E");

        LinkedHashSet<String> result = assignment.ordered(lh);

        // Since the input LinkedHashSet is already ordered, including duplicates, the result should be the same
        assertEquals(lh, result);
    }

    @Test
    public void testUnorderedWithDuplicates() {
        Assignment3Q2 assignment = new Assignment3Q2();

        HashSet<String> hash = new HashSet<>();
        hash.add("manish");
        hash.add("gourav");
        hash.add("rahul");
        hash.add("aryan");
        hash.add("Ritik");
        hash.add("gourav"); // Adding a duplicate

        HashSet<String> result = assignment.unordered(hash);

        // Since the input HashSet is unordered, including duplicates, the result HashSet should have the same elements
        // regardless of the order and should include the duplicates
        assertEquals(hash.size(), result.size());
        assertTrue(hash.containsAll(result) && result.containsAll(hash));
    }

    @Test
    public void testOrderedWithEmptySet() {
        Assignment3Q2 assignment = new Assignment3Q2();

        LinkedHashSet<String> lh = new LinkedHashSet<>();

        LinkedHashSet<String> result = assignment.ordered(lh);

        // Since the input LinkedHashSet is empty, the result should also be empty
        assertTrue(result.isEmpty());
    }

    @Test
    public void testUnorderedWithEmptySet() {
        Assignment3Q2 assignment = new Assignment3Q2();

        HashSet<String> hash = new HashSet<>();

        HashSet<String> result = assignment.unordered(hash);

        // Since the input HashSet is empty, the result should also be empty
        assertTrue(result.isEmpty());
    }

    @Test
    public void testOrderedWithNullElement() {
        Assignment3Q2 assignment = new Assignment3Q2();

        LinkedHashSet<String> lh = new LinkedHashSet<>();
        lh.add("A");
        lh.add("B");
        lh.add(null); // Adding a null element
        lh.add("D");
        lh.add("E");

        LinkedHashSet<String> result = assignment.ordered(lh);

        // Since the input LinkedHashSet contains a null element, the result should be the same
        assertEquals(lh, result);
    }

    @Test
    public void testUnorderedWithNullElement() {
        Assignment3Q2 assignment = new Assignment3Q2();

        HashSet<String> hash = new HashSet<>();
        hash.add("manish");
        hash.add("gourav");
        hash.add(null); // Adding a null element
        hash.add("aryan");
        hash.add("Ritik");

        HashSet<String> result = assignment.unordered(hash);

        // Since the input HashSet contains a null element, the result HashSet should have the same elements
        // regardless of the order, and it should include the null element
        assertEquals(hash.size(), result.size());
        assertTrue(hash.containsAll(result) && result.containsAll(hash));
    }

   
    
}
