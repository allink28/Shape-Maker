import java.awt.Color;
import java.awt.Point;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import student.GUITestCase;


// -------------------------------------------------------------------------
/**
 *  Test methods for the Oval class.
 *
 *  @author Allen Preville (a892186)
 *  @version Mar 5, 2010
 */

public class OvalTest
    extends GUITestCase
{

    // ----------------------------------------------------------
    /**
     * Test method for {@link Oval#draw(java.awt.Graphics)}.
     */
    public void testDraw()
    {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        JComboBox shapeChooser = getComponent(JComboBox.class, "shapeChoice");
        click(shapeChooser);
        selectItem(shapeChooser, "Oval");

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
     * Test method for {@link Oval#Oval(java.awt.Point, java.awt.Point,
     *  java.awt.Color)}.
     */
    public void testOval()
    {
        Oval oval = new Oval(new Point(0, 0), new Point(1, 1), Color.green);
        assertEquals( Color.green, oval.getColor());
        assertEquals( new Point(0, 0), oval.getPoint1());
        assertEquals( new Point(1, 1), oval.getPoint2());
    }

}
