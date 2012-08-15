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

public class SquareTest
    extends GUITestCase
{

    // ----------------------------------------------------------
    /**
     * Test method for {@link Square#draw(java.awt.Graphics)}.
     */
    public void testDraw()
    {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        JComboBox shapeChooser = getComponent(JComboBox.class, "shapeChoice");
        click(shapeChooser);
        selectItem(shapeChooser, "Square");

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
     * Test method for {@link Square#Square(java.awt.Point, java.awt.Point,
     *  java.awt.Color)}.
     */
    public void testSquare()
    {
        Square square = new Square(new Point(0, 0), new Point(1, 1),
            Color.green);
        assertEquals( Color.green, square.getColor());
        assertEquals( new Point(0, 0), square.getPoint1());
        assertEquals( new Point(1, 1), square.getPoint2());
    }

}
