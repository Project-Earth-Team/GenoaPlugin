package dev.projectearth.genoa_plugin.entities.hostile;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntityWolf;
import org.cloudburstmc.server.entity.passive.Wolf;
import org.cloudburstmc.server.level.Location;

public class SkeletonWolf extends EntityWolf {
    public SkeletonWolf(EntityType<Wolf> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Skeleton Wolf";
    }
}
