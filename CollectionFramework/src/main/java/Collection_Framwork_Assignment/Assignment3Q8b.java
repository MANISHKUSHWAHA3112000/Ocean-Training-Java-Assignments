package Collection_Framwork_Assignment;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment3Q8b {

    @SuppressWarnings("unused")
	public static CopyOnWriteArrayList<Integer> failFast(CopyOnWriteArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            list.add(6);
        }
        return list;
    }

    @Test
    public void testFailFast() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        CopyOnWriteArrayList<Integer> result = failFast(list);

        // Validate the result, it should contain the added element
        assertEquals(6, result.get(result.size() - 1));
    }
    @Test
    void testFailFastWithEmptyList() {
        CopyOnWriteArrayList<Integer> emptyList = new CopyOnWriteArrayList<>();

        // Calling failFast on an empty list should not throw an exception
        CopyOnWriteArrayList<Integer> result = Assignment3Q8b.failFast(emptyList);

        // The result should still be an empty list
        assertEquals(emptyList, result);
    }
}
