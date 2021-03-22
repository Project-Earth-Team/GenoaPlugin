package dev.projectearth.genoa_plugin.entities.neutral;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntitySnowGolem;
import org.cloudburstmc.server.entity.passive.SnowGolem;
import org.cloudburstmc.server.level.Location;

public class MelonGolem extends EntitySnowGolem {
    public MelonGolem(EntityType<SnowGolem> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Melon Golem";
    }
}
