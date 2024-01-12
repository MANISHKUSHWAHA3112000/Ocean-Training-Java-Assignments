package Collection_Framwork_Assignment;



import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Test;

class Assignment3Q8bTest {

    @Test
    void testFailFast() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        CopyOnWriteArrayList<Integer> result = Assignment3Q8b.failFast(list);

        // Check that the result is the same as the original list
        assertEquals(list, result);
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
