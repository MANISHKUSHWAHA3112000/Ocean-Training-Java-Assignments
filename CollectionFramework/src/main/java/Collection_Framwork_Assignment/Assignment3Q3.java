package Collection_Framwork_Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment3Q3 {

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment3Q3.class.getName());

    public static List<Integer> traverseReverse(ArrayList<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        ListIterator<Integer> it = list.listIterator();

        while (it.hasPrevious()) {
            // Use logger for logging
            logger.log(Level.INFO, String.valueOf(it.previous()));
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }
        return ans;
    }

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

    public static void main(String[] args) {
        // Logger for logging messages in the main method
        Logger mainLogger = Logger.getLogger(Assignment3Q3.class.getName());

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Log the reversed list using the logger
        List<Integer> reversedList = traverseReverse(list);
        mainLogger.log(Level.INFO, "Reversed List: " + reversedList);
    }
}
