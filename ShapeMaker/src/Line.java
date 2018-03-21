import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


// -------------------------------------------------------------------------

/**
 * This class makes the line object.
 *
 * @author Allen Preville (a892186)
 * @version Feb 26, 2010
 */

public class Line extends Shape {


    // ----------------------------------------------------------

    /**
     * Create a new Line object.
     *
     * @param p1  Start point.
     * @param p2  End point.
     * @param col The color of the shape.
     */
    public Line(Point p1, Point p2, Color col) {
        super(p1, p2, col);

    }

    /**
     * This method draws a line on the given graphics context.
     *
     * @param g This is the graphics context used to draw.
     */
    public void draw(Graphics g) {
        if (point1 != null && point2 != null && color != null) {
            g.setColor(color);
            g.drawLine(point1.x, point1.y, point2.x, point2.y);
        }
    }
}
