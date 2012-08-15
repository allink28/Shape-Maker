import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


// -------------------------------------------------------------------------
/**
 *  This class provides the method for drawing a Circle.
 *
 *  @author Allen Preville (a892186)
 *  @version Mar 2, 2010
 */

public class Circle extends Oval
{

    // ----------------------------------------------------------
    /**
     * Create a new Circle object.
     * @param p1 Start point.
     * @param p2 End point.
     * @param col The color of the shape.
     */
    public Circle( Point p1, Point p2, Color col )
    {
        super( p1, p2, col );
    }

    /**
     * This method draws a circle
     *@param g The graphics context used to draw.
     */
    public void draw( Graphics g )
    {
        if ( point1 != null && point2 != null)
        {
            int length;
            g.setColor( color );
            if (Math.abs( point1.x - point2.x ) <
                Math.abs( point1.y - point2.y ))
            {
                length = Math.abs( point1.x - point2.x );
            }
            else
            {
                length = Math.abs( point1.y - point2.y );
            }

            if ( isFilled() )
            {
                if (point1.x >= point2.x && point1.y >= point2.y) //Q1
                {
                    g.fillOval( point1.x - length, point1.y - length,
                        length, length );
                }
                else if (point1.x < point2.x && point1.y > point2.y)//Q2
                {
                    g.fillOval( point1.x, point1.y - length,
                        length, length );
                }
                else if (point1.x > point2.x && point1.y < point2.y)//Q3
                {
                    g.fillOval( point1.x - length, point1.y,
                        length, length );
                }
                else //Q4
                {
                    g.fillOval( point1.x, point1.y, length, length );
                }
            }
            else
            {
                if (point1.x >= point2.x && point1.y >= point2.y) //Q1
                {
                    g.drawOval( point1.x - length, point1.y - length,
                        length, length );
                }
                else if (point1.x < point2.x && point1.y > point2.y)//Q2
                {
                    g.drawOval( point1.x, point1.y - length,
                        length, length );
                }
                else if (point1.x > point2.x && point1.y < point2.y)//Q3
                {
                    g.drawOval( point1.x - length, point1.y,
                        length, length );
                }
                else //Q4
                {
                    g.drawOval( point1.x, point1.y, length, length);
                }
            }
        }
    }
}
