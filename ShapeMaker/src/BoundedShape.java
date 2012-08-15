import java.awt.Color;
import java.awt.Point;


// -------------------------------------------------------------------------
/**
 *  This is the abstract bounded shape class.  It represents all bounded
 *  shapes.
 *
 *  @author Allen Preville (a892186)
 *  @version Feb 26, 2010
 */

public abstract class BoundedShape extends Shape
{

    // ----------------------------------------------------------
    /**
     * Create a new BoundedShape object.
     * @param p1 Start point.
     * @param p2 End point.
     * @param col The color of the shape.
     */
    public BoundedShape( Point p1, Point p2, Color col )
    {
        super( p1, p2, col );
    }

    /**
     *  Returns a boolean value indicating whether the shape is filled.
     *  @return filled True if the shape is filled.
     */
    public boolean isFilled()
    {
        return isFilled;
    }
}
