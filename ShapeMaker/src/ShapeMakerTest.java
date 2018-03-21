import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import student.GUITestCase;


// -------------------------------------------------------------------------

/**
 * Test class for the main method of .
 *
 * @author Allen Preville (a892186)
 * @version Mar 5, 2010
 */

public class ShapeMakerTest
        extends GUITestCase {

    // ----------------------------------------------------------

    /**
     * Test that ShapeMaker displays a panel.
     */
    public void testShapeMaker() {
        ShapeMaker.main(null);

        ShapeMakerPanel panel = getComponent(ShapeMakerPanel.class);
        assertNotNull(panel);

        JPanel controls = getComponent(JPanel.class, "controls");
        assertNotNull(controls);

        JComboBox shapeChooser = getComponent(JComboBox.class, "shapeChoice");
        assertNotNull(shapeChooser);

        JCheckBox filled = getComponent(JCheckBox.class, "filled");
        assertNotNull(filled);

        JButton undo = getComponent(JButton.class, "undo");
        assertNotNull(undo);
    }

}
