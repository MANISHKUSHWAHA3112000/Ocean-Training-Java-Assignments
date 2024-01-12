package Collection_Framwork_Assignment;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment3Q2 {

    public LinkedHashSet<String> ordered(LinkedHashSet<String> linkedHashSet) {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        result.addAll(linkedHashSet);
        return result;
    }

    public HashSet<String> unordered(HashSet<String> hashSet) {
        HashSet<String> res = new HashSet<>(hashSet);
        return res;
    }

    @Test
    void testOrdered() {
        Assignment3Q2 A = new Assignment3Q2();

        LinkedHashSet<String> lh = new LinkedHashSet<>();
        lh.add("A");
        lh.add("B");
        lh.add("C");
        lh.add("D");
        lh.add("E");

        LinkedHashSet<String> ans = A.ordered(lh);

        // Test that ordered set is the same as the input
        assertEquals(lh, ans);
    }

    @Test
    void testUnordered() {
        Assignment3Q2 A = new Assignment3Q2();

        HashSet<String> hash = new HashSet<>();
        hash.add("manish");
        hash.add("gourav");
        hash.add("rahul");
        hash.add("aryan");
        hash.add("Ritik");

        HashSet<String> ans1 = A.unordered(hash);

        // Test that unordered set is the same as the input
        assertEquals(hash, ans1);
    }

    public static void main(String[] args) {
        // The main method can be left as is, or you can remove it if it's not needed for testing.
    }
}
