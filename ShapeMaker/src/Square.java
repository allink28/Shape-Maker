import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


// -------------------------------------------------------------------------
/**
 *  Provides the method to draw a Square.
 *
 *  @author Allen
 *  @version Mar 2, 2010
 */

public class Square extends Rectangle
{

    // ----------------------------------------------------------
    /**
     * Create a new Square object.
     * @param p1 Start point.
     * @param p2 End point.
     * @param col The color of the shape.
     */
    public Square( Point p1, Point p2, Color col )
    {
        super( p1, p2, col );
    }

    /**
     * This method draws the square.
     * @param g This is the graphics context used to draw.
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
                    g.fillRect( point1.x - length, point1.y - length,
                        length, length );
                }
                else if (point1.x < point2.x && point1.y > point2.y)//Q2
                {
                    g.fillRect( point1.x, point1.y - length,
                        length, length );
                }
                else if (point1.x > point2.x && point1.y < point2.y)//Q3
                {
                    g.fillRect( point1.x - length, point1.y,
                        length, length );
                }
                else //Q4
                {
                    g.fillRect( point1.x, point1.y, length, length );
                }
            }
            else
            {
                if (point1.x >= point2.x && point1.y >= point2.y) //Q1
                {
                    g.drawRect( point1.x - length, point1.y - length,
                        length, length );
                }
                else if (point1.x < point2.x && point1.y > point2.y)//Q2
                {
                    g.drawRect( point1.x, point1.y - length,
                        length, length );
                }
                else if (point1.x > point2.x && point1.y < point2.y)//Q3
                {
                    g.drawRect( point1.x - length, point1.y,
                        length, length );
                }
                else //Q4
                {
                    g.drawRect( point1.x, point1.y, length, length );
                }
            }
        }
    }


}
