package dev.projectearth.genoa_plugin.commands;

import com.nukkitx.protocol.bedrock.data.command.CommandParamType;
import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import com.nukkitx.protocol.bedrock.data.entity.EntityFlag;
import dev.projectearth.genoa_plugin.GenoaPlugin;
import dev.projectearth.genoa_plugin.entities.GenoaEntityTypes;
import org.cloudburstmc.server.command.Command;
import org.cloudburstmc.server.command.CommandSender;
import org.cloudburstmc.server.command.data.CommandData;
import org.cloudburstmc.server.command.data.CommandParameter;
import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.level.Location;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.registry.EntityRegistry;
import org.cloudburstmc.server.utils.Identifier;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * A basic test command for spawning entities.
 *
 * @author rtm516
 */
public class SummonCommand extends Command {

    public SummonCommand() {
        super("summon", CommandData.builder("summon")
                .setDescription("Summon an entity")
                .setUsageMessage("/summon <entity>")
                .setPermissions("genoa.command.summon")
                .setParameters(new CommandParameter[]{
                        new CommandParameter("id", CommandParamType.STRING, false)
                })
                .build());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        if (args.length == 0) {
            return false;
        }

        if (!(sender instanceof Player)) {
            return false;
        }

        EntityType<? extends Entity> entityType = EntityRegistry.get().getEntityType(Identifier.fromString(args[0]));

        if (entityType == null) {
            return false;
        }

        Location pos = ((Player) sender).getLocation();

        Entity ent = EntityRegistry.get().newEntity(entityType, pos);
        GenoaPlugin.get().getLogger().info("Spawning " + ent.getName() + " at " + pos.getPosition());
        ent.setPosition(pos.getPosition());
        ent.spawnToAll();

        return true;
    }
}
