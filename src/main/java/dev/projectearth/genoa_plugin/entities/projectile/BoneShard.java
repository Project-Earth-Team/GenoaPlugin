package dev.projectearth.genoa_plugin.entities.projectile;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.projectile.EntityArrow;
import org.cloudburstmc.server.entity.projectile.Arrow;
import org.cloudburstmc.server.level.Location;

public class BoneShard extends EntityArrow {
    public BoneShard(EntityType<Arrow> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "bone_shard";
    }
}
