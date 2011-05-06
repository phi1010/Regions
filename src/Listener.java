
import java.util.logging.Logger;

public class Listener extends PluginListener
{
    private Regions _Plugin;

    public Listener(Regions plugin)
    {
        _Plugin = plugin;
    }

    @Override
    public void onLogin(Player player)
    {
    }

    @Override
    public boolean onCommand(Player player, String[] split)
    {
        return false;
    }

    @Override
    public boolean onConsoleCommand(String[] split)
    {
        return false;
    }

    @Override
    public boolean onBlockPlace(Player player, Block blockPlaced, Block blockClicked, Item itemInHand)
    {
        return false;
    }

    @Override
    public boolean onBlockDestroy(Player player, Block block)
    {
        return false;
    }

    @Override
    public boolean onBlockBreak(Player player, Block block)
    {
        return false;
    }

    @Override
    public boolean onOpenInventory(Player player, Inventory inventory)
    {
        return false;
    }

    @Override
    public void onPlayerMove(Player player, Location from, Location to)
    {
    }

    @Override
    public boolean onTeleport(Player player, Location from, Location to)
    {
        return false;
    }

    @Override
    public boolean onIgnite(Block block, Player player)
    {
        return false;
    }

    @Override
    public boolean onFlow(Block blockFrom, Block blockTo)
    {
        return false;
    }

    @Override
    public boolean onExplode(Block block)
    {
        return false;
    }

    @Override
    public boolean onMobSpawn(Mob mob)
    {
        return false;
    }

    @Override
    public boolean onDamage(PluginLoader.DamageType type, BaseEntity attacker, BaseEntity defender, int amount)
    {
        return false;
    }

    @Override
    public boolean onAttack(LivingEntity attacker, LivingEntity defender, Integer amount)
    {
        return false;
    }

    @Override
    public PluginLoader.HookResult onLiquidDestroy(PluginLoader.HookResult currentState, int liquidBlockId, Block targetBlock)
    {
        return PluginLoader.HookResult.DEFAULT_ACTION;
    }

    @Override
    public Boolean onVehicleCollision(BaseVehicle vehicle, BaseEntity collisioner)
    {
        return false;
    }

    @Override
    public boolean onHealthChange(Player player, int oldValue, int newValue)
    {
        return false;
    }

    @Override
    public boolean onItemPickUp(Player player, Item item)
    {
        return false;
    }

    @Override
    public boolean onItemDrop(Player player, Item item)
    {
        return false;
    }

}
