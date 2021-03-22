package dev.projectearth.genoa_plugin.entities.other;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.hostile.EntitySkeleton;
import org.cloudburstmc.server.entity.hostile.Skeleton;
import org.cloudburstmc.server.level.Location;

public class OobeSkeleton extends EntitySkeleton {
    public OobeSkeleton(EntityType<Skeleton> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "oobe_skeleton";
    }
}
