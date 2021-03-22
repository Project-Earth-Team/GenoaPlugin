package dev.projectearth.genoa_plugin.commands;

import com.nukkitx.protocol.bedrock.data.command.CommandParamType;
import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import com.nukkitx.protocol.bedrock.data.entity.EntityFlag;
import dev.projectearth.genoa_plugin.GenoaPlugin;
import dev.projectearth.genoa_plugin.entities.GenoaEntityTypes;
import org.cloudburstmc.server.CloudServer;
import org.cloudburstmc.server.command.Command;
import org.cloudburstmc.server.command.CommandSender;
import org.cloudburstmc.server.command.data.CommandData;
import org.cloudburstmc.server.command.data.CommandParameter;
import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.level.Level;
import org.cloudburstmc.server.level.Location;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.registry.EntityRegistry;
import org.cloudburstmc.server.utils.Identifier;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * A basic test command for entities.
 *
 * @author rtm516
 */
public class TestEntCommand extends Command {

    public TestEntCommand() {
        super("testent", CommandData.builder("testent")
                .setDescription("Test entites")
                .setUsageMessage("/testent")
                .setPermissions("genoa.command.testent")
                .build());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        if (!(sender instanceof Player)) {
            return false;
        }

        Field[] fields = GenoaEntityTypes.class.getFields();
        List<EntityType<? extends Entity>> entityTypes = new ArrayList<>();
        for (Field field : fields) {
            if (field.getType().isAssignableFrom(EntityType.class)) {
                try {
                    entityTypes.add((EntityType<? extends Entity>) field.get(null));
                } catch (IllegalAccessException ignored) { }
            }
        }

        Location basePos = ((Player) sender).getLocation();
        int i = 0;
        for (EntityType<? extends Entity> entityType : entityTypes) {
            Location entPos = basePos.add((i % 10) * 5, 0, Math.floor(i / 10f) * 5);

            Entity ent = EntityRegistry.get().newEntity(entityType, entPos);

            GenoaPlugin.get().getLogger().info("Spawning " + ent.getName() + " at " + entPos.getPosition());

            ent.setPosition(entPos.getPosition());
            ent.setNameTag(ent.getName());
            ent.getData().setShort(EntityData.AIR_SUPPLY, Short.MAX_VALUE);
            ent.getData().setFlag(EntityFlag.ALWAYS_SHOW_NAME, true);
            ent.spawnToAll();

            i++;
        }

        return true;
    }
}
