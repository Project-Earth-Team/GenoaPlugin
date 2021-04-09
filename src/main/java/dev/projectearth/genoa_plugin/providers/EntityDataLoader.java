package dev.projectearth.genoa_plugin.providers;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.nbt.NbtMap;
import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import com.nukkitx.protocol.bedrock.data.entity.EntityFlag;
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
import java.util.Map;

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
                for (Map.Entry<String, Object> entry : entity.getExtraData().entrySet()) {
                    try {
                        EntityData entityData = EntityData.valueOf(entry.getKey().toUpperCase());
                        switch (entityData.getType()) {
                            case BYTE:
                                ent.getData().setByte(entityData, (Integer) entry.getValue());
                                break;
                            case SHORT:
                                ent.getData().setShort(entityData, (Integer) entry.getValue());
                                break;
                            case INT:
                                ent.getData().setInt(entityData, (Integer) entry.getValue());
                                break;
                            case FLOAT:
                                ent.getData().setFloat(entityData, (Float) entry.getValue());
                                break;
                            case STRING:
                                ent.getData().setString(entityData, (String) entry.getValue());
                                break;
                            case NBT:
                                ent.getData().setTag(entityData, (NbtMap) entry.getValue());
                                break;
                            case VECTOR3I:
                                ent.getData().setVector3i(entityData, (Vector3i) entry.getValue());
                                break;
                            case LONG:
                                ent.getData().setLong(entityData, (Long) entry.getValue());
                                break;
                            case VECTOR3F:
                                ent.getData().setVector3f(entityData, (Vector3f) entry.getValue());
                                break;
                        }
                        continue;
                    } catch (IllegalArgumentException ignored) { }

                    try {
                        EntityFlag entityFlag = EntityFlag.valueOf(entry.getKey().replace("is_", "").toUpperCase());
                        ent.getData().setFlag(entityFlag, (Boolean) entry.getValue());
                    } catch (IllegalArgumentException ignored) { }
                }
                GenoaPlugin.get().getLogger().info("Spawning " + ent.getName() + " at " + entity.getPosition() + " for level " + chunk.getLevel().getId());
            } catch (Exception e) {
                GenoaPlugin.get().getLogger().warn("Unknown entity type " + entity.getName(), e);
                return true;
            }
        }
        return false;
    }
}
