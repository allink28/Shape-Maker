import java.awt.Color;
import java.awt.Point;
import javax.swing.JComboBox;
import student.GUITestCase;


// -------------------------------------------------------------------------
/**
 *  Test methods for the Line class.
 *
 *  @author Allen Preville (a892186)
 *  @version Mar 5, 2010
 */

public class LineTest
    extends GUITestCase
{

    // ----------------------------------------------------------
    /**
     * Test method for {@link Line#draw(java.awt.Graphics)}.
     */
    public void testDraw()
    {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        JComboBox shapeChooser = getComponent(JComboBox.class, "shapeChoice");
        click(shapeChooser);
        selectItem(shapeChooser, "Line");

        mousePress(panel, 250, 250);
        mouseMove(panel, 200, 200);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 300, 200);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 200, 300);
        mouseRelease();

        mousePress(panel, 250, 250);
        mouseMove(panel, 300, 300);
        mouseRelease();
    }


    /**
     * Test method for {@link Line#Line(java.awt.Point, java.awt.Point,
     *  java.awt.Color)}.
     */
    public void testLine()
    {
        Line line = new Line(new Point(0, 0), new Point(1, 1), Color.green);
        assertEquals( Color.green, line.getColor());
        assertEquals( new Point(0, 0), line.getPoint1());
        assertEquals( new Point(1, 1), line.getPoint2());


    }

}
