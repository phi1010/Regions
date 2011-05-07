
/**
 *
 * @author Phillip
 */
public class CommandInterpreter
{
    /**
     * Gibt Permissions.Admin für die Everywhere-Zone
     */
    private final String Command_Admin = "regionsadmin";
    private final String Command = "regions";
    private final String Command_Zone = "z";
    private final String Command_Zone_Add = "+";
    private final String Command_Zone_Edit = "#";
    private final String Command_Zone_Remove = "-";
    private final String Command_Zone_List = "?";
    private final String Command_Zone_Floor = "f";
    private final String Command_Zone_Ceiling = "c";
    private final String Command_Permission = "p";
    private final String Command_Permission_Allow = "+";
    private final String Command_Permission_Inherit = "#";
    private final String Command_Permission_Deny = "-";
    private final String Command_Seperator = ",";
    private final String Help = "Usage: /regions [z|p]\nz: Editing Zones\np: Editing Permissions";
    private final String Help_Zone = "Usage: /regions z [+|#|-|?|t|b]\n+: Create Zone\n#: Edit Zone\n-: Remove Zone\n?: List Zones\nf: Define Floor\nc: Define Ceiling";
}
