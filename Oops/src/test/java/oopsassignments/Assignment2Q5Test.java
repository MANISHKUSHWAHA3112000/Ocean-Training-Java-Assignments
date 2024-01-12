package oopsassignments;
import org.junit.Test;



import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Assignment2Q5Test {

    @Test
    public void testDrawAllWithEmptyList() {
        List<Drawable> drawableList = new ArrayList<>();
        assertEquals("", Assignment2Q5.drawAll(drawableList));
    }

    @Test
    public void testDrawAllWithSingleElement() {
        Drawable r = new Rectangle5();
        List<Drawable> drawableList = new ArrayList<>();
        drawableList.add(r);

        assertEquals("Rectangle", Assignment2Q5.drawAll(drawableList));
    }

    @Test
    public void testDrawAllWithMultipleElements() {
        Drawable l = new Line5();
        Drawable r = new Rectangle5();
        Drawable c = new Cube5();

        List<Drawable> drawableList = new ArrayList<>();
        drawableList.add(l);
        drawableList.add(r);
        drawableList.add(c);

        String expectedOutput = "Line\nRectangle\nCube";
        assertEquals(expectedOutput, Assignment2Q5.drawAll(drawableList));
    }

    @Test
    public void testDrawAllWithNullElement() {
        Drawable l = new Line5();
        List<Drawable> drawableList = new ArrayList<>();
        drawableList.add(l);
        drawableList.add(null);

        // Ensure that null elements are skipped
        assertEquals("Line", Assignment2Q5.drawAll(drawableList));
    }
}
