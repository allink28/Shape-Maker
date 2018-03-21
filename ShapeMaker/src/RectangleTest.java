import java.awt.Color;
import java.awt.Point;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import student.GUITestCase;


// -------------------------------------------------------------------------

/**
 * Test methods for the Rectangle class.
 *
 * @author Allen Preville (a892186)
 * @version Mar 5, 2010
 */

public class RectangleTest
        extends GUITestCase {

    // ----------------------------------------------------------

    /**
     * Test method for {@link Oval#draw(java.awt.Graphics)}.
     */
    public void testDraw() {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        JComboBox shapeChooser = getComponent(JComboBox.class, "shapeChoice");
        click(shapeChooser);
        selectItem(shapeChooser, "Rectangle");

        mousePress(panel, 250, 250);
        mouseMove(panel, 220, 200);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 320, 200);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 220, 300);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 320, 300);
        mouseRelease();

        JCheckBox filled = getComponent(JCheckBox.class, "filled");
        click(filled);
        mousePress(panel, 250, 250);
        mouseMove(panel, 220, 200);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 320, 200);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 220, 300);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 320, 300);
        mouseRelease();
    }


    /**
     * Test method for {@link Rectangle#Rectangle(java.awt.Point,
     * java.awt.Point, java.awt.Color)}.
     */
    public void testRectangle() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(1, 1),
                Color.green);
        assertEquals(Color.green, rectangle.getColor());
        assertEquals(new Point(0, 0), rectangle.getPoint1());
        assertEquals(new Point(1, 1), rectangle.getPoint2());
    }

}
