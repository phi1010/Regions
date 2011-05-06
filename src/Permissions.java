
/**
 *
 * @author Phillip
 */
public enum Permissions
{
    /**
     * Kann alle Rechte vergeben.
     * (Kann Permissions.Admin und Permissions.Mod vergeben.)
     * Hat Vorrecht gegenüber Admin-Recht einer Unterzone.
     */
    Admin,
    /**
     * Kann Bearbeitungsrechte vergeben.
     * (Kann Permissions.Admin und Permissions.Mod NICHT vergeben.)
     * Hat Vorrecht gegenüber Mod-Recht einer Unterzone.
     */
    Mod,
    /**
     * Kann die Welt bearbeiten.
     */
    Edit,
    /**
     * Kann Unterzonen erstellen und bearbeiten.
     * Erhält Permissions.Admin für die erstellten Unterzonen.
     */
    Zone,
    /**
     * Kann die Eigenschaften einer Zone verändern.
     */
    Change,
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

    public String getString(Permissions permission)
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

//    public String getPermission(String permission)
//    {
//        switch (permission)
//        {
//            case Admin:
//                return "Admin";
//            case Mod:
//                return "Mod";
//            case Edit:
//                return "Edit";
//            case Zone:
//                return "Zone";
//            case Change:
//                return "Change";
//            case Inventory:
//                return "Inventory";
//            case Enter:
//                return "Enter";
//            case Item:
//                return "Item";
//            default:
//                return null;
//        }
//    }

}
