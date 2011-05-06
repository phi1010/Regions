
/**
 *
 * @author Phillip
 */
public class CommandInterpreter
{
    private final String PermissionCommandUser = "/regions";
    /**
     * Gibt Permissions.Admin für die Everywhere-Zone
     */
    private final String PermissionCommandAdmin = "/regionsadmin";
    private final String[] Command =
    {
        "regions","reg"
    };
    private final String[] CommandCreate =
    {
        "create","-c"
    };
    private final String[] CommandDelete =
    {
        "delete","-d"
    };
}
