package Collection_Framwork_Assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Assignment3Q3Test {

    @Test
    void testTraverseReverseWithEmptyList() {
        ArrayList<Integer> emptyList = new ArrayList<>();

        List<Integer> reversedList = Assignment3Q3.traverseReverse(emptyList);

        // The reversed list of an empty list should also be empty
        assertEquals(emptyList, reversedList);
    }

    @Test
    void testTraverseReverseWithSingleElement() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(42));

        List<Integer> reversedList = Assignment3Q3.traverseReverse(list);

        // The reversed list of a single-element list should be the same
        assertEquals(list, reversedList);
    }

    @Test
    void testTraverseReverseWithMultipleOccurrences() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 5));

        List<Integer> reversedList = Assignment3Q3.traverseReverse(list);

        // The reversed list should maintain the order of multiple occurrences
        List<Integer> expected = Arrays.asList(5, 5, 4, 4, 3, 2, 2, 1);
        assertEquals(expected, reversedList);
    }

    @Test
    void testTraverseReverseWithZero() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

        List<Integer> reversedList = Assignment3Q3.traverseReverse(list);

        // The reversed list should maintain the order of zeros
        assertEquals(list, reversedList);
    }
    
    @Test
    void testTraverseReverseWithNullElement() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, null, 3, null, 5));

        List<Integer> reversedList = Assignment3Q3.traverseReverse(list);

        // The reversed list should maintain the order, including null elements
        List<Integer> expected = Arrays.asList(5, null, 3, null, 1);
        assertEquals(expected, reversedList);
    }

    

    @Test
    void testTraverseReverseWithLargeList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            list.add(i);
        }

        List<Integer> reversedList = Assignment3Q3.traverseReverse(list);

        // The reversed list should maintain the order for a large list
        List<Integer> expected = new ArrayList<>(list);
        java.util.Collections.reverse(expected);
        assertEquals(expected, reversedList);
    }
}
