import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


// -------------------------------------------------------------------------
/**
 *  This class provides the methods for drawing a rectangle.
 *
 *  @author Allen Preville (a892186)
 *  @version Feb 28, 2010
 */

public class Rectangle extends BoundedShape
{

    // ----------------------------------------------------------
    /**
     * Create a new Rectangle object.
     * @param p1 Start point.
     * @param p2 End point.
     * @param col The color of the shape.
     */
    public Rectangle( Point p1, Point p2, Color col )
    {
        super( p1, p2, col );
    }

    /**
     *Draws a rectangle.
     *@param g This is the graphics context used to draw.
     */
    public void draw( Graphics g )
    {

        if ( point1 != null && point2 != null)
        {
            int height;
            int length;
            length = Math.abs( point1.x - point2.x );
            height = Math.abs( point1.y - point2.y );
            g.setColor( color );
            if ( isFilled() )
            {
                if (point1.x >= point2.x && point1.y >= point2.y) //Q1
                {
                    g.fillRect( point1.x - length, point1.y - height,
                        length, height );
                }
                else if (point1.x < point2.x && point1.y >= point2.y)//Q2
                {
                    g.fillRect( point1.x, point1.y - height,
                        length, height );
                }
                else if (point1.x > point2.x && point1.y < point2.y)//Q3
                {
                    g.fillRect( point1.x - length, point1.y,
                        length, height );
                }
                else //Q4
                {
                    g.fillRect( point1.x, point1.y, length, height);
                }
            }
            else
            {
                if (point1.x >= point2.x && point1.y >= point2.y) //Q1
                {
                    g.drawRect( point1.x - length, point1.y - height,
                        length, height );
                }
                else if (point1.x < point2.x && point1.y >= point2.y)//Q2
                {
                    g.drawRect( point1.x, point1.y - height,
                        length, height );
                }
                else if (point1.x > point2.x && point1.y < point2.y)//Q3
                {
                    g.drawRect( point1.x - length, point1.y,
                        length, height );
                }
                else //Q4
                {
                    g.drawRect( point1.x, point1.y, length, height);
                }
            }
        }

    }

}
