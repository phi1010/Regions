/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phillip
 */
public class Permission
{
    public Permission(String player, PermissionType permission, boolean allowed)
    {
        _Player = player;
        _Permission = permission;
        _Allowed = allowed;
    }

    /**
     * Der Name des Spielers, für den diese Einstellung gilt.
     * Bei "null": Gilt für alle Spieler, aber individuelle Einstellungen haben Vorrang.
     */
    String _Player;
    /**
     * Die Art des Einstellung
     */
    PermissionType _Permission;
    /**
     * Gibt an, ob die Einstellung ein Verbot oder ein Recht ist
     */
    boolean _Allowed;
    /**
     * Gibt die Region an, in der diese Einstellung gilt.
     */
    Region _Region;

    public String GetPlayer()
    {
        return _Player;
    }
    public PermissionType GetPermission()
    {
        return _Permission;
    }
    public boolean GetAllowed()
    {
        return _Allowed;
    }
    public Region GetRegion()
    {
        return _Region;
    }
}
