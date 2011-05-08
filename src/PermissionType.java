
/**
 *
 * @author Phillip
 */
public enum PermissionType
{
    /**
     * Kann PermissionType.Admin und PermissionType.Zone vergeben.
     * Hat Vorrecht gegenüber PermissionType.Admin einer Unterzone.
     */
    Admin,
    /**
     * Kann Unterzonen erstellen und bearbeiten. Kann PermissionType.Mod vergeben.
     * Hat Vorrecht gegenüber PermissionType.Zone einer Unterzone.
     */
    Zone,
    /**
     * Kann Bearbeitungsrechte vergeben.
     * (Kann PermissionType.Admin, PermissionType.Mod und PermissionType.Zone NICHT vergeben.)
     */
    Mod,
    /**
     * Kann die Eigenschaften einer Zone verändern.
     */
    Change,
    /**
     * Kann die Welt bearbeiten.
     */
    Edit,
    /**
     * Kann Inventarboxen in einer Zone öffnen.
     */
    Inventory,
    /**
     * Kann die Zone betreten und sich darin aufhalten.
     */
    Enter,
    /**
     * Kann Items aufsammeln und werfen.
     */
    Item;

    /**
     * Wandelt einen PermissionType-Member in einen String um.
     * @param permission
     * @return
     */
    public static String GetString(PermissionType permission)
    {
        switch (permission)
        {
            case Admin:
                return "Admin";
            case Mod:
                return "Mod";
            case Edit:
                return "Edit";
            case Zone:
                return "Zone";
            case Change:
                return "Change";
            case Inventory:
                return "Inventory";
            case Enter:
                return "Enter";
            case Item:
                return "Item";
            default:
                return null;
        }
    }

    /**
     * Wandelt einen String in einen PermissionType-Member um.
     * @param permission
     * @return
     * @throws IllegalArgumentException
     */
    public static PermissionType GetPermission(String permission)
            throws IllegalArgumentException
    {
        if (permission.equalsIgnoreCase("Admin"))
        {
            return Admin;
        }
        if (permission.equalsIgnoreCase("Mod"))
        {
            return Mod;
        }
        if (permission.equalsIgnoreCase("Edit"))
        {
            return Edit;
        }
        if (permission.equalsIgnoreCase("Zone"))
        {
            return Zone;
        }
        if (permission.equalsIgnoreCase("Change"))
        {
            return Change;
        }
        if (permission.equalsIgnoreCase("Inventory"))
        {
            return Inventory;
        }
        if (permission.equalsIgnoreCase("Enter"))
        {
            return Enter;
        }
        if (permission.equalsIgnoreCase("Item"))
        {
            return Item;
        }
        throw new IllegalArgumentException("'" + permission + "' is an invalid String.");
    }

    public static boolean Default(PermissionType type)
    {
        return type != PermissionType.Admin && type != PermissionType.Zone && type != PermissionType.Mod;
    }

    public static boolean Privilege(PermissionType type)
    {
        return type == PermissionType.Admin || type == PermissionType.Zone;
    }

}
