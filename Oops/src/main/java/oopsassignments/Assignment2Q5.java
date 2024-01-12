package oopsassignments;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

interface Drawable {
    String draw();
}

class Rectangle5 implements Drawable {
    @Override
    public String draw() {
        return "Rectangle";
    }
}

class Line5 implements Drawable {
    @Override
    public String draw() {
        return "Line";
    }
}

class Cube5 implements Drawable {
    @Override
    public String draw() {
        return "Cube";
    }





}
public class Assignment2Q5 {

    private static final Logger logger = Logger.getLogger(Assignment2Q5.class.getName());

    
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
    
    public static String drawAll(List<Drawable> drawables) {
        StringBuilder result = new StringBuilder();
        for (Drawable drawable : drawables) {
            if (drawable != null) {
                result.append(drawable.draw()).append("\n");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Drawable l = new Line5();
        Drawable r = new Rectangle5();
        Drawable c = new Cube5();

        logger.info(l.draw());
        logger.info(r.draw());
        logger.info(c.draw());

        // Additional method usage
        List<Drawable> drawableList = new ArrayList<>();
        drawableList.add(l);
        drawableList.add(r);
        drawableList.add(c);

        logger.info(drawAll(drawableList));
    }
}
