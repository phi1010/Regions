
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.EnumMap;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Phillip
 */
public class Region
{
    public Region(String name, Region parent)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("name must'n be null");
        }
        if (name.contains(":") || name.contains(".") || name.contains("/") || name.contains("~"))
        {
            throw new IllegalArgumentException("name must'n contain ':', '.', '/', '~'");
        }
        _Name = name;
        _Parent = parent;
        _Points = new ArrayList<Point>();
        _Permissions = new EnumMap<PermissionType, List<Permission>>(PermissionType.class);
        _Permissions.put(PermissionType.Admin, new ArrayList<Permission>());
        _Permissions.put(PermissionType.Zone, new ArrayList<Permission>());
        _Permissions.put(PermissionType.Mod, new ArrayList<Permission>());
        _Permissions.put(PermissionType.Change, new ArrayList<Permission>());
        _Permissions.put(PermissionType.Edit, new ArrayList<Permission>());
        _Permissions.put(PermissionType.Inventory, new ArrayList<Permission>());
        _Permissions.put(PermissionType.Item, new ArrayList<Permission>());
        _Permissions.put(PermissionType.Enter, new ArrayList<Permission>());
    }

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
    Region _Parent;
    EnumMap<PermissionType, List<Permission>> _Permissions;

    public Region GetParent()
    {
        return _Parent;
    }

    public boolean IsInside(double x, double y, double z)
    {
        return PointInPolygon(x, z, _Points)
                && (_Bottom <= y && y <= _Top)
                && ((_Parent == null) ? true : _Parent.IsInside(x, y, z));
    }

    private static boolean PointInPolygon(double x, double y, List<Point> poly)
    {
        if (poly.size() <= 0)
        {
            return false;
        }
        Point p1, p2;
        int size = poly.size();
        boolean inside = false;
        Point oldPoint = poly.get(size - 1);
        for (int i = 0; i < size; i++)
        {
            final Point polyi = poly.get(i);
            if (polyi.GetX() == x && polyi.GetZ() == y)
            {
                return true;
            }
            Point newPoint = new Point(polyi.GetX(), polyi.GetZ());
            if (newPoint.GetX() > oldPoint.GetZ())
            {
                p1 = oldPoint;
                p2 = newPoint;
            }
            else
            {
                p1 = newPoint;
                p2 = oldPoint;
            }
            if ((newPoint.GetX() < x) == (x <= oldPoint.GetX())
                    && (y - p1.GetZ()) * (p2.GetX() - p1.GetX())
                    < (p2.GetZ() - p1.GetZ()) * (x - p1.GetX()))
            {
                inside = !inside;
            }
            oldPoint = newPoint;
        }
        return inside;
    }

    public boolean IsChildOf(Region region)
    {
        if (region == null)
        {
            return true;
        }
        if (region == _Parent)
        {
            return true;
        }
        if (_Parent == null)
        {
            return false;
        }
        return _Parent.IsChildOf(region);
    }

}
