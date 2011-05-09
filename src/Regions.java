
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 * @author Phillip
 */
public class Regions extends Plugin
{
    // <editor-fold defaultstate="collapsed" desc="Repytext">
    static final String Reply_NotAllowed_Command = "You are not allowed to use this command.";
    static final String Reply_NotAllowed_Delegate = "You are not allowed to delegate this permission.";
    static final String Reply_NotAllowed_Zoning = "You are not allowed to create, edit and remove zones here.";
    static final String Reply_NotAllowed_Edit = "You are not allowed to edit the blocks here.";
    static final String Reply_NotAllowed_Item = "You are not allowed to throw items away here.";
    static final String Reply_NotAllowed_Inventory = "You are not allowed to open chests here.";
    static final String Reply_NotAllowed_Enter = "You are not allowed to enter this zone.";
    static final String Reply_NotAllowed_Stay = "You are not allowed to stay in this zone.\nYou will be teleported to spawn.";
    static final String Reply_Edit_Begin ="You can now edit the Zone %1 with a book.";
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Commandtext">
    /**
     * Gibt Permissions.Admin für die Everywhere-Zone
     */
    private static final String Command_Admin = "/regionsadmin";
    static final String Command = "/regions";
    static final String CommandConsole = "regions";
    static final String Command_Zone = "z";
    static final String Command_Zone_Add = "+";
    static final String Command_Zone_Edit = "#";
    static final String Command_Zone_Remove = "-";
    static final String Command_Zone_List = "?";
    static final String Command_Zone_Floor = "f";
    static final String Command_Zone_Ceiling = "c";
    static final String Command_Permission = "p";
    static final String Command_Permission_Allow = "+";
    static final String Command_Permission_Inherit = "#";
    static final String Command_Permission_Deny = "-";
    static final String Command_Permission_List = "?";
//    private static final String Command_Change = "c";
//    private static final String Command_Change_PvP = "PvP";
//    private static final String Command_Change_TNT = "TNT";
//    private static final String Command_Change_Mobs = "Mobs";
//    private static final String Command_Change_Mobs = "Mobs";
    static final String Command_Seperator = ",";
    static final String Command_All = ".";
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Helptext">
    static final String Help = "Usage: " + Command + " [" + Command_Zone + "|" + Command_Permission + "]" + "\n"
            + "" + Command_Zone + ": Editing Zones" + "\n"
            + "" + Command_Permission + ": Editing Permissions";
    static final String Help_Zone = "Usage: " + Command + " " + Command_Zone + " [" + Command_Zone_Add + "|" + Command_Zone_Edit + "|" + Command_Zone_Remove + "|" + Command_Zone_List + "|" + Command_Zone_Ceiling + "|" + Command_Zone_Floor + "]" + "\n"
            + "" + Command_Zone_Add + ": Create Zone" + "\n"
            + "" + Command_Zone_Edit + ": Edit Zone" + "\n"
            + "" + Command_Zone_Remove + ": Remove Zone" + "\n"
            + "" + Command_Zone_List + ": List Zones" + "\n"
            + "" + Command_Zone_Ceiling + ": Define Ceiling" + "\n"
            + "" + Command_Zone_Floor + ": Define Floor";
    static final String Help_Zone_Add = "Usage: " + Command + " " + Command_Zone + " + <ZONE> <PARENT ZONE>" + "\n"
            + "Use '" + Command_All + "' for Everywhere";
    static final String Help_Zone_Edit = "Usage: " + Command + " " + Command_Zone + " #";
    static final String Help_Zone_Remove = "Usage: " + Command + " " + Command_Zone + " " + Command_Zone_Remove + " <ZONE>" + "\n"
            + "WARNING: This can't be undone!";
    static final String Help_Permission = "Usage: " + Command + " " + Command_Permission + " [" + Command_Permission_Allow + "|" + Command_Permission_Inherit + "|" + Command_Permission_Deny + "|" + Command_Permission_List + "]" + "\n"
            + "" + Command_Permission_Allow + ": Allow" + "\n"
            + "" + Command_Permission_Inherit + ": Inherit Permission" + "\n"
            + "" + Command_Permission_Deny + ": Deny" + "\n"
            + "" + Command_Permission_List + ": List Permissions";
    static final String Help_Permission_Allow = "Usage: " + Command + " " + Command_Permission + " " + Command_Permission_Allow + " <PLAYER> <ZONE> <PERMISSION>" + "\n"
            + "You can seperate multiple players, zones and permissions with '" + Command_Seperator + "'." + "\n"
            + "Use '" + Command_All + "' for Everyone/Everywhere.";
    static final String Help_Permission_Inherit = "Usage: " + Command + " " + Command_Permission + " " + Command_Permission_Inherit + " <PLAYER> <ZONE> <PERMISSION>" + "\n"
            + "You can seperate multiple players, zones and permissions with '" + Command_Seperator + "'." + "\n"
            + "Use '" + Command_All + "' for Everyone/Everywhere.";
    static final String Help_Permission_Deny = "Usage: " + Command + " " + Command_Permission + " " + Command_Permission_Deny + " <PLAYER> <ZONE> <PERMISSION>" + "\n"
            + "You can seperate multiple players, zones and permissions with '" + Command_Seperator + "'." + "\n"
            + "Use '" + Command_All + "' for Everyone/Everywhere.";
    // </editor-fold>
    private Listener _Listener = new Listener(this);
    protected static final Logger _Log = Logger.getLogger("Minecraft");
    private final String Name = "Regions";
    private final String Version = "1.0";
    private List<Region> _Regions;

    public void enable()
    {
        _Log.info(Name + " " + Version + " enabled");
    }

    public void disable()
    {
        _Log.info(Name + " " + Version + " disabled");
    }

    @Override
    public void initialize()
    {
        _Log.info(Name + " " + Version + " initialized");
        etc.getLoader().addListener(PluginLoader.Hook.LOGIN, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.COMMAND, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.SERVERCOMMAND, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.BLOCK_PLACE, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.BLOCK_DESTROYED, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.BLOCK_BROKEN, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.OPEN_INVENTORY, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.PLAYER_MOVE, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.TELEPORT, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.IGNITE, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.FLOW, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.EXPLODE, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.MOB_SPAWN, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.DAMAGE, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.ATTACK, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.LIQUID_DESTROY, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.VEHICLE_COLLISION, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.HEALTH_CHANGE, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.ITEM_PICK_UP, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.ITEM_DROP, _Listener, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.ITEM_USE, _Listener, this, PluginListener.Priority.MEDIUM);
    }

    // <editor-fold defaultstate="collapsed" desc="Parser">
    public boolean parseConsole(String text)
    {
        if (text.equalsIgnoreCase(CommandConsole))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean parseChat(String text, Player player)
    {
        if (text.equalsIgnoreCase(Command))
        {
            if (player.canUseCommand(Command))
            {
            }
            else
            {
                player.notify(Reply_NotAllowed_Command);
            }
            return true;
        }
        else
        {
            return false;
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Check">
    public Region GetRegion(double x, double y, double z)
    {
        try
        {
            int regionCount = _Regions.size();
            Region region = null;
            {
                List<Region> playerRegions = new LinkedList();
                for (int i1 = 0; i1 < regionCount; i1++)
                {
                    Region region1 = _Regions.get(i1);
                    if (region1.IsInside(x, y, z))
                    {
                        for (int i2 = 0; i2 < playerRegions.size(); i2++)
                        {
                            Region region2 = playerRegions.get(i2);
                            if (region2.IsChildOf(region1))//Unterregion lassen, Überregion nicht hinzufügen
                            {
                            }
                            else if (region1.IsChildOf(region2))//Überregion entfernen, Unterregion hinzufügen
                            {
                                playerRegions.remove(i2);
                                playerRegions.add(region1);
                            }
                            else//Nebenregion hinzufügen
                            {
                                playerRegions.add(region1);
                            }
                        }
                    }
                }
                if (playerRegions.size() == 0)
                {
                    region = null;
                }
                else
                {
                    region = playerRegions.remove(0);
                    for (int i1 = 0; i1 < playerRegions.size(); i1++)
                    {
                        Region region1 = playerRegions.get(i1);
                        while (!region1.IsChildOf(region))
                        {
                            region = region._Parent;
                        }
                    }
                }
            }
            return region;
        }
        catch (Throwable t)
        {
            _Log.severe(Name + " " + Version + " produced an exception at GetRegion(Player):\nPlayer=" + player + "\n" + t);
            return null;
        }
    }

    public boolean HasPermission(Player player, PermissionType permissionType)
    {
        try
        {
            return HasPermission(player, permissionType, GetRegion(player));
        }
        catch (Throwable t)
        {
            _Log.severe(Name + " " + Version + " produced an exception at HasPermission(Player,Permissions):\nPlayer=" + player + "\nPermission=" + permissionType + "\n" + t);
            return true;
        }
    }

    public boolean HasPermission(Player player, PermissionType type, Region region)
    {
        try
        {
            if (type == PermissionType.Admin && player.canUseCommand(Command_Admin))
            {
                return true;
            }
            else
            {
                Permission permission0 = null;
                while ((region != null)
                        //Vererbung bei fehlender Festlegung
                        && ((permission0 == null)
                        //ODER bei Vorrecht und aktuellem Verbot (Default-Rechte haben kein Vorrecht)
                        || (PermissionType.Privilege(type) && permission0._Allowed == false)))
                {
                    List<Permission> permissionList = region._Permissions.get(type);
                    Permission permission1 = null;
                    for (int i = 0; i < permissionList.size(); i++)
                    {
                        Permission permission2 = permissionList.get(i);
                        if (permission2._Player.equals(player.getName()))
                        {
                            permission1 = permission2;
                        }
                        else if (permission2._Player == null && permission1 == null)
                        {
                            permission1 = permission2;
                        }
                    }
                    permission0 = permission1;
                    region = region._Parent;
                }
                if (permission0 == null)
                {
                    return PermissionType.Default(type);
                }
                else
                {
                    return permission0._Allowed;
                }
            }
        }
        catch (Throwable t)
        {
            _Log.severe(Name + " " + Version + " produced an exception at HasPermission(Player,Permissions,Region):\nPlayer=" + player + "\nPermissionType=" + type + "\nRegion=" + region + "\n" + t);
            return true;
        }
    }

    public boolean CanDelegate(Player player, PermissionType type, Region region)
    {
        switch (type)
        {
            case Admin:
                return HasPermission(player, PermissionType.Admin, region);
            case Mod:
                return HasPermission(player, PermissionType.Zone, region);
            case Edit:
                return HasPermission(player, PermissionType.Mod, region);
            case Zone:
                return HasPermission(player, PermissionType.Admin, region);
            case Change:
                return HasPermission(player, PermissionType.Mod, region);
            case Inventory:
                return HasPermission(player, PermissionType.Mod, region);
            case Enter:
                return HasPermission(player, PermissionType.Mod, region);
            case Item:
                return HasPermission(player, PermissionType.Mod, region);
            default:
                return false;
        }
    }// </editor-fold>

}
