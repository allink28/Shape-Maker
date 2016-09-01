import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;


// -------------------------------------------------------------------------
/**
 *  This class holds the primary panel which contains the controls panel
 *  and drawing area.
 *
 *  @author Allen Preville (a892186)
 *  @version Feb 24, 2010
 */

public class ShapeMakerPanel extends JPanel
{
    private JComboBox shapeChoice;
    private JPanel currentColor;
    private JCheckBox filled;
    private JButton undo;
    private JButton clear;
    private JPanel controls;
    private JPanel drawingArea;

    private Point point1 = null;
    private Point point2 = null;
    private Color color = Color.black;
    private Shape shape = null;
    private Object obj;
    private boolean checkbox = false;
    private List<Shape> list = new ArrayList<Shape>();

    /**
     * Constructor for ShapeMakerPanel
     */
    public ShapeMakerPanel()
    {
        shapeChoice = new JComboBox();
        shapeChoice.setName( "shapeChoice" );
        shapeChoice.insertItemAt("Line", 0);
        shapeChoice.insertItemAt("Rectangle", 1);
        shapeChoice.insertItemAt("Square", 2);
        shapeChoice.insertItemAt("Oval", 3);
        shapeChoice.insertItemAt("Circle", 4);

        ShapeListener listener1 = new ShapeListener();
        ControlListener listener2 = new ControlListener();

        currentColor = new JPanel();
        currentColor.setName( "currentColor" );
        currentColor.setPreferredSize(new Dimension(35, 25));
        currentColor.setBackground(Color.black);
        filled = new JCheckBox("Filled");
        filled.setName( "filled" );
        undo = new JButton( "Undo" );
        undo.setName( "undo" );
        clear = new JButton( "Clear" );
        clear.setName( "clear" );

        setPreferredSize(new Dimension(400, 450));

        controls = new JPanel();
        controls.setName( "controls" );
        controls.add( shapeChoice );
        controls.add( currentColor );
        controls.add( filled );
        controls.add( undo );
        controls.add( clear );
        controls.setPreferredSize(new Dimension(400, 50));

        drawingArea = new JPanel();
        drawingArea.setName( "drawingArea" );
        drawingArea.setBackground(Color.white);
        drawingArea.setPreferredSize(new Dimension(400, 400));
        shape = new Line( null, null, color); 

        add( controls );
        addMouseListener(listener1);
        addMouseMotionListener(listener1);
        currentColor.addMouseListener(listener1);
        undo.addMouseListener( listener1 );
        clear.addMouseListener( listener1 );
        filled.addItemListener(listener2);
        shapeChoice.addItemListener( listener2 );
    }

    /**
     * Draws all the shapes displayed.
     * @param g The graphic context.
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (!list.isEmpty())
        {
            for ( Shape s : list )
            {
                s.draw(g);
            }
        }
        if (point1 != null && obj != null)
        {
            shape.draw(g);
        }
    }

    /**
     * Returns the list of shapes to be drawn and maintained on the panel.
     * @return list The list of shapes.
     */
    public List<Shape> getShapes()
    {
        return list;
    }
    /**
     * This method returns the starting point of the current shape.
     * @return point1 The starting point of the shape.
     */
    public Point getStartPoint()
    {
        return shape.getPoint1();
    }
    /**
     * This method returns the ending point of the current shape.
     * @return point2 The ending point of the shape.
     */
    public Point getEndPoint()
    {
        return shape.getPoint2();
    }
    /**
     * This method gets the status of the checkbox.
     * @return checkbox The status of the checkbox. True if checked.
     */
    public boolean getFilledStatus()
    {
        return checkbox;
    }
    // ----------------------------------------------------------
    /**
     * Returns color selected.
     * @return Returns the color of the shapes.
     */
    public Color getColor()
    {
        return shape.getColor();
    }

    /**
     * Represents the listener for Mouse events.
     */
    private class ShapeListener extends MouseAdapter
    {
        // ----------------------------------------------------------
        /**
         * Captures the initial position at which the mouse button is
         * pressed.
         * @param event The event to be handled
         */
        public void mousePressed(MouseEvent event)
        {
            if ( event.getSource() != controls && obj != null)
            {
                if ( obj.toString().equals( "Line" ))
                {
                    shape = new Line( point1, point2, color);
                }
                else if ( obj.toString().equals( "Rectangle" ))
                {
                    shape = new Rectangle( point1, point2, color);
                }
                else if ( obj.toString().equals( "Oval" ))
                {
                    shape = new Oval( point1, point2, color);
                }
                else if ( obj.toString().equals( "Square" ))
                {
                    shape = new Square( point1, point2, color);
                }
                else if ( obj.toString().equals( "Circle" ))
                {
                    shape = new Circle( point1, point2, color);
                }

                if (event.getPoint().y > 25)
                {
                    shape.setFilled( checkbox );
                    point1 = event.getPoint();
                    shape.setPoint1( point1 );
                }
            }
        }

     // ----------------------------------------------------------
        /**
         * Gets the current position of the mouse as it is dragged and
         * redraws the shape to create a rubberband effect.
         * @param event The event to be handled
         */
        public void mouseDragged(MouseEvent event)
        {
            if ( event.getSource() != controls && obj != null
                && point1 != null)
            {

                point2 = event.getPoint();
                shape.setPoint2( point2 );
                repaint();
            }
        }

        /**
         * Adds current shape to list when the mouse is released.
         * @param event The event to be handled
         */
        public void mouseReleased(MouseEvent event)
        {
            if (point1 != null)
            {
                list.add( shape );
                point1 = null;
                point2 = null;
                repaint();
            }
        }

        /**
         * Activates the component clicked.
         * @param event The mouse click event to be handled.
         */
        public void mouseClicked(MouseEvent event)
        {
            if ( event.getSource() == currentColor)
            {
                color = JColorChooser.showDialog( shapeChoice,
                    "Color Chooser", Color.black );
                currentColor.setBackground( color );
            }
            else if ( event.getSource() == clear )
            {
                list.clear();
                repaint();
            }
            else if ( list.size() > 0)
            {
                list.remove( list.size() - 1 );
                repaint();
            }
        }
    }

    /**
     * Represents the listener for all controls.
     */
    private class ControlListener implements ItemListener
    {
        /**
         * Activates when the combo box or check box state changes.
         * @param e The event to be handled.
         */
        public void itemStateChanged( ItemEvent e )
        {
            if ( e.getSource() == shapeChoice)
            {
                obj = shapeChoice.getSelectedItem();
            }
            else
            {
                checkbox = !checkbox;
            }
        }
    }
}