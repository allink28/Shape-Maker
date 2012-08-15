import javax.swing.JFrame;

//-------------------------------------------------------------------------
/**
 * The main driver for the Shape Maker project.
 *
 * @author Allen Preville (a892186)
 * @version Feb 24, 2010
 */
public class ShapeMaker
{
    // ----------------------------------------------------------
    /**
     * Sets up the primary frame and panel.
     *
     * @param args unused command-line arguments.
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("ShapeMaker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ShapeMakerPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
