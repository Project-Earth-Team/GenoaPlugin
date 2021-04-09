package dev.projectearth.genoa_plugin.providers;

import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import dev.projectearth.genoa_plugin.GenoaPlugin;
import dev.projectearth.genoa_plugin.utils.BuildplateEntity;
import dev.projectearth.genoa_plugin.utils.MobColor;
import lombok.RequiredArgsConstructor;
import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.level.Location;
import org.cloudburstmc.server.level.chunk.Chunk;
import org.cloudburstmc.server.level.chunk.ChunkDataLoader;
import org.cloudburstmc.server.registry.EntityRegistry;
import org.cloudburstmc.server.utils.Identifier;

import java.util.List;

@RequiredArgsConstructor
public class EntityDataLoader implements ChunkDataLoader {
    private final List<BuildplateEntity> entities;

    @Override
    public boolean load(Chunk chunk) {
        for (BuildplateEntity entity : entities) {
            try {
                Entity ent = EntityRegistry.get().newEntity(EntityRegistry.get().getEntityType(Identifier.fromString(entity.getName())), Location.from(entity.getPosition(), chunk.getLevel()));
                ent.setPosition(entity.getPosition());
                ent.setRotation(entity.getRotation().getX(), entity.getRotation().getY());
                ent.getData().setByte(EntityData.COLOR, MobColor.fromColorCode(entity.getChangeColor()).getBedrockID());
                GenoaPlugin.get().getLogger().info("Spawning " + ent.getName() + " at " + entity.getPosition() + " for level " + chunk.getLevel().getId());
            } catch (Exception e) {
                GenoaPlugin.get().getLogger().warn("Unknown entity type " + entity.getName(), e);
                return true;
            }
        }
        return false;
    }
}
