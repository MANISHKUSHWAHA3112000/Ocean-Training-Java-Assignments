package Collection_Framwork_Assignment;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Person {
    private String name;
    private int height;
    private double weight;

    public Person(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}

class HeightComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getWeight() != p2.getWeight()) {
            // If weights are different, compare based on weights directly
            return Double.compare(p1.getWeight(), p2.getWeight());
        } else {
            // If weights are equal, compare based on heights
            return Integer.compare(p1.getHeight(), p2.getHeight());
        }
    }
}

public class Assignment3Q1 {

    // Logger for logging messages
    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Assignment3Q1.class.getName());

    @Test
    void testPersonSorting() {
        TreeSet<Person> treeSet = new TreeSet<>(new HeightComparator());
        treeSet.add(new Person("Kamlesh", 5, 55));
        treeSet.add(new Person("Manish", 6, 65));
        treeSet.add(new Person("Veerendra", 5, 65));
        treeSet.add(new Person("Krishna", 6, 70));
        treeSet.add(new Person("Aryan", 5, 80));

        Iterator<Person> iterator = treeSet.iterator();
        assertTrue(iterator.hasNext());
        Person prevPerson = iterator.next();

        while (iterator.hasNext()) {
            Person currentPerson = iterator.next();

            if (prevPerson.getWeight() == currentPerson.getWeight()) {
                // If weights are equal, heights should be in ascending order
                assertTrue(prevPerson.getHeight() <= currentPerson.getHeight());
            } else {
                // If weights are different, weights should be in ascending order
                assertTrue(prevPerson.getWeight() <= currentPerson.getWeight());
            }

            prevPerson = currentPerson;
        }
    }
    @Test
    void testPersonSortingWithSameWeightsAndHeights() {
        TreeSet<Person> treeSet = new TreeSet<>(new HeightComparator());
        treeSet.add(new Person("John", 5, 60));
        treeSet.add(new Person("Alice", 5, 60));
        treeSet.add(new Person("Bob", 5, 60));

        Iterator<Person> iterator = treeSet.iterator();
        assertTrue(iterator.hasNext());
        Person prevPerson = iterator.next();

        while (iterator.hasNext()) {
            Person currentPerson = iterator.next();
            assertEquals(0, Double.compare(prevPerson.getWeight(), currentPerson.getWeight()));
            assertEquals(0, Integer.compare(prevPerson.getHeight(), currentPerson.getHeight()));
            prevPerson = currentPerson;
        }
    }

    @Test
    void testPersonSortingWithDifferentWeightsAndSameHeights() {
        TreeSet<Person> treeSet = new TreeSet<>(new HeightComparator());
        treeSet.add(new Person("Sara", 5, 65));
        treeSet.add(new Person("Tom", 5, 60));
        treeSet.add(new Person("Emily", 5, 70));

        Iterator<Person> iterator = treeSet.iterator();
        assertTrue(iterator.hasNext());
        Person prevPerson = iterator.next();

        while (iterator.hasNext()) {
            Person currentPerson = iterator.next();
            assertTrue(prevPerson.getHeight() == currentPerson.getHeight());
            assertTrue(prevPerson.getWeight() <= currentPerson.getWeight());
            prevPerson = currentPerson;
        }
    }

    @Test
    void testPersonSortingWithDifferentWeightsAndDifferentHeights() {
        TreeSet<Person> treeSet = new TreeSet<>(new HeightComparator());
        treeSet.add(new Person("Anna", 4, 55));
        treeSet.add(new Person("Michael", 6, 70));
        treeSet.add(new Person("Sophie", 5, 65));
        treeSet.add(new Person("David", 4, 60));
        treeSet.add(new Person("Emma", 6, 70));

        Iterator<Person> iterator = treeSet.iterator();
        assertTrue(iterator.hasNext());
        Person prevPerson = iterator.next();

        while (iterator.hasNext()) {
            Person currentPerson = iterator.next();
            assertTrue(prevPerson.getWeight() <= currentPerson.getWeight());
            if (prevPerson.getWeight() == currentPerson.getWeight()) {
                assertTrue(prevPerson.getHeight() <= currentPerson.getHeight());
            }
            prevPerson = currentPerson;
        }
    }

    @Test
    void testPersonSortingWithEmptySet() {
        TreeSet<Person> treeSet = new TreeSet<>(new HeightComparator());

        Iterator<Person> iterator = treeSet.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testPersonSortingWithSinglePerson() {
        TreeSet<Person> treeSet = new TreeSet<>(new HeightComparator());
        treeSet.add(new Person("Peter", 5, 70));

        Iterator<Person> iterator = treeSet.iterator();
        assertTrue(iterator.hasNext());
        Person singlePerson = iterator.next();
        assertFalse(iterator.hasNext());
        assertEquals("Peter", singlePerson.getName());
        assertEquals(5, singlePerson.getHeight());
        assertEquals(70, singlePerson.getWeight());
    }


    public static void main(String[] args) {

        // Logger for logging messages
        Logger mainLogger = Logger.getLogger(Assignment3Q1.class.getName());

        TreeSet<Person> tree = new TreeSet<>(new HeightComparator());
        tree.add(new Person("Kamlesh", 5, 55));
        tree.add(new Person("Manish", 6, 65));
        tree.add(new Person("Veerendra", 5, 65));
        tree.add(new Person("Krishna", 6, 70));
        tree.add(new Person("Aryan", 5, 80));

        mainLogger.log(Level.INFO, "Sort the person According to their weights," + "\n" + "if someone weight is "
                + "same then Sort based upon their heights");

        for (Person p : tree) {
            mainLogger.log(Level.INFO, p.getName() + " " + p.getHeight() + " " + p.getWeight());
        }
    }
}
