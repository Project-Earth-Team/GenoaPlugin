package dev.projectearth.genoa_plugin.entities.pig;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntityPig;
import org.cloudburstmc.server.entity.passive.Pig;
import org.cloudburstmc.server.level.Location;

public class SpottedPig extends EntityPig {
    public SpottedPig(EntityType<Pig> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Spotted Pig";
    }
}
