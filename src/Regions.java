
import java.util.logging.Logger;

/**
 *
 * @author Phillip
 */
public class Regions extends Plugin
{
    private Listener l = new Listener(this);
    protected static final Logger log = Logger.getLogger("Minecraft");
    private String name = "Tresor";
    private String version = "1.0";
    

    public void enable()
    {
    }

    public void disable()
    {
    }

    @Override
    public void initialize()
    {
        log.info(name + " " + version + " initialized");
        etc.getLoader().addListener(PluginLoader.Hook.COMMAND, l, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.LOGIN, l, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.SERVERCOMMAND, l, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.BLOCK_BROKEN, l, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.BLOCK_PLACE, l, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.BLOCK_DESTROYED, l, this, PluginListener.Priority.MEDIUM);
        etc.getLoader().addListener(PluginLoader.Hook.OPEN_INVENTORY, l, this, PluginListener.Priority.MEDIUM);
    }

// Sends a message to all players!
    public void broadcast(String message)
    {
        for (Player p : etc.getServer().getPlayerList())
        {
            p.sendMessage(message);
        }
    }

}
