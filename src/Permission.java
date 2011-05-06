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
    public Permission(String player, Permissions permission, boolean allowed)
    {
        _Player = player;
        _Permission = permission;
        _Allowed = allowed;
    }

    String _Player;
    Permissions _Permission;
    boolean _Allowed;

    public String GetPlayer()
    {
        return _Player;
    }
    public Permissions GetPermission()
    {
        return _Permission;
    }
    public boolean GetAllowed()
    {
        return _Allowed;
    }
}
