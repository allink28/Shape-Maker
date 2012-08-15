import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import student.GUITestCase;


// -------------------------------------------------------------------------
/**
 *  Test cases for the ShapeMakerPanel.
 *
 *  @author Allen Preville (a892186)
 *  @version Mar 4, 2010
 */
public class ShapeMakerPanelTest
    extends GUITestCase
{

    // ----------------------------------------------------------
    /**
     * Exercises the ShapeMakerPanel.
     */
    @SuppressWarnings("unchecked")
    public void testShapeMakerPanel()
    {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        JButton undo = getComponent(JButton.class, "undo");
        click(undo);

        int width;
        int height;
        width = panel.getWidth();
        height = panel.getHeight();

        JComboBox shapeChooser = getComponent(JComboBox.class, "shapeChoice");
        click(shapeChooser);
        selectItem(shapeChooser, "Rectangle");
        JCheckBox filled = getComponent(JCheckBox.class, "filled");
        click(filled);
        mousePress(panel, width * 3 / 4, height * 3 / 4);
        mouseMove(panel, width * 1 / 4, height * 1 / 4);
        mouseRelease();

        assertEquals(true, panel.getFilledStatus());
        assertEquals(width  * 3 / 4, (int)panel.getStartPoint().getX());
        assertEquals(height * 3 / 4, (int)panel.getStartPoint().getY());
        assertEquals(width  * 1 / 4, (int)panel.getEndPoint().getX());
        assertEquals(height * 1 / 4, (int)panel.getEndPoint().getY());

        click(filled);
        click(shapeChooser);
        selectItem(shapeChooser, "Square");
        mousePress(panel, width * 9 / 10, height * 9 / 10);
        mouseMove(panel, width * 1 / 2, height * 1 / 2);

        List list = new ArrayList<Shape>();
        list = panel.getShapes();
        click(undo);
        assertEquals( 1, list.size());
        assertEquals(false, panel.getFilledStatus());

        JButton clear = getComponent(JButton.class, "clear");
        click(clear);
        assertEquals( 0, list.size());


        JPanel currentColor = getComponent(JPanel.class, "currentColor");
        click(currentColor);
        JColorChooser dialog = getComponent(JColorChooser.class);
        dialog.setColor( Color.blue );
        click(getComponent(JButton.class, where.textIs( "OK" )));

        mousePress(panel, width * 3 / 4, height * 3 / 4);
        mouseMove(panel, width * 1 / 4, height * 1 / 4);
        mouseRelease();

        assertEquals( Color.blue, panel.getColor());
    }

}









