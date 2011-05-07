
import java.util.List;

/**
 *
 * @author Phillip
 */
public class Region
{
    /**
     * Der Name der Region
     */
    String _Name;
    /**
     * Die Oberkante der Region.
     * Blöcke in dieser Höhe sind ebenfalls geschützt.
     */
    int _Top;
    /**
     * Die Unterkante der Region.
     * Blöcke in dieser Höhe sind ebenfalls geschützt.
     */
    int _Bottom;
    List<Point> _Points;

    class Point
    {
        public Point(int x, int y)
        {
            _X = x;
            _Y = y;
        }

        int _X, _Y;

        public int GetX()
        {
            return _X;
        }

        public int GetY()
        {
            return _Y;
        }

    }

}
