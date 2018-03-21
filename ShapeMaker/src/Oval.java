import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


// -------------------------------------------------------------------------

/**
 * This class provides the methods for drawing an oval.
 *
 * @author Allen Preville (a892186)
 * @version Mar 1, 2010
 */

public class Oval extends BoundedShape {

    // ----------------------------------------------------------

    /**
     * Create a new Oval object.
     *
     * @param p1  Start point.
     * @param p2  End point.
     * @param col The color of the shape.
     */
    public Oval(Point p1, Point p2, Color col) {
        super(p1, p2, col);
    }

    /**
     * Draws an oval.
     *
     * @param g This is the graphics context used to draw.
     */
    public void draw(Graphics g) {
        if (point1 != null && point2 != null) {
            int height = Math.abs(point1.y - point2.y);
            int length = Math.abs(point1.x - point2.x);
            g.setColor(color);
            if (isFilled()) {
                if (point1.x >= point2.x && point1.y >= point2.y) //Q1
                {
                    g.fillOval(point1.x - length, point1.y - height,
                            length, height);
                } else if (point1.x < point2.x && point1.y >= point2.y)//Q2
                {
                    g.fillOval(point1.x, point1.y - height,
                            length, height);
                } else if (point1.x > point2.x && point1.y < point2.y)//Q3
                {
                    g.fillOval(point1.x - length, point1.y,
                            length, height);
                } else //Q4
                {
                    g.fillOval(point1.x, point1.y, length, height);
                }
            } else {
                if (point1.x >= point2.x && point1.y >= point2.y) //Q1
                {
                    g.drawOval(point1.x - length, point1.y - height,
                            length, height);
                } else if (point1.x < point2.x && point1.y >= point2.y)//Q2
                {
                    g.drawOval(point1.x, point1.y - height,
                            length, height);
                } else if (point1.x > point2.x && point1.y < point2.y)//Q3
                {
                    g.drawOval(point1.x - length, point1.y,
                            length, height);
                } else //Q4
                {
                    g.drawOval(point1.x, point1.y, length, height);
                }

            }
        }

    }

}
